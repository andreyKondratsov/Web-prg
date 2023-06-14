package WebPages.PageGoogle;

import core.driver.Page;
import org.openqa.selenium.Keys;

public class PageGoogle extends Page{
    public void clickAcceptCooke(){
        field("//*[@class='QS5gu sy4vM']").click();
    }

    public String getTextForCountry(){
        return field("//*[@id='SIvCob']").get();
    }

    public void setTextToSearchField(){
        field("//*[@class='gLFyf']").set("test");
        field("//*[@class='gLFyf']").sendKeys(Keys.ENTER);
    }

    public void checkTextForCountry(){
        log.check("Check text", getTextForCountry(),getTextForCountry(), "contains");
    }
}
