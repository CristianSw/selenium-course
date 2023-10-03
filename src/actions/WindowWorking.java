package actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WindowWorking {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.className("blinkingText")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator= windows.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();
        driver.switchTo().window(childId);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".im-para.red")));
        String textFrom2ndPage = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        Assert.assertEquals(textFrom2ndPage,"mentor@rahulshettyacademy.com");
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(textFrom2ndPage);
    }
}
