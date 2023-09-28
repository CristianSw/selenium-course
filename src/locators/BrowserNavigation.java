package locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserNavigation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.navigate().to("https://nc.sourcerunners.space");
		driver.navigate().back();
		driver.navigate().forward();
	}

}
