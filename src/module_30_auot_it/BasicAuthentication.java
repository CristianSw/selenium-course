package module_30_auot_it;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.network.Network;
import org.openqa.selenium.devtools.v118.network.model.Response;


import java.util.Optional;

public class BasicAuthentication {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((ChromiumDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            Response response = responseReceived.getResponse();
            System.out.println("Status: " + response.getStatusText());
            System.out.println("Status text: " + response.getStatusText());
            Command<Network.GetResponseBodyResponse> responseBody = Network.getResponseBody(responseReceived.getRequestId());
            String string = responseBody.getParams().toString();;
            System.out.println(string);
        });


        driver.get("http://foo:bar@httpbin.org/basic-auth/foo/bar");
        driver.close();
    }
}
