package module_12_scroll;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Scroll {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // js.executeScript("arguments[0].scrollIntoView(true);", WebElement);
        // or give scrolling coordinates
        // window.scroll(0,500);
        // to scroll inside an element
        // document.querySelector("cssSelector here").scroll
        WebElement table = driver.findElement(By.cssSelector(".tableFixHead"));
        js.executeScript("arguments[0].scrollIntoView(true);",table);
        Thread.sleep(3000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");

        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum = 0;
        for (WebElement webElement : values) {
            sum += Integer.parseInt(webElement.getText());
        }
        String[] totalAmountStringSplited = driver.findElement(By.className("totalAmount")).getText().split(":");
        int totalAmount = Integer.parseInt(totalAmountStringSplited[1].trim());
        Assert.assertEquals(sum, totalAmount);

    }
}
