package com.nixsolutions.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class CartPage extends ClothShopPage {

    private final By productTableRowLocator = By.xpath("//tr[contains(@class,'cart_item')]");
    private final By deleteFromCartButtonLocator = By.xpath("//a[@class='cart_quantity_delete']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<CartProduct> getProductsFromCart() {
        List<CartProduct> products = new ArrayList<>();
        List<WebElement> productRows = driver.findElements(productTableRowLocator);
        String productNameXpath = "//tr[@id='%s']/td//p[@class='product-name']";
        String unitPriceXpath = "//tr[@id='%s']/td[@class='cart_unit']/span";
        String colorAndSizeXpath = "//tr[@id='%s']/td[@class='cart_description']/small/a";
        String quantityXpath = "//tr[@id='%s']/td[@class='cart_quantity text-center']/input[@type='text']";
        String totalPriceXpath = "//tr[@id='%s']/td[@class='cart_total']";
        for (WebElement productRow : productRows) {
            String id = productRow.getAttribute("id");
            String name = productRow.findElement(By.xpath(format(productNameXpath, id))).getText();
            String[] colorAndSize = productRow.findElement(By.xpath(format(colorAndSizeXpath, id))).getText().split(",");
            String color = colorAndSize[0].split(":")[1].trim();
            String size = colorAndSize[1].split(":")[1].trim();
            double unitPrice = getPriceFrom(productRow.findElement(By.xpath(format(unitPriceXpath, id))), false);
            int quantity = Integer.parseInt(productRow.findElement(By.xpath(format(quantityXpath, id))).getAttribute("value"));
            double totalPrice = getPriceFrom(productRow.findElement(By.xpath(format(totalPriceXpath, id))), false);
            products.add(new CartProduct()
                    .setName(name)
                    .setColor(color)
                    .setSize(size)
                    .setUnitPrice(unitPrice)
                    .setQuantity(quantity)
                    .setTotalPrice(totalPrice));
        }
        return products;
    }

    public void deleteProductFromCart(int productPosition) {
        driver.findElements(deleteFromCartButtonLocator).get(productPosition - 1).click();
    }

}
