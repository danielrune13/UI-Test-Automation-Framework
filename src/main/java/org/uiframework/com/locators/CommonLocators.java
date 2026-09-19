package org.uiframework.com.locators;

import org.openqa.selenium.By;
import org.uiframework.com.domain.Page;

public class CommonLocators {
    private CommonLocators() {
        throw new UnsupportedOperationException("This is a locator-only class and cannot be instantiaded");
    }

    // Cart Icon
    public static final By CART_ICON = By.cssSelector("a.shopping_cart_link");
    public static final By CART_ICON_NUMBER = By.cssSelector("a.shopping_cart_link > span");

    public static By getPageTitle(Page page){
        return By.xpath("//span[@class='title'][text()='" + page.getTitle() + "']");
    }

    public static By getErrorMessage(String message){
        return By.xpath("//h3[@data-test='error'][contains(text(), '" + message + "')]");
    }
}
