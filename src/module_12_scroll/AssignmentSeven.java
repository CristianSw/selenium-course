package module_12_scroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class AssignmentSeven {
    /*
     * 1. go to https://rahulshettyacademy.com/AutomationPractice/ page
     * 2. print count of table rows of Web Table Example
     * 3. print count of columns of Web Table Example
     * 4. print second row 
     */
    public static void main(String[] args) {

        WebDriver driver =  new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int rows = 0;
        int rowsExpected = 11;
        int columns = 0;
        int columnsExpected = 3;
        String secondRowValueExpected = "Rahul Shetty Learn SQL in Practical + Database Testing from Scratch 25";

        /* step 1 */
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        /* find element and scroll it into view */
        WebElement table = driver.findElement(By.id("product"));
        js.executeScript("arguments[0].scrollIntoView(true);", table);

        /* Step 2 */
        rows = driver.findElements(By.cssSelector(".table-display tr")).size();
        
        Assert.assertEquals(rows, rowsExpected);
        /* Step 3 */
        columns = driver.findElements(By.cssSelector(".table-display th")).size();
        Assert.assertEquals(columns, columnsExpected);

        /* Step4 */
        String secondRowValue = driver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText();
        Assert.assertEquals(secondRowValue, secondRowValueExpected);
        System.out.println(secondRowValue);
    }
}
