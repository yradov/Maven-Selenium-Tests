package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class MyFirstTest {
    ChromeDriver driver;
    final String TEST_PAGE_URL = "https://www.google.com.ua/";


    @Test
    public void firstTest() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        //options.setCapability("seleniumAddress", "http://localhost:4444");
        driver = new ChromeDriver(options);


        String pageUrl = System.getenv("TEST_URL");
        driver.get(pageUrl);
        Assert.assertEquals(driver.getCurrentUrl(), TEST_PAGE_URL);

        String password = System.getenv("TEST_PASSWORD");
        Assert.assertEquals(password, "11111111");
        driver.quit();
    }
}
