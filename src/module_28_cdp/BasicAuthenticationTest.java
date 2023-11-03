package module_28_cdp;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import java.net.URI;
import java.util.function.Predicate;

public class BasicAuthenticationTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        DevTools devTools =  ((ChromiumDriver) driver).getDevTools();
        devTools.createSession();

        Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");
        ((HasAuthentication) driver).register(uriPredicate, UsernameAndPassword.of("foo","bar"));
        driver.get("http://httpbin.org/basic-auth/foo/bar");
        driver.close();
    }
}
