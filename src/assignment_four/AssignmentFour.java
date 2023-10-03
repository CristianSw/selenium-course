package assignment_four;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AssignmentFour {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Actions actions = new Actions(driver);
        driver.get("https://the-internet.herokuapp.com/");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/windows']")));
        driver.findElement(By.xpath("//a[@href='/windows']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/windows/new']")));
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();
        driver.switchTo().window(childId);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='example']/h3")));
        String secondPageText = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
        Assert.assertEquals(secondPageText, "New Window");
        System.out.println(secondPageText);
        driver.switchTo().window(parentId);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='example']/h3")));
        String firstPageText = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
        Assert.assertEquals(firstPageText, "Opening a new window");
        System.out.println(firstPageText);

    }
}
