package org.uiframework.com.locators;

import org.openqa.selenium.By;

public class ProductDetailsPage {
    private ProductDetailsPage() {
        throw new UnsupportedOperationException("This is a locator-only class and cannot be instantiaded");
    }

    public static final By BACK_TO_PRODUCTS = By.id("back-to-products");
    public static final By PRODUCT_TITLE = By.cssSelector("div[data-test='inventory-item-name']");
    public static final By PRODUCT_DESCRIPTION = By.cssSelector("div[data-test='inventory-item-desc']");
    public static final By PRODUCT_PRICE = By.cssSelector("div[data-test='inventory-item-price']");
    public static final By PRODUCT_IMAGE = By.cssSelector("img.inventory_details_img");
    public static final By ADD_TO_CART_BUTTON = By.xpath("//button[text()='Add to cart']");
}
