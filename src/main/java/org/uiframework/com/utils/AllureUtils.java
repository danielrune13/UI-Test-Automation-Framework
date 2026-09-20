package org.uiframework.com.utils;

import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllureUtils {
    private AllureUtils() {
        throw new UnsupportedOperationException("This is an utility class and cannot be instantiaded");
    }

    public static void createEnvironmentFile() throws IOException {
        Path resultsDirectory = Path.of("target/allure-results");
        Files.createDirectories(resultsDirectory);

        WebDriver driver = ((WebDriverFacade) Serenity.getDriver()).getProxiedDriver();
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = caps.getBrowserName();
        String browserVersion = caps.getBrowserVersion();
        String operativeSystem = System.getProperty("os.name");
        String javaVersion = System.getProperty("java.version");
        String runningEnvironment = System.getProperty("spring.profiles.active");

        String environment = String.format("""
                Browser=%s
                Browser_Version=%s
                Operating_System=%s
                Java_Version=%s
                Environment=%s
                """, browserName, browserVersion, operativeSystem, javaVersion, runningEnvironment);

        Files.writeString(
                resultsDirectory.resolve("environment.properties"),
                environment
        );
    }

    public static void addFailureInformation() {
        byte[] screenshot = ((TakesScreenshot) Serenity.getDriver()).getScreenshotAs(OutputType.BYTES);

        Allure.attachment("Screenshot", new ByteArrayInputStream(screenshot));
    }
}
