package module_13_miscellaneous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MaximizeAndDeleteCookies {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        // maximize browser window
        driver.manage().window().maximize();
        //delete cookies
        driver.manage().deleteAllCookies();
        driver.manage().deleteCookieNamed("cookie name");
        
    }
}
