package org.uiframework.com.utils;

import net.serenitybdd.core.webdriver.RemoteDriver;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;

import java.io.*;

import static org.openqa.selenium.remote.http.Contents.string;

public class FileDownload extends PageObject {
    public String getTheNameOfTheLastDownloadedFile() {
        // Retrieving the name of the last downloaded file from the Downloads page
        String script = "";
        String url = "";

        if (RemoteDriver.of(getDriver()).getCapabilities().getBrowserName().contains("firefox")) {
            url = "about:downloads";
            script = "return document.querySelector('#contentAreaDownloadsView .downloadMainArea .downloadContainer description:nth-of-type(1)').value";
        } else if (RemoteDriver.of(getDriver()).getCapabilities().getBrowserName().contains("chrome")) {
            int majorVersion = Integer.parseInt(RemoteDriver.of(getDriver()).getCapabilities().getBrowserVersion().split("\\.")[0]);
            url = "chrome://downloads/";
            if(majorVersion <= 146) {
                script = "return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('#file-link').textContent";
            }else {
                script = "return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('#fileLink').textContent";
            }
        }

        openUrl(url);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        String fileName = js.executeScript(script).toString();
        System.out.println("\n" + "The fileName is : " + fileName +" \n");
        return fileName;
    }

    public static File getFileFromLocation(String filePath, String fileName) {
        File dir = new File(filePath);
        for (File file : dir.listFiles()) {
            if (file.getName().equals(fileName)) {
                return file;
            }
        }
        return null;
    }
}
