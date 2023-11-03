package module_30_auot_it;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class UploadFileTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        String projectPath = System.getProperty("user.dir");
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", projectPath);
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        driver.get("https://www.freepdfconvert.com/ru/pdf-to-jpg");
        driver.findElement(By.cssSelector(".upload-btn")).click();

        //call autoit exe file to process native windows actions
        Thread.sleep(3000);
        Runtime.getRuntime().exec("C:\\Users\\Administrator\\Documents\\upload_script.exe");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".convert-btn")));
        driver.findElement(By.cssSelector(".convert-btn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".download-btn")));
        driver.findElement(By.cssSelector(".download-btn")).click();

        //verify if file is present in filesystem
        Thread.sleep(5000);
        File file = new File(projectPath + "/selenium_test.jpg");
        boolean isDownloaded = file.exists();
        if (isDownloaded){
            System.out.println("file is successfully downloaded");
            boolean delete = file.delete();
            if (delete){
                System.out.println("file was deleted successfully");
            }
        }else {
            System.out.println("File is not downloaded");
        }
    }
}
