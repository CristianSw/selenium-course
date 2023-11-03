package module_28_cdp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class ConsoleLogsCaptureTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("a[class$='btn-success']")).click();
        driver.findElement(By.linkText("Selenium")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'add-to-cart')]")).click();
        driver.navigate().back();
        driver.findElement(By.linkText("Appium")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'add-to-cart')]")).click();
        driver.findElement(By.cssSelector("a[routerlink*=cart]")).click();

        driver.findElement(By.id("exampleInputEmail1")).clear();
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = logEntries.getAll();
        logs.stream().forEach(logEntry -> System.out.println(logEntry.getMessage()));

        driver.close();
    }
}
