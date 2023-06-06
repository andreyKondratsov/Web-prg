package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    public static void getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:/work/chromedriver/chromedriver.exe");
            driver = new ChromeDriver();
        }
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
