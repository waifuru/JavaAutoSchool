package com.nixsolutions.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class ClothShopPage {

    protected final WebDriver driver;
    protected final WebDriverWait webDriverWait;

    public ClothShopPage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 10);
    }

    protected double getPriceFrom(WebElement spansContainer, boolean retainOldPrice) {
        List<WebElement> spans = spansContainer.findElements(By.xpath("./child::span"));
        double price = -1d;
        for (WebElement span : spans) {
            String className = span.getAttribute("class");
            String priceValue = "";
            if (retainOldPrice && className.contains("old-price") ||
                    (className.contains("price product-price") || className.contains("price special-price")
                            || className.equals("price")) && price == -1) {
                priceValue = span.getAttribute("innerHTML");
            }
            if (priceValue.isEmpty()) continue;
            price = Double.parseDouble(priceValue.trim().substring(1));
        }
        return price;
    }

}
