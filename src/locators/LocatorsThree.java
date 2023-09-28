package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorsThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// sibling
		System.out
				.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());

		// from child to parent
		driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header/a[@class='blinkingText']"))
				.click();
	}

}
