package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Frame {
    public static void main(String[] args) {
        
        WebDriver driver = new FirefoxDriver();
        Actions action = new Actions(driver);
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        action.dragAndDrop(source, target).build().perform();
        driver.switchTo().defaultContent();
       
    }
}
