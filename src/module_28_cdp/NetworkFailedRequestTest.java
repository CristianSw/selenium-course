package module_28_cdp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.fetch.Fetch;
import org.openqa.selenium.devtools.v118.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v118.network.model.ErrorReason;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class NetworkFailedRequestTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((ChromiumDriver) driver).getDevTools();

        devTools.createSession();
        List<RequestPattern> requestPatterns = Arrays.asList(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty()));
        devTools.send(Fetch.enable(Optional.of(requestPatterns),Optional.empty()));

        devTools.addListener(Fetch.requestPaused(), requestPaused -> {
            devTools.send(Fetch.failRequest(requestPaused.getRequestId(), ErrorReason.FAILED));
        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
    }
}
