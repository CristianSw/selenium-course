package internet_magazin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GreenCart {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        // String[] wantedProductsNames = { "Cucumber", "Brocolli" };
        ArrayList<String> wantedProductsNames = new ArrayList<>();
        wantedProductsNames.add("Cucumber");
        wantedProductsNames.add("Brocolli");
        wantedProductsNames.add("Beetroot");
        wantedProductsNames.add("Mushroom");

        int productCounter = 0;
        Thread.sleep(3000);
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        List<WebElement> addButtons = driver
                .findElements(By.xpath("//div[@class='product-action']/button"));

        for (int i = 0; i < products.size(); i++) {

            String[] productName = products.get(i).getText().split("-");
            String formattedName = productName[0].trim();

            if (wantedProductsNames.contains(formattedName)) {
                addButtons.get(i).click();

                productCounter++;

                if (productCounter == wantedProductsNames.size()) {
                    break;
                }
            }
        }

    }
}
