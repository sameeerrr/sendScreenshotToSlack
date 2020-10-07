import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class BaseTestClass {
    public static WebDriver driver;

    @BeforeSuite
    public void setup(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + File.separator + "chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in");
    }

    @AfterSuite
    public void closing(){
        driver.quit();
    }

}
