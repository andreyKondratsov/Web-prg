package mainTests;

import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class mainTests {


    @BeforeMethod
    public void setUp() {
        DriverManager.getDriver();
    }

    @Test
    public void myTest() {
        DriverManager.open("https://www.google.com");
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
