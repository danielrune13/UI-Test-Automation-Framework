package org.uiframework.com.utils;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    private Wait() {
        throw new UnsupportedOperationException("This is an utility class and cannot be instantiaded");
    }

    public static void browserWaitFor(int milliseconds) {
        try{
            Thread.sleep(milliseconds);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Thread was interrupted while waiting", e);
        }
    }

    public static void forElementToDisplay(WebElementFacade element){
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new WebDriverWait(Serenity.getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void forElementToDisappear(WebElementFacade element){
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new WebDriverWait(Serenity.getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void forElementToBeClickable(WebElementFacade element){
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new WebDriverWait(Serenity.getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
