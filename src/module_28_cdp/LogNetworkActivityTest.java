package module_28_cdp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.network.Network;
import org.openqa.selenium.devtools.v118.network.model.Request;
import org.openqa.selenium.devtools.v118.network.model.Response;

import java.util.Optional;

public class LogNetworkActivityTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((ChromiumDriver) driver).getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));


        devTools.addListener(Network.requestWillBeSent(), requestWillBeSent -> {
            Request request = requestWillBeSent.getRequest();
        });

        devTools.addListener(Network.responseReceived(),responseReceived ->{
           Response response = responseReceived.getResponse();
            if (response.getStatus().toString().startsWith("4")) {
                System.out.println("These url are failing:");
                System.out.println(response.getUrl());
                System.out.println(response.getStatus());
                System.out.println(response.getStatusText());
            }
        });
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
        driver.close();

    }
}
