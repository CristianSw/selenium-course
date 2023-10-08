package module_15_selenium_4x_features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocation {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice");
        //above
        WebElement nameBox = driver.findElement(By.cssSelector("[name='name']"));
        String nameLabelValue = driver.findElement(with(By.tagName("label")).above(nameBox)).getText();
        System.out.println(nameLabelValue);
        //below
        WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateOfBirth)).sendKeys("02");
        driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
        //left
        WebElement checkboxLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(checkboxLabel)).click();
        //rigth
        WebElement radioBtn = driver.findElement(By.id("inlineRadio1"));
        String radioBtnLabel = driver.findElement(with(By.tagName("label")).toRightOf(radioBtn)).getText();
        System.out.println(radioBtnLabel);


    }
}
