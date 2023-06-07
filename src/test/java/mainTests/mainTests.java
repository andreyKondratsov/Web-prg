package mainTests;

import base.WebTest;
import driver.DriverManager;
import org.testng.annotations.Test;

public class mainTests extends WebTest{

    @Test
    public void myTest() {
        DriverManager.open("https://www.google.com");
        webPages.pageGoogle.clickAcceptCooke();
        webPages.pageGoogle.getTextForCountry();
        webPages.pageGoogle.setTextToSearchField();
        webPages.pageGoogle.clickSearchButton();

    }

}
