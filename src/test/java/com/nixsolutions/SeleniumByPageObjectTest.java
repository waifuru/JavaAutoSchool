package com.nixsolutions;

import com.nixsolutions.pageobject.CartPage;
import com.nixsolutions.pageobject.CartProduct;
import com.nixsolutions.pageobject.MainPage;
import com.nixsolutions.task11.SeleniumConfig;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.lang.String.format;

@RunWith(Parameterized.class)
public class SeleniumByPageObjectTest {

    private static WebDriver driver;
    private static final String MAIN_PAGE_URL = "http://automationpractice.com/";

    private final String keyWord;

    public SeleniumByPageObjectTest(String keyWord) {
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
        driver.get(MAIN_PAGE_URL);
    }

    @AfterClass
    public static void tearDown() {
        closeWindow();
    }

    @Test
    public void seleniumTaskByPageObjectTest() {
        //в поле поиска вводим ключевое слово: 'Summer' и нажимаем значок поиска (лупу)
        MainPage mainPage = new MainPage(driver);
        mainPage.enterSearchText(keyWord).clickSearchButton();

        //проверяем, что над списком продуктов в надписи 'SEARCH' отображается наш поисковый запрос - "SUMMER"
        Assert.assertEquals(format("\"%s\"", keyWord.toUpperCase()), mainPage.getSearchResultHeadingName());

        //открываем дропдаун сортировки и выбираем опцию 'Price: Highest first'
        //проверяем, что элементы отсортированы в соответствии с выбранной опцией (сейчас сортировка идёт по старой цене
        // - если у товара есть скидка, нужно смотреть на старую цену)
        mainPage.sortSearchResultByHighestPrice().getAllDisplayedProductsPrices().stream()
                .reduce((current, next) -> {
                    Assert.assertTrue(current >= next);
                    return next;
                });

        //берем первый из найденных товаров и запоминаем его полное название и цену
        double firstPrice = mainPage.getFirstProductPrice();
        String firstName = mainPage.getFirstProductName();

        //добавляем его в корзину
        //открываем корзину и сравниваем название и цену в колонке "Total" у товара, на соответствие с сохраненными значениями
        CartPage cartPage = mainPage.addFirstProductToTheCart().openCart();
        List<CartProduct> productsFromCart = cartPage.getProductsFromCart();
        CartProduct firstProduct = productsFromCart.get(0);
        String nameFromBucket = firstProduct.getName();
        double priceFromBucket = firstProduct.getTotalPrice();

        Assert.assertEquals(String.valueOf(firstPrice), String.valueOf(priceFromBucket));
        Assert.assertEquals(firstName, nameFromBucket);

        cartPage.deleteProductFromCart(1);
    }

    private static void closeWindow() {
        driver.close();
    }

}
