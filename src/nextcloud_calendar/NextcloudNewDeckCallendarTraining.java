package nextcloud_calendar;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NextcloudNewDeckCallendarTraining {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String wantedMonth = "Nov.";
        String wantedDay = "16";

        driver.get("https://nc.sourcerunners.space/apps/deck/");
        Thread.sleep(500);
        driver.findElement(By.id("user")).sendKeys("testuser");
        Thread.sleep(500);
        driver.findElement(By.id("password")).sendKeys("qazwsxgh32umym");
        Thread.sleep(500);
        driver.findElement(By.className("button-vue__text")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'Add board')]")));
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[contains(.,'Add board')]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@placeholder='Board name']")).sendKeys("Selenium Test Board");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@class='icon-confirm']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[contains(.,'Selenium Test Board')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("new-stack-input-main")));
        driver.findElement(By.id("new-stack-input-main")).sendKeys("test");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@class='icon-confirm v-popper--has-tooltip']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@aria-label='Add card']")).click();
        Thread.sleep(500);
        driver.findElement(By.id("new-stack-input-main")).sendKeys("Selenium Test");

        driver.findElement(By.xpath("//input[@id='new-stack-input-main']/following-sibling::input")).click();
        driver.findElement(By.xpath("//div[@class='card card__editable']")).click();
        driver.findElement(By.xpath("//div[contains(@class,'mx-input-wrapper')]")).click();

        String currentMonth = driver.findElement(By.xpath(
                "//span[@class='mx-calendar-header-label']/button[@class='mx-btn mx-btn-text mx-btn-current-month']"))
                .getText();
        if (currentMonth.equalsIgnoreCase(wantedMonth)) {

        } else {
            driver.findElement(By.xpath(
                    "//span[@class='mx-calendar-header-label']/button[@class='mx-btn mx-btn-text mx-btn-current-month']"))
                    .click();
            Thread.sleep(2000);
            List<WebElement> months = driver.findElements(By.xpath("//td[@class='cell']"));
            for (int i = 0; i < months.size(); i++) {
                String tempMonth = driver.findElements(By.xpath("//td[@class='cell']")).get(i).getText();
                Thread.sleep(500);
                if (tempMonth.equalsIgnoreCase(wantedMonth)) {
                    driver.findElements(By.xpath("//td[@class='cell']")).get(i).click();
                    break;
                }
            }
        }
        Thread.sleep(2000);
        List<WebElement> days = driver.findElements(By.xpath("//td[@class='cell']"));
        for (int i = 0; i < days.size(); i++) {
            String tempDay = driver.findElements(By.xpath("//td[@class='cell']")).get(i).getText();
            Thread.sleep(500);
            if (tempDay.equalsIgnoreCase(wantedDay)) {
                driver.findElements(By.xpath("//td[@class='cell']")).get(i).click();
                break;
            }
        }

        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@class='mx-btn mx-datepicker-btn-confirm'] ")).click();
    }
}
