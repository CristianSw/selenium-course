package alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        String name = "Cristian";

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.switchTo().alert().getText(),
                "Hello " + name + ", share this practice page and share your knowledge");
        System.out.println();
        driver.switchTo().alert().accept();

        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.switchTo().alert().getText(),
                "Hello " + name + ", Are you sure you want to confirm?");
        driver.switchTo().alert().accept();

        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.switchTo().alert().getText(),
                "Hello " + name + ", Are you sure you want to confirm?");
        driver.switchTo().alert().dismiss();

    }
}
