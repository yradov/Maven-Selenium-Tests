package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MyFirstTest {
    WebDriver driver;

    final String TEST_PAGE_URL = "https://www.google.com.ua/";


//    @Test
//    public void firstTest() {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        options.setExperimentalOption("prefs", chromePrefs);
//        options.addArguments("--disable-extensions"); // Отключает расширения Chrome
//        options.setBinary("/usr/bin/google-chrome-stable");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--disable-dev-shm-usage"); // should be enabled for Jenkins
//         options.addArguments("--window-size=1920x1080"); // should be enabled for Jenkins
//         options.setCapability("seleniumAddress", "http://localhost:4444");
//         options.setCapability("seleniumAddress", "http://localhost:4444/wd/hub");
//        driver = new ChromeDriver(options);
//
//
//         String pageUrl = System.getenv("TEST_URL");
//         driver.get(pageUrl);
//         Assert.assertEquals(driver.getCurrentUrl(), TEST_PAGE_URL);
//
//         String password = System.getenv("TEST_PASSWORD");
//         Assert.assertEquals(password, "11111111");
//
//        driver.quit();
//    }

    @Test
    public void remoteSeleniumTest() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
//        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444"), options);
        /** for Docker only */
        driver = new RemoteWebDriver(new URL("http://selenium:4444"), options);
        driver.get(TEST_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), TEST_PAGE_URL);
        driver.quit();
    }
}
