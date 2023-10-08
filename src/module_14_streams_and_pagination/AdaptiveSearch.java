package module_14_streams_and_pagination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class AdaptiveSearch {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        String veggieName = "ri";
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.id("search-field")).sendKeys(veggieName);
        List<WebElement> webElements = driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> filteredList = webElements.stream()
                .filter(s -> s.getText().toLowerCase().contains(veggieName.toLowerCase()))
                .collect(Collectors.toList());
        Assert.assertEquals(webElements, filteredList);

    }
}
