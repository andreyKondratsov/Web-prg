package WebPages.PageGoogle;

import core.driver.Page;
import org.openqa.selenium.Keys;

public class PageGoogle extends Page {

    public void clickAcceptCooke() {
        field("AcceptCooke").click();
    }

    public String getTextForCountry() {
        return field("TextForCountry").get();
    }

    public void setTextToSearchField() {
        field("SearchField").set("test");
        field("SearchField").sendKeys(Keys.ENTER);
    }

    public void checkTextForCountry() {
        log.check("Check text", getTextForCountry(), getDataFromCSV("Data", "Value", "TextForCountry"), "contains");
    }
}
