package base;

import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebTest extends ContainerForPages{

    @BeforeMethod (alwaysRun = true)
    public void setUp() {
        DriverManager.setDriver();
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }


}
