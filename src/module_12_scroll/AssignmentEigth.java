package module_12_scroll;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AssignmentEigth {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        String expectedCountry = "Moldova, Republic of";
        String country;

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("autocomplete")).sendKeys("mol");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='ui-menu-item'] div")));
        List<WebElement> countries = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
        for (WebElement webElement : countries) {
            country = webElement.getText();
            if (country.equalsIgnoreCase(expectedCountry)) {
                webElement.click();
                break;
            }
        }
        String checkFieldText = driver.findElement(By.id("autocomplete")).getAttribute("value");
        Assert.assertEquals(checkFieldText, expectedCountry);

    }
}
