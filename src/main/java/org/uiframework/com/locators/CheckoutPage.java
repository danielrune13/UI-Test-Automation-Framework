package org.uiframework.com.locators;

import org.openqa.selenium.By;

public class CheckoutPage {
    private CheckoutPage() {
        throw new UnsupportedOperationException("This is a locator-only class and cannot be instantiaded");
    }

    // Common
    public static final By CANCEL = By.id("cancel");


    // Checkout: Your Information
    public static final By FIRST_NAME = By.id("first-name");
    public static final By LAST_NAME = By.id("last-name");
    public static final By POSTAL_CODE = By.id("postal-code");
    public static final By CONTINUE = By.id("continue");

    // Checkout: Overview
    public static final By PRODUCTS = By.cssSelector("div.cart_item");
    public static final By PAYMENT_INFORMATION = By.cssSelector("div[data-test='payment-info-value']");
    public static final By SHIPPING_INFORMATION = By.cssSelector("div[data-test='shipping-info-label']");
    public static final By SUB_TOTAL = By.cssSelector("div[data-test='subtotal-label']");
    public static final By TAX = By.cssSelector("div[data-test='tax-label']");
    public static final By TOTAL_PRICE = By.cssSelector("div[data-test='total-label']");
    public static final By FINISH = By.id("finish");

    // Checkout: Complete!
    public static final By CHECKOUT_COMPLETE_HEADER = By.cssSelector("h2.complete-header");
    public static final By CHECKOUT_COMPLETE_MESSAGE = By.cssSelector("div.complete-text");
    public static final By BACK_HOME = By.id("back-to-products");
    public static final By GENERATE_PDF_ORDER = By.id("generate-pdf-order");
}
