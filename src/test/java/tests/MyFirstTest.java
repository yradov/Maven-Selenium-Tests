package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTest {
    @Test
    public void firstTest() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        String url = "https://www.google.com.ua/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}
