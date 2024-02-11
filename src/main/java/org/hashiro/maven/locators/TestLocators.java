package org.hashiro.maven.locators;

import org.hashiro.maven.actions.BasePage;
import org.openqa.selenium.By;

public class TestLocators extends BasePage {

    public static final By USERNAME_INPUT = By.cssSelector("input#username");
    public static final By PASSWORD_INPUT = By.cssSelector("input#password");
    public static final By CONTINUE_LOGIN = By.cssSelector("button#login-submit");
    public static final By LANDING_PAGE_TITLE = By.xpath("//h1[text()='Your work']");

}
