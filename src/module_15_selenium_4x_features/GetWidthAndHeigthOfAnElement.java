package module_15_selenium_4x_features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetWidthAndHeigthOfAnElement {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice");
        WebElement nameField = driver.findElement(By.cssSelector("[name='name']"));
//        int height = nameField.getRect().getDimension().getHeight();
//        int width = nameField.getRect().getDimension().getWidth();
        int height = nameField.getRect().getHeight();
        int width = nameField.getRect().getWidth();
        System.out.println("nameField : ");
        System.out.println("height: " + height);
        System.out.println("width: " + width);
    }
}
