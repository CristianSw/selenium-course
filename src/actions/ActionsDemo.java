package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://amazon.com");

        Actions action = new Actions(driver);

        WebElement move = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).doubleClick()
                .sendKeys("hello").build().perform();

        // Move to specific element
        action.moveToElement(move).contextClick().build().perform();

    }
}
