package module_28_cdp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.emulation.Emulation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;

public class MobileEmulatorTest {
    public static void main(String[] args) {

        // Create a ChromeOptions instance
        ChromeOptions options = new ChromeOptions();


        // Create a ChromeDriver instance with ChromeOptions
        WebDriver driver =new ChromeDriver(options);
        DevTools devTools =((ChromeDriver) driver).getDevTools();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        devTools.createSession();

        devTools.createSession();

        // Send commands to CDP to emulate a smartphone browser
        devTools.send(Emulation.setDeviceMetricsOverride(412, 915, 50, true,
                Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
                Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
                Optional.empty()));

        // Navigate to a web page
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.className("navbar-toggler")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Library")));
        driver.findElement(By.linkText("Library")).click();
        // Close the WebDriver when done
        driver.quit();
    }
}
