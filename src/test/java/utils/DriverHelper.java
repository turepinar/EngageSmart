package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverHelper {

    //This is private variable  //Rule 1 for Singleton design pattern
    private static WebDriver driver;

    //This is Private constructor to make sure they dont create an object from this class
    ////Rule 2 for Singleton design pattern
    private DriverHelper() {}

    //this is the method we use to reach the driver
    public static WebDriver getDriver() {
        if (driver == null) {// i am checking driver whether it is null or not
            //if driver is null I am going to create a new one
            //if not, it is going to create a new Driver. It will use the existing(current) one.
            switch (ConfigReader.readProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //this implicity wait for the elements until 10 seconds to be loaded
        }
        return driver;
    }

    public static void tearDown() {
        driver.quit();
        driver = null;
    }

    
}
