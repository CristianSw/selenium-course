package dropdown_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dropdowns {
    public static void main(String[] args) throws InterruptedException {

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-private");

        WebDriver driver = new FirefoxDriver(options);

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        // dropdowns with select tag
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        String usdDropdown = dropdown.getFirstSelectedOption().getText();
        System.out.println(usdDropdown);

        dropdown.selectByVisibleText("AED");
        String aedDropdown = dropdown.getFirstSelectedOption().getText();
        System.out.println(aedDropdown);

        dropdown.selectByValue("INR");
        String inrDropdown = dropdown.getFirstSelectedOption().getText();
        System.out.println(inrDropdown);

        // auto sugestive dropdowns
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(3000);
        List<WebElement> selectorOptions = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement webElement : selectorOptions) {
            if (webElement.getText().equalsIgnoreCase("India")) {
                webElement.click();
                break;
            }
        }

        // checkboxes
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);

        for (int i = 0; i < 4; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
            // System.out.println(driver.findElement(By.id("hrefIncAdt")).getText());
            // System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        }
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

        driver.findElement(By.id("btnclosepaxoption")).click();

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        // driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        // if indexs are not accepted could be user partent to child
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
                .click();

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

        driver.findElement(By.id("Div1")).getAttribute("style");
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
            Assert.assertTrue(true);

        } else if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
            Assert.assertTrue(false);

        }

    }
}
