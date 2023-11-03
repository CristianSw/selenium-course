package module_28_cdp;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationCDPTest {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = getChromeDriver();
        String address = driver.findElement(By.id("address")).getText();
        System.out.println(address);
        driver.close();
    }

    private static ChromeDriver getChromeDriver() {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Map<String, Object> coordinates = new HashMap<>();
        coordinates.put("latitude",50);
        coordinates.put("longitude",8);
        coordinates.put("accuracy",1);
        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
        driver.get("https://my-location.org");
        return driver;
    }
}
