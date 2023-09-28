package locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntroduction {

	public static void main(String[] args) {
		
		
		
		//Invoking Browser 
		
		//Chrome - ChromeDriver -> Methods			
		WebDriver driver = new ChromeDriver();
		//Firefox - FirefoxDriver -> Methods
//		WebDriver driver = new FirefoxDriver();
//		driver.get("https://nc.sourcerunners.space");
		driver.get("https://rahulshettyacademy.com");
		String title = driver.getTitle();
		System.out.println(title);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		driver.close(); // close only tab which was opened by selenium
//		driver.quit(); // close all associated window
	}

}
