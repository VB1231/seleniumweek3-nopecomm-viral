package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static String baseUrl="https://demo.nopcommerce.com/";
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        //launch Browser
        driver.get(baseUrl);
        //maximize window
        driver.manage().window().maximize();
        //set delay time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    //close browser
    public void closeBrowser() {
        driver.quit();
    }
}
