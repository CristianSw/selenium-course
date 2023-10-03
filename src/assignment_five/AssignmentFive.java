package assignment_five;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class AssignmentFive {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href='/nested_frames']")).click();
        WebElement topFrames = driver.findElement(By.xpath("//frame[@src='/frame_top']"));
        driver.switchTo().frame(topFrames);
        WebElement middleFrame = driver.findElement(By.xpath("//frame[@src='/frame_middle']"));
        driver.switchTo().frame(middleFrame);
        String middleFrameContent = driver.findElement(By.id("content")).getText();
        Assert.assertEquals(middleFrameContent, "MIDDLE");
        System.out.println(middleFrameContent);
        driver.switchTo().defaultContent();
    }
}
