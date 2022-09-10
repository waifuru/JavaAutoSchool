package com.nixsolutions.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends ClothShopPage {

    private final By searchInputLocator = By.xpath("//*[@id='search_query_top']");
    private final By searchButtonLocator = By.xpath("//button[@class='btn btn-default button-search']");
    private final By searchResultNameLocator = By.xpath("//h1[@class='page-heading  product-listing']/span[@class='lighter']");
    private final By sortDropdownLocator = By.xpath("//*[@id='selectProductSort']");
    private final By priceSortOptionLocator = By.xpath("//*[@id='selectProductSort']/option[@value='price:desc']");
    private final By productListLocator = By.xpath("//ul[@class='product_list grid row']");
    private final By priceDivsLocator = By.xpath("//div[@class='content_price']");
    private final By productContainerLocator = By.xpath("//div[@class='product-container']");
    private final By firstProductAddToCartButton = By.xpath(
            "//ul[@class='product_list grid row']/li[1]//a[@class='button ajax_add_to_cart_button btn btn-default']");
    private final By checkoutButtonLocator = By.xpath("//a[@class='btn btn-default button button-medium']");
    private final By moreInfoButtonLocator = By.xpath("//a[@class='button lnk_view btn btn-default']");
    private final By increaseQuantityButtonLocator = By.xpath("//a[@class='btn btn-default button-plus product_quantity_up']");
    private final By sizeSelectLocator = By.xpath("//select[@class='form-control attribute_select no-print']");
    private final String sizeOptionXpath = "//option[@title='%s']";
    private final String colorPickXpath = "//a[@name='%s']";
    private final By addProductToCartButtonLocator = By.xpath("//button[@class='exclusive']");
    private final By successfullyAddedProductModalLocator = By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']");
    private final By continueShoppingButtonLocator = By.xpath("//span[@class='continue btn btn-default button exclusive-medium']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage enterSearchText(String searchText) {
        WebElement searchInput = webDriverWait.until(driver -> driver.findElement(searchInputLocator));
        searchInput.clear();
        searchInput.sendKeys(searchText);
        return this;
    }

    public MainPage clickSearchButton() {
        WebElement searchButton = driver.findElement(searchButtonLocator);
        searchButton.click();
        return this;
    }

    public String getSearchResultHeadingName() {
        WebElement resultName = driver.findElement(searchResultNameLocator);
        return resultName.getText();
    }

    public MainPage sortSearchResultByHighestPrice() {
        driver.findElement(sortDropdownLocator).click();
        driver.findElement(priceSortOptionLocator).click();
        return this;
    }

    public List<Double> getAllDisplayedProductsPrices() {
        WebElement ulList = driver.findElement(productListLocator);
        List<WebElement> priceDivs = ulList.findElements(priceDivsLocator);
        return priceDivs.stream()
                .map(priceDiv -> {
                    double priceFromDiv = getPriceFrom(priceDiv, true);
                    System.out.println(priceFromDiv);
                    return priceFromDiv;
                }).collect(Collectors.toList());
    }

    public double getFirstProductPrice() {
        WebElement ulList = driver.findElement(productListLocator);
        List<WebElement> priceDivs = ulList.findElements(priceDivsLocator);
        WebElement firstItem = priceDivs.get(0);
        return getPriceFrom(firstItem, false);
    }

    public String getFirstProductName() {
        WebElement productContainer = driver.findElement(productContainerLocator);
        return productContainer.findElement(By.className("product-name")).getAttribute("title");
    }

    public MainPage addFirstProductToTheCart() {
        WebElement productContainer = navigateToFirstProductContainer();
        productContainer.findElement(firstProductAddToCartButton).click();
        return this;
    }

    private WebElement navigateToFirstProductContainer() {
        WebElement productContainer = webDriverWait.until(driver -> driver.findElement(productContainerLocator));
        new Actions(driver)
                .moveToElement(productContainer)
                .perform();
        return productContainer;
    }

    public CartPage openCart() {
        WebElement checkoutLink = webDriverWait.until(driver -> driver.findElement(checkoutButtonLocator));
        checkoutLink.click();
        return new CartPage(driver);
    }

    public MainPage clickOnMoreForFirstProduct() {
        navigateToFirstProductContainer();
        WebElement moreButton = driver.findElement(moreInfoButtonLocator);
        moreButton.click();
        return this;
    }

    public MainPage increaseQuantity(int increaseNumber) {
        WebElement increaseQuantityButton =
                webDriverWait.until(driver -> driver.findElement(increaseQuantityButtonLocator));
        for (int i = 0; i < increaseNumber; i++) {
            increaseQuantityButton.click();
        }
        return this;
    }

    public MainPage setProductSize(String size) {
        WebElement sizeSelectElement = driver.findElement(sizeSelectLocator);
        sizeSelectElement.click();
        driver.findElement(By.xpath(String.format(sizeOptionXpath, size))).click();
        return this;
    }

    public MainPage setProductColor(String color) {
        driver.findElement(By.xpath(String.format(colorPickXpath, color))).click();
        return this;
    }

    public MainPage addCurrentProductToCart() {
        driver.findElement(addProductToCartButtonLocator).click();
        return this;
    }

    public boolean isSuccessfullyAddedProductModalShown() {
        String text = webDriverWait.until(driver ->
                driver.findElement(successfullyAddedProductModalLocator)).getAttribute("innerHTML");
        return text.contains("Product successfully added to your shopping cart");
    }

    public MainPage continueShopping() {
        driver.findElement(continueShoppingButtonLocator).click();
        return this;
    }

}
