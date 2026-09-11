package org.uiframework.com.utils;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ElementUtils {
    public static void click(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) Serenity.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void scrollIntoView(WebElement element){
        JavascriptExecutor je = (JavascriptExecutor) Serenity.getDriver();
        je.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    public static void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void scrollByAmount(int amount){
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
        js.executeScript("window.scrollBy(0, " + amount + ");");
    }

    public static void hoverOverElement(WebElement element){
        Actions action = new Actions(Serenity.getDriver());
        action.moveToElement(element).perform();
    }

    public static void pressKey(Keys key) {
        Actions action = new Actions(Serenity.getDriver());
        action.sendKeys(key).build().perform();
    }
}
