package org.uiframework.com.locators;

import org.openqa.selenium.By;

public class SideMenu {
    private SideMenu() {
        throw new UnsupportedOperationException("This is a locator-only class and cannot be instantiaded");
    }

    public static final By SIDE_MENU_BUTTON = By.id("react-burger-menu-btn");

    public static By getSideMenuOption(String option){
        return By.xpath("//nav/a[text()='" + option + "']");
    }
}
