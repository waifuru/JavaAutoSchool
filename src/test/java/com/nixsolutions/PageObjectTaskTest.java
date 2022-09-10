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
import org.openqa.selenium.WebDriver;

import java.util.List;

public class PageObjectTaskTest {

    private static WebDriver driver;
    private static final String MAIN_PAGE_URL = "http://automationpractice.com/";

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
    public void pageObjectTaskTest() {
        //В поле поиска вводим ключевое слово: 'Blouse' и нажимаем значок поиска
        MainPage mainPage = new MainPage(driver);
        mainPage.enterSearchText("Blouse").clickSearchButton()
                //Кликаем по "More" для первого найденного товара
                .clickOnMoreForFirstProduct()
                //На деталях товара ставим Quantity = 3, Size = L, Color = white
                .increaseQuantity(2).setProductSize("L").setProductColor("White")
                //Кликаем по "Add to cart" кнопке
                .addCurrentProductToCart();
        //Убеждаемся что появилась модалка c названием "Product successfully added to your shopping cart"
        Assert.assertTrue(mainPage.isSuccessfullyAddedProductModalShown());
        //В открывшейся модалке кликаем по "Continue shopping"
        mainPage.continueShopping()
                //В поле поиска вводим "Printed summer dress" и нажимаем значок поиска
                .enterSearchText("Printed summer dress").clickSearchButton()
                //Кликаем по "More" для первого найденного товара
                .clickOnMoreForFirstProduct()
                //На деталях товара ставим Quantity = 5, Size = M, Color = Orange
                .increaseQuantity(4).setProductSize("M").setProductColor("Orange")
                //Кликаем по "Add to cart" кнопке
                .addCurrentProductToCart();
        //Убеждаемся что появилась модалка c названием "Product successfully added to your shopping cart"
        Assert.assertTrue(mainPage.isSuccessfullyAddedProductModalShown());
        //Кликаем по "Proceed to checkout" кнопке
        CartPage cartPage = mainPage.openCart();
        //На открывшейся странице, убеждаемся что для каждого из 2-ух добавленных продуктов показываются верные:
        //Имя, цвет, размер, цена за один товар(Unit price), количество товаров, общая цена с учетом количества товаров(Total)
        List<CartProduct> productsFromCart = cartPage.getProductsFromCart();
        CartProduct blouse = productsFromCart.get(0);
        Assert.assertEquals("Blouse", blouse.getName());
        Assert.assertEquals("White", blouse.getColor());
        Assert.assertEquals("L", blouse.getSize());
        Assert.assertEquals(27.0, blouse.getUnitPrice(), 0);
        Assert.assertEquals(3, blouse.getQuantity());
        Assert.assertEquals(27.0 * 3, blouse.getTotalPrice(), 0);
        CartProduct printedSummerDress = productsFromCart.get(1);
        Assert.assertEquals("Printed Summer Dress", printedSummerDress.getName());
        Assert.assertEquals("Orange", printedSummerDress.getColor());
        Assert.assertEquals("M", printedSummerDress.getSize());
        Assert.assertEquals(28.98, printedSummerDress.getUnitPrice(), 0);
        Assert.assertEquals(5, printedSummerDress.getQuantity());
        Assert.assertEquals(28.98 * 5, printedSummerDress.getTotalPrice(), 0);
        //Кликаем по знаку корзины напротив "Printed summer dress"
        cartPage.deleteProductFromCart(2);
        //Убеждаемся что в таблице остался только товар "Blouse"
        List<CartProduct> productsFromUpdatedCart = cartPage.getProductsFromCart();
        Assert.assertEquals(1, productsFromUpdatedCart.size());
        Assert.assertEquals("Blouse", productsFromUpdatedCart.get(0).getName());
    }

    private static void closeWindow() {
        driver.close();
    }

}
