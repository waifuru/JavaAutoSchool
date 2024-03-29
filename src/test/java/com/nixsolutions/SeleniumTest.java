package com.nixsolutions;

import com.nixsolutions.task11.SeleniumConfig;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class SeleniumTest {

    private static SeleniumConfig config;
    private static final String url = "http://automationpractice.com/";
    private static WebDriver driver;

    private String keyWord;

    public SeleniumTest(String keyWord) {
        this.keyWord = keyWord;
    }

    //используя аннотацию параметризации тестов, добавьте кроме 'Summer' сценарии поиска 'Dress' и 't-shirt'
    @Parameters(name = "{index}: {0}")
    public static Collection<String> data() {
        return Arrays.asList("Summer", "Dress", "t-shirt");
    }

    @BeforeClass
    public static void setUp() {
        config = new SeleniumConfig();
        driver = config.getDriver();
    }

    @Before
    public void navigateToMainPage() throws InterruptedException {
        driver.get(url);
        Thread.sleep(3000);
    }

    @AfterClass
    public static void tearDown() {
        closeWindow();
    }

    @Test
    public void mainTest() throws InterruptedException {
        //в поле поиска вводим ключевое слово: 'Summer' и нажимаем значок поиска (лупу)
        String searchInputXPath = "/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/input[4]";
        WebElement searchInput = driver.findElement(By.xpath(searchInputXPath));
        searchInput.sendKeys(this.keyWord);

        String searchButtonXPath = "/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/button";
        WebElement searchButton = driver.findElement(By.xpath(searchButtonXPath));
        searchButton.click();

        //проверяем, что над списком продуктов в надписи 'SEARCH' отображается наш поисковый запрос - "SUMMER"
        String searchResultNameXPath = "/html/body/div/div[2]/div/div[3]/div[2]/h1/span[1]";
        WebElement resultName = driver.findElement(By.xpath(searchResultNameXPath));
        Assert.assertEquals("\"" + keyWord.toUpperCase() + "\"", resultName.getText());

        //открываем дропдаун сортировки и выбираем опцию 'Price: Highest first'
        String sortDropdownXPath = "/html/body/div/div[2]/div/div[3]/div[2]/div[1]/div[1]/form/div/div/select";
        String priceSortOptionXPath = "/html/body/div/div[2]/div/div[3]/div[2]/div[1]/div[1]/form/div/div/select/option[3]";
        driver.findElement(By.xpath(sortDropdownXPath)).click();
        driver.findElement(By.xpath(priceSortOptionXPath)).click();

        //проверяем, что элементы отсортированы в соответствии с выбранной опцией (сейчас сортировка идёт по старой цене
        // - если у товара есть скидка, нужно смотреть на старую цену)
        String ulListXPath = "/html/body/div/div[2]/div/div[3]/div[2]/ul";
        WebElement ulList = driver.findElement(By.xpath(ulListXPath));
        List<WebElement> priceDivs = ulList.findElements(By.xpath("//div[@class='content_price']"));
        priceDivs.stream()
                .map(priceDiv -> {
                    double priceFromDiv = getPriceFrom(priceDiv, true);
                    System.out.println(priceFromDiv);
                    return priceFromDiv;
                })
                .reduce((current, next) -> {
                    Assert.assertTrue(current >= next);
                    return next;
                });

        //берем первый из найденных товаров и запоминаем его полное название и цену
        WebElement firstItem = priceDivs.get(0);
        double firstPrice = getPriceFrom(firstItem, false);
        WebElement productContainer = driver.findElement(By.xpath("//div[@class='product-container']"));
        String firstName = productContainer.findElement(By.className("product-name")).getAttribute("title");

        //добавляем его в корзину
        new Actions(driver)
                .moveToElement(productContainer)
                .perform();
        productContainer.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]")).click();

        //открываем корзину и сравниваем название и цену в колонке "Total" у товара, на соответствие с сохраненными значениями
        Thread.sleep(2000);
        WebElement checkoutLink = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"));
        checkoutLink.click();

        Thread.sleep(2000);
        String nameFromBucket = driver.findElement(By.xpath(
                "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[2]/p/a")).getText();

        WebElement priceContainer = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[6]"));
        double priceFromBucket = getPriceFrom(priceContainer, false);

        Assert.assertEquals(String.valueOf(firstPrice), String.valueOf(priceFromBucket));
        Assert.assertEquals(firstName, nameFromBucket);
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[1]/td[7]/div/a")).click();
    }

    private static double getPriceFrom(WebElement spansContainer, boolean retainOldPrice) {
        List<WebElement> spans = spansContainer.findElements(By.xpath("./child::span"));
        double price = -1d;
        for (WebElement span : spans) {
            String className = span.getAttribute("class");
            String priceValue = "";
            if (retainOldPrice && className.contains("old-price") ||
                    (className.contains("price product-price") || className.equals("price")) && price == -1) {
                priceValue = span.getAttribute("innerHTML");
            }
            if (priceValue.isEmpty()) continue;
            price = Double.parseDouble(priceValue.trim().substring(1));
        }
        return price;
    }

    private static void closeWindow() {
        driver.close();
    }
}
