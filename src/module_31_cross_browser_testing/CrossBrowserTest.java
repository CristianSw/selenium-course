package module_31_cross_browser_testing;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CrossBrowserTest {
    @Test
    public void getTitleTest() throws MalformedURLException {
        String expectedTitle = "Selenium, API Testing, Software Testing & More QA Tutorials | Rahul Shetty Academy";
        MutableCapabilities caps = new MutableCapabilities();

        WebDriver driver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), caps);
//        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com");
        String title = driver.getTitle();
//        System.out.println(title);
        Assert.assertTrue(title.equalsIgnoreCase(expectedTitle));
    }
}
