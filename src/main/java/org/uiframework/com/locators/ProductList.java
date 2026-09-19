package org.uiframework.com.locators;

import org.openqa.selenium.By;

public class ProductList {
    private ProductList() {
        throw new UnsupportedOperationException("This is a locator-only class and cannot be instantiaded");
    }

    public static final By SORT_DROPDOWN = By.cssSelector("select.product_sort_container");
    public static final By ADDABLE_PRODUCT = By.xpath("//div[@class='inventory_item'][.//button[text()='Add to cart']]");
    public static final By PRODUCT_TITLE = By.cssSelector("[data-test='inventory-item-name']");
    public static final By PRODUCT_IMAGE = By.cssSelector("div.inventory_item_img > a");
    public static final By PRODUCT_PRICE = By.cssSelector(".inventory_item_price");
    public static final By ADD_TO_CART_BUTTON = By.xpath(".//button[text()='Add to cart']");
}
