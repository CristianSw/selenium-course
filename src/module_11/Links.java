package module_11;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Links {
    public static void main(String[] args) throws InterruptedException {
        // give the count of links on the page
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        int linksCount = driver.findElements(By.tagName("a")).size();
        System.out.println(linksCount);

        // count links on the footer section
        // limiting driver scope by elements
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        linksCount = footer.findElements(By.tagName("a")).size();
        System.out.println(linksCount);

        // count links on first column
        WebElement columnOne = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        linksCount = columnOne.findElements(By.tagName("a")).size();
        System.out.println(linksCount);

        // click on each link on a column and check if the links are working
        for (int i = 1; i < linksCount; i++) {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columnOne.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
        }
        Thread.sleep(5000);
        // get title for each open link
        Set<String> tabs = driver.getWindowHandles();
        Iterator<String> iterator = tabs.iterator();
        while (iterator.hasNext()) {
            driver.switchTo().window(iterator.next());
            System.out.println(driver.getTitle());
        }
        driver.switchTo().defaultContent();
    }
}
