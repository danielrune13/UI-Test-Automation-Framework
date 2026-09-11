package org.uiframework.com.utils;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;

public class WindowUtils {
    public static void switchToWindowByIndex(int index) {
        WebDriver driver = Serenity.getDriver();
        Object[] windowHandles = driver.getWindowHandles().toArray();
        String windowHandle = windowHandles[index].toString();
        driver.switchTo().window(windowHandle);
    }

    public static void switchToWindowByTitle(String title){
        WebDriver driver = Serenity.getDriver();
        boolean windowFound = false;

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            String windowTitle = driver.getTitle();
            if (windowTitle.contains(title)) {
                windowFound = true;
                break;
            }
        }

        if (!windowFound) {
            throw new NoSuchWindowException("Window with title '" + title + "' not found");
        }
    }

    public static void closeOtherWindows(){
        WebDriver driver = Serenity.getDriver();
        Object[] windowHandles = driver.getWindowHandles().toArray();
        String currentHandle = driver.getWindowHandle();

        for (Object handle : windowHandles) {
            String handleStr = handle.toString();
            if (!handleStr.equals(currentHandle)) {
                driver.switchTo().window(handleStr);
                driver.close();
            }
        }
        driver.switchTo().window(currentHandle);
    }
}
