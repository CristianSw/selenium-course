package module_28_cdp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.fetch.Fetch;
import org.openqa.selenium.devtools.v118.network.model.Request;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Optional;

public class NetworkMockingTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        DevTools devTools = ((ChromiumDriver) driver).getDevTools();
        devTools.createSession();

        devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
        devTools.addListener(Fetch.requestPaused(), requestPaused -> {
            Request request = requestPaused.getRequest();
            String url = request.getUrl();
            if (url.contains("shetty")) {
                String newUrl = url.replace("=shetty", "=BadGuy");
                System.out.println(newUrl);
                devTools.send(Fetch.continueRequest(requestPaused.getRequestId(), Optional.of(newUrl), Optional.ofNullable(request.getMethod()), Optional.empty(), Optional.empty(), Optional.empty()));
            } else {
                devTools.send(Fetch.continueRequest(requestPaused.getRequestId(), Optional.of(request.getUrl()), Optional.ofNullable(request.getMethod()), Optional.empty(), Optional.empty(), Optional.empty()));
            }
        });
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));
        String p = driver.findElement(By.cssSelector("p")).getText();
        System.out.println(p);
        Assert.assertEquals(p,"Oops only 1 Book available");
    }
}
