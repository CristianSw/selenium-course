package assignment_6;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AssignmentSix {

    /*
     * 1. select one checkbox grab text from checkbox
     * 2. go to dropdown select and select an options which matching the label of checkbox selectet previous
     * 3. enter checkbox label into switch to alert example edit box
     * 4. click on alert verify if text from step 1 come in alert message
     */
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        String checkboxLabel;
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        /* 1st step */
        driver.findElement(By.id("checkBoxOption2")).click();
        checkboxLabel = driver.findElement(By.xpath("//label[@for='benz']")).getText();
        /* 2nd step */
        WebElement select = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(select);
        dropdown.selectByVisibleText(checkboxLabel);
        /* 3rd step */
        driver.findElement(By.id("name")).sendKeys(checkboxLabel);
        driver.findElement(By.id("alertbtn")).click();
        /* 4th step */
        String[] alertText = driver.switchTo().alert().getText().split(",");
        String[] alertTextName = alertText[0].split(" ");

        Assert.assertEquals(alertTextName[1],checkboxLabel);  
    }
}
