package org.uiframework.com.locators;

import org.openqa.selenium.By;

public class LoginPage {
    private LoginPage() {
        throw new UnsupportedOperationException("This is a locator-only class and cannot be instantiaded");
    }

    public static final By LOGIN_PAGE_TITLE = By.cssSelector(".login_logo");

    public static final By USERNAME_INPUT = By.cssSelector("input#user-name");
    public static final By PASSWORD_INPUT = By.cssSelector("input#password");
    public static final By LOGIN_BUTTON = By.cssSelector("input[name='login-button']");
}
