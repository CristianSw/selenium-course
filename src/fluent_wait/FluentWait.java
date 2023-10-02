package fluent_wait;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class FluentWait {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("[id='start'] button")).click();

        Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(3L))
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                if (driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
                    return driver.findElement(By.cssSelector("[id='finish'] h4"));
                } else
                    return null;
            }
        });
        Assert.assertEquals(driver.findElement(By.cssSelector("[id='finish'] h4")).getText(), "Hello World!");

    }
}
