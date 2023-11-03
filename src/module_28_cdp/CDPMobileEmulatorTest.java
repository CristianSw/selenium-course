package module_28_cdp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CDPMobileEmulatorTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        DevTools devTools =((ChromeDriver) driver).getDevTools();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        devTools.createSession();
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width",600);
        deviceMetrics.put("height",1000);
        deviceMetrics.put("deviceScaleFactor",50);
        deviceMetrics.put("mobile",true);

        ((ChromeDriver) driver).executeCdpCommand("Emulation.setDeviceMetricsOverride",deviceMetrics);
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.className("navbar-toggler")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Library")));
        driver.findElement(By.linkText("Library")).click();
        // Close the WebDriver when done
        driver.quit();
    }
}
