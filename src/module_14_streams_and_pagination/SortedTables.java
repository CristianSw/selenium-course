package module_14_streams_and_pagination;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class SortedTables {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        WebDriver driver = new FirefoxDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // click on column to sort
        driver.findElement(By.xpath("//tr/th[1]")).click();
        // collect all values in list
        List<WebElement> webElements = driver.findElements(By.xpath("//tr/td[1]"));
        // get text of element
        List<String> originalList = webElements.stream().map(WebElement::getText).toList();
        // sort in text list
        List<String> sortedList = originalList.stream().sorted().toList();
        // compare original list with sorted list
        Assert.assertEquals(sortedList, originalList);

        // get and display price of product
        List<String> price = new ArrayList<>();
        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream()
                    .filter(s -> s.getText().contains("Rice"))
                    .map(SortedTables::getPriceOfVeggie)
                    .collect(Collectors.toList());
            price.forEach(System.out::println);
            if (price.isEmpty()) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        } while (price.isEmpty());


    }

    private static String getPriceOfVeggie(WebElement s) {
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }

}
