package locators;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class LocatorsTwo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		String username = "cristian";

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//		driver.get("http://rahulshettyacademy.com/locatorspractice/");
		
		String password = getPassword(driver);
		driver.findElement(By.id("inputUsername")).sendKeys(username);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();

		Thread.sleep(1000);
		String successLoginMessage = driver.findElement(By.tagName("p")).getText();
		System.out.println(successLoginMessage);
		Assert.assertEquals(successLoginMessage, "You are successfully logged in.");
		String greeting = driver.findElement(By.tagName("h2")).getText();
		System.out.println(greeting);
		Assert.assertEquals(greeting, "Hello " + username + ",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
	}

	static public String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("http://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		String[] passwdArr = passwordText.split("'");
		String finalPassword = passwdArr[1].split("'")[0];
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		Thread.sleep(1000);
		return finalPassword;
	}

}
