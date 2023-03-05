package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTest {
    ChromeDriver driver;
    String url = "https://www.google.com.ua/";


    @Test
    public void firstTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // включение headless-режима
        driver = new ChromeDriver(options);
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}
