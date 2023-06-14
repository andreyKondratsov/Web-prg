package mainTests;

import core.base.WebTest;
import core.driver.DriverManager;
import org.testng.annotations.Test;

public class mainTests extends WebTest{

    @Test(description = "myTest")
    public void myTest() {
        log.step("1. Open page");
        DriverManager.open("https://www.google.com");

        log.step("2. Click Accept Cooke");
        webPages.pageGoogle.clickAcceptCooke();

        log.step("3. Check Text For Country");
        webPages.pageGoogle.checkTextForCountry();

        log.step("4. Set Text To Search Field, click Search Button");
        webPages.pageGoogle.setTextToSearchField();

    }

}
