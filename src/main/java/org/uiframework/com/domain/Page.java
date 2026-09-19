package org.uiframework.com.domain;

public enum Page {
    LOGIN("Login", null),
    PRODUCT_LIST("Product List", "Products"),
    PRODUCT_DETAILS("Product Details", null),
    CART("Cart", "Your Cart"),
    CHECKOUT_YOUR_INFORMATION("Checkout: Your Information", "Checkout: Your Information"),
    CHECKOUT_OVERVIEW("Checkout: Overview", "Checkout: Overview"),
    CHECKOUT_COMPLETE("Checkout: Complete!", "Checkout: Complete!");

    public final String text;
    public final String title; // Title present on the page

    Page(final String text, String title) {
        this.text = text;
        this.title = title;
    }

    @Override
    public String toString() {
        return this.text;
    }
    public String getTitle() {
        return this.title;
    }

    public static Page fromString(String text) {
        for (Page b : Page.values()) {
            if (b.text.equalsIgnoreCase(text)){
                return b;
            }
        }
        throw new IllegalArgumentException("Invalid page: " + text);
    }
}
