package com.nixsolutions;

import com.nixsolutions.task11.SeleniumConfig;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SeleniumTest {

    private static SeleniumConfig config;
    private static final String url = "http://automationpractice.com/";
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        config = new SeleniumConfig();
        driver = config.getDriver();
        driver.get(url);
    }

    @AfterClass
    public static void tearDown() {
        //closeWindow();
    }

    @Test
    public void getTitleTest() {
        String title = driver.getTitle();
        Assert.assertEquals("My Store", title);
    }

    @Test
    public void mainTest() {
        //в поле поиска вводим ключевое слово: 'Summer' и нажимаем значок поиска (лупу)
        String searchInputXPath = "/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/input[4]";
        WebElement searchInput = driver.findElement(By.xpath(searchInputXPath));
        searchInput.sendKeys("Summer");

        String searchButtonXPath = "/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/button";
        WebElement searchButton = driver.findElement(By.xpath(searchButtonXPath));
        searchButton.click();

        //проверяем, что над списком продуктов в надписи 'SEARCH' отображается наш поисковый запрос - "SUMMER"
        String searchResultNameXPath = "/html/body/div/div[2]/div/div[3]/div[2]/h1/span[1]";
        WebElement resultName = driver.findElement(By.xpath(searchResultNameXPath));
        Assert.assertEquals("\"SUMMER\"", resultName.getText());

        //открываем дропдаун сортировки и выбираем опцию 'Price: Highest first'
        String sortDropdownXPath = "/html/body/div/div[2]/div/div[3]/div[2]/div[1]/div[1]/form/div/div/select";
        String priceSortOptionXPath = "/html/body/div/div[2]/div/div[3]/div[2]/div[1]/div[1]/form/div/div/select/option[3]";
        driver.findElement(By.xpath(sortDropdownXPath)).click();
        driver.findElement(By.xpath(priceSortOptionXPath)).click();

        //проверяем, что элементы отсортированы в соответствии с выбранной опцией (сейчас сортировка идёт по старой цене
        // - если у товара есть скидка, нужно смотреть на старую цену)
        String newPriceXPath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[1]/span[1]";
        String oldPriceXPath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[1]/span[2]";


        //берем первый из найденных товаров и запоминаем его полное название и цену
        //добавляем его в корзину
        //открываем корзину и сравниваем название и цену в колонке "Total" у товара, на соответствие с сохраненными значениями
        //используя аннотацию параметризации тестов, добавьте кроме 'Summer' сценарии поиска 'Dress' и 't-shirt'
    }


    private static void closeWindow() {
        driver.close();
    }

    private void closeOverlay() {
        List<WebElement> webElementList = this.driver
                .findElements(By.tagName("a"));
        if (webElementList != null) {
            webElementList.stream()
                    .filter(webElement -> "Close".equalsIgnoreCase(webElement.getAttribute("title")))
                    .filter(WebElement::isDisplayed)
                    .findAny()
                    .ifPresent(WebElement::click);
        }
    }

    private void clickAboutLink() {
        Actions actions = new Actions(driver);
        WebElement aboutElement = this.driver
                .findElement(By.id("menu-item-6138"));

        actions.moveToElement(aboutElement).perform();
    }

    private void clickAboutUsLink() {
        WebElement element = this.driver
                .findElement(By.partialLinkText("About Baeldung."));
        element.click();
    }

    public boolean isAuthorInformationAvailable() {
        return this.driver
                .getPageSource()
                .contains("Hey ! I'm Eugen");
    }
}
