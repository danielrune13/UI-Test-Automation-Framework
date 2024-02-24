package org.hashiro.maven.locators;

import org.openqa.selenium.By;

public class LoginPage {
    public static final By MAIN_TITLE = By.cssSelector(".login_logo");

    public static final By USERNAME_INPUT = By.cssSelector("input#user-name");
    public static final By PASSWORD_INPUT = By.cssSelector("input#password");
    public static final By LOGIN_BUTTON = By.cssSelector("input[name='login-button']");

    public static final By LOCKED_OUT_ERROR = By.xpath("//h3[contains(text(), 'Sorry, this user has been locked out')]");
}
