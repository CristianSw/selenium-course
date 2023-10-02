package internet_magazin;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GreenCart {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // String[] wantedProductsNames = { "Cucumber", "Brocolli" };
        ArrayList<String> wantedProductsNames = new ArrayList<>();
        wantedProductsNames.add("Cucumber");
        wantedProductsNames.add("Brocolli");
        wantedProductsNames.add("Beetroot");
        wantedProductsNames.add("Mushroom");

        int productCounter = 0;
        String promoCode = "rahulshettyacademy";
        String promoInfo;
        String promoInfoExpected = "Code applied ..!";
        String discount;
        String discountExpected = "10%";

        addItemsToCart(driver, wantedProductsNames, productCounter);
        driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
        driver.findElement(By.xpath("//div[@class='action-block']/button")).click();

        driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys(promoCode);
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
        // explicit wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
        promoInfo = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
        Assert.assertEquals(promoInfo, promoInfoExpected);
        discount = driver.findElement(By.xpath("//span[@class='discountPerc']")).getText();
        Assert.assertEquals(discount, discountExpected);
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[contains(@style,'width: 200px;')]")));
        WebElement staticDropdown = driver.findElement(By.xpath("//select[contains(@style,'width: 200px;')]"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByVisibleText("Moldova");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Moldova");

        Assert.assertFalse(driver.findElement(By.className("chkAgree")).isSelected());
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();
        String errorAlertCheckbox = driver.findElement(By.xpath("//span[@class='errorAlert']/b")).getText();
        String errorAlertCheckboxExpected = "Please accept Terms & Conditions - Required";
        Assert.assertEquals(errorAlertCheckbox,errorAlertCheckboxExpected);
        
        driver.findElement(By.className("chkAgree")).click();
        Assert.assertTrue(driver.findElement(By.className("chkAgree")).isSelected());
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();


    }

    public static void addItemsToCart(WebDriver driver, ArrayList<String> wantedProductsNames, int productCounter) {
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
