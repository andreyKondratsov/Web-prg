package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private static WebDriver driver;

    public static void setDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:/work/chromedriver/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("disable-gpu");
            driver = new ChromeDriver(chromeOptions);
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void open(String url){
        driver.get(url);
    }

}
