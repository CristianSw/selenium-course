package assignment_sync;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentSync {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String loginDetails;
        String login = "";
        String passwd = "";

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        loginDetails = driver.findElement(By.xpath("//p[@class='text-center text-white']")).getText();

        int usernameIndex = loginDetails.indexOf("username is");
        int passwordIndex = loginDetails.indexOf("Password is");

        login = loginDetails
                .substring(usernameIndex + "username is".length(), loginDetails.indexOf("and", usernameIndex)).trim();
        passwd = loginDetails
                .substring(passwordIndex + "Password is".length(), loginDetails.indexOf(")", passwordIndex)).trim();
        driver.findElement(By.id("username")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(passwd);
        driver.findElement(By.xpath("//input[@value='user']/following-sibling::span")).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success']"))); // not working
        driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
        // Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select.form-control"))); // also not working
        WebElement staticDropdown = driver.findElement(By.cssSelector("select.form-control"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByValue("consult");

         driver.findElement(By.id("terms")).click();
         driver.findElement(By.id("signInBtn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-info']")));
        List<WebElement> products =
        driver.findElements(By.xpath("//button[@class='btn btn-info']"));

        for (WebElement webElement : products) {
        webElement.click();
        }

        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
    }
}
