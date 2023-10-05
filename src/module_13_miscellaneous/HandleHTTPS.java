package module_13_miscellaneous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HandleHTTPS {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        FirefoxOptions optionsFirefox = new FirefoxOptions();
        optionsFirefox.setAcceptInsecureCerts(true);
        //options.addExtensions(null); //add an extension to browser when launch it in test mode
        // Proxy proxy = new Proxy();
        // proxy.setHttpProxy("ipaddress:3333");
        //options.setCapability("proxy", proxy); //set an proxy config to access web sites with proxy

        WebDriver driverChrome = new ChromeDriver(options);
        WebDriver driver = new FirefoxDriver(optionsFirefox);
        
        driverChrome.get("https://expired.badssl.com");
        System.out.println(driverChrome.getTitle());

        driver.get("https://expired.badssl.com");
        System.out.println(driver.getTitle());
    }
}
