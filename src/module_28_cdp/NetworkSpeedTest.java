package module_28_cdp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.network.model.ConnectionType;
import org.openqa.selenium.devtools.v118.network.Network;
import org.openqa.selenium.devtools.v118.network.model.MonotonicTime;

import java.util.Optional;

public class NetworkSpeedTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        DevTools devTools =  ((ChromiumDriver) driver).getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(false,3000,20000,20000, Optional.of(ConnectionType.CELLULAR3G)));
//        devTools.send(Network.emulateNetworkConditions(true,3000,20000,20000, Optional.of(ConnectionType.CELLULAR3G)));
        devTools.addListener(Network.loadingFailed(), loadingFailed -> {
            String errorText = loadingFailed.getErrorText();
            System.out.println(errorText);
            MonotonicTime timestamp = loadingFailed.getTimestamp();
            System.out.println(timestamp);
        });
        long startTime = System.currentTimeMillis();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime));
        driver.close();
        //15000 1645
    }
}
