package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.example.Data.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserActions {
    public static WebDriver driver;


    static {

        driver = new ChromeDriver();
    }
    public static void openBrowser() {
        driver.get(urlOfLogin);
    }
    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
    }
}


