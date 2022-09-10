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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.lang.String.format;

@RunWith(Parameterized.class)
public class SeleniumTest {

    private static final String URL = "http://automationpractice.com/";
    private static WebDriver driver;

    private final String keyWord;
    private final WebDriverWait webDriverWait = new WebDriverWait(driver, 3);

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
        SeleniumConfig config = new SeleniumConfig();
        driver = config.getDriver();
        driver.manage().window().maximize();
    }

    @Before
    public void navigateToMainPage() {
        driver.get(URL);
    }

    @AfterClass
    public static void tearDown() {
        closeWindow();
    }

    @Test
    public void mainTest() {
        //в поле поиска вводим ключевое слово: 'Summer' и нажимаем значок поиска (лупу)
        String searchInputXPath = "//*[@id='search_query_top']";
        WebElement searchInput = webDriverWait.until(driver -> driver.findElement(By.xpath(searchInputXPath)));
        searchInput.sendKeys(this.keyWord);

        String searchButtonXPath = "//button[@class='btn btn-default button-search']";
        WebElement searchButton = driver.findElement(By.xpath(searchButtonXPath));
        searchButton.click();

        //проверяем, что над списком продуктов в надписи 'SEARCH' отображается наш поисковый запрос - "SUMMER"
        String searchResultNameXPath = "//h1[@class='page-heading  product-listing']/span[@class='lighter']";
        WebElement resultName = driver.findElement(By.xpath(searchResultNameXPath));
        Assert.assertEquals(format("\"%s\"", keyWord.toUpperCase()), resultName.getText());

        //открываем дропдаун сортировки и выбираем опцию 'Price: Highest first'
        String sortDropdownXPath = "//*[@id='selectProductSort']";
        String priceSortOptionXPath = format("%s/option[@value='price:desc']", sortDropdownXPath);
        driver.findElement(By.xpath(sortDropdownXPath)).click();
        driver.findElement(By.xpath(priceSortOptionXPath)).click();

        //проверяем, что элементы отсортированы в соответствии с выбранной опцией (сейчас сортировка идёт по старой цене
        // - если у товара есть скидка, нужно смотреть на старую цену)
        String ulListXPath = "//ul[@class='product_list grid row']";
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
        productContainer.findElement(By.xpath(
                format("%s/li[1]//a[@class='button ajax_add_to_cart_button btn btn-default']", ulListXPath))).click();

        //открываем корзину и сравниваем название и цену в колонке "Total" у товара, на соответствие с сохраненными значениями
        WebElement checkoutLink = webDriverWait.until(driver -> driver.findElement(
                By.xpath("//a[@class='btn btn-default button button-medium']")));
        checkoutLink.click();

        String nameFromBucket = webDriverWait.until(driver -> driver.findElement(
                By.xpath("//td//p[@class='product-name']")).getText());

        WebElement priceContainer = driver.findElement(By.xpath("//td[@class='cart_total']"));
        double priceFromBucket = getPriceFrom(priceContainer, false);

        Assert.assertEquals(String.valueOf(firstPrice), String.valueOf(priceFromBucket));
        Assert.assertEquals(firstName, nameFromBucket);
        driver.findElement(By.xpath("//a[@class='cart_quantity_delete']")).click();
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
