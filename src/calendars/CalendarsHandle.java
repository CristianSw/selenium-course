package calendars;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarsHandle {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions action = new Actions(driver);
        driver.get("https://path2usa.com/travel-companions/");
        // wanted date to be 28 octomber
        String wantedDate = "28";
        String wantedMonth = "January";

        WebElement inputCalendar = driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputCalendar);
        Thread.sleep(500);
        inputCalendar.click();

        while(!driver.findElement(By.xpath("//span[@class='cur-month']")).getText().contains(wantedMonth)){
            Thread.sleep(500);
            driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
        }

        //grab common attribute and put all of them in the list 

        List<WebElement> dates = driver.findElements(By.className("flatpickr-day"));
        for (int i = 0; i < dates.size(); i++) {
            String text = driver.findElements(By.className("flatpickr-day")).get(i).getText();
            if (text.equalsIgnoreCase(wantedDate)) {
                driver.findElements(By.className("flatpickr-day")).get(i).click();
                break;
            }
        }
    }
}
