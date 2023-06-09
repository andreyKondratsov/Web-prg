package WebPages.PageGoogle;

import core.driver.Page;

public class PageGoogle extends Page{
    public void clickAcceptCooke(){
        field("//*[@class='QS5gu sy4vM']").click();
    }

    public String getTextForCountry(){
        return field("//*[@id='SIvCob']").get();
    }

    public void setTextToSearchField(){
        field("//*[@class='gLFyf']").set("test");
    }

    public void clickSearchButton(){
        field("//*[@class='FPdoLc lJ9FBc']//*[@class='gNO89b']").click();
    }

    public void checkTextForCountry(){
        log.check("Check text", getTextForCountry(),getTextForCountry(), "contains");
    }
}
