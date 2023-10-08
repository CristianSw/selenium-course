package module_15_selenium_4x_features;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class MultipleWindowsAndTabs {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB).get("https://rahulshettyacademy.com");
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindowId = iterator.next();
        String childWindowId = iterator.next();
        driver.switchTo().window(childWindowId);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")));
        String firstCourseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();
        driver.switchTo().window(parentWindowId);
        WebElement nameField = driver.findElement(By.cssSelector("[name='name']"));
        nameField.sendKeys(firstCourseName);
        //take screenshot of an element on page
        File file = nameField.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("/home/cristian/Pictures/nameField.png"));
    }
}
