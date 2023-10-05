package module_13_miscellaneous;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Screenshots {
    public static void main(String[] args) throws IOException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://google.com");
        File screenshot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("/home/cristian/Pictures/selenium_photo.png"));


    }
}
