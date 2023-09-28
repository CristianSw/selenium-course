package locators;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Locators ID Xpath CSS Selector name Class Name Tag Name Link Text Partial
		 * Link Text
		 */
		WebDriver driver = new FirefoxDriver();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("http://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("cristian");
		driver.findElement(By.name("inputPassword")).sendKeys("somepasswd1234");
		driver.findElement(By.className("signInBtn")).click();

		// CSS Selector
		String erorr = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(erorr);
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		//Xpath //tagname[@attribute='value']
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("cristian");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("test@email.com");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("testmultiple@email.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("5482185");
//		driver.findElement(By.xpath("//div/button[1]")).click();
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
//		System.out.println(btnText);
		System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("inputUsername")).sendKeys("cristian");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.className("signInBtn")).click();

	}

}
