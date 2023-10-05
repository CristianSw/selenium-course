package module_13_miscellaneous;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

    public static void main(String[] args) throws MalformedURLException, IOException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        SoftAssert softAssert = new SoftAssert();

        /* step 1 get all urls */
        String url = "";
        HttpURLConnection connection = null;
        int responseCode = 0;

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        for (WebElement webElement : links) {
            url = webElement.getAttribute("href");
            // Java methods to call urls and see status code
            // if status > 400 -> fail test
            try {
                connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("GET");
                connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11");
                connection.setUseCaches(false);
                connection.connect();
                responseCode = connection.getResponseCode();
                System.out.println(responseCode);
                softAssert.assertTrue(responseCode < 400,
                        "The link with text: " + webElement.getText() + "is broken with code: " + responseCode);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        }
        softAssert.assertAll();
        driver.close();
    }

}
