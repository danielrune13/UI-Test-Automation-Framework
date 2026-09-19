package org.uiframework.com.locators;

import org.openqa.selenium.By;

public class Cart {
    private Cart() {
        throw new UnsupportedOperationException("This is a locator-only class and cannot be instantiaded");
    }

    public static final By PRODUCT = By.cssSelector("div.cart_item");
    public static final By PRODUCT_TITLE = By.xpath("./div[@class='cart_item_label']//div[@class='inventory_item_name']");
    public static final By PRODUCT_PRICE = By.xpath("./div[@class='cart_item_label']//div[@class='inventory_item_price']");
    public static final By REMOVE_PRODUCT = By.xpath("//button[text()='Remove']");
    public static final By CONTINUE_SHOPPING = By.id("continue-shopping");
    public static final By CHECKOUT = By.id("checkout");
}
