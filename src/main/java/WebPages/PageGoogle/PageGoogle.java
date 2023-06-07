package WebPages.PageGoogle;

import driver.Page;

public class PageGoogle extends Page{

    public void clickAcceptCooke(){
        field.click("//*[@class='QS5gu sy4vM']");
    }

    public String getTextForCountry(){
        return field.get("//*[@id='SIvCob']");
    }

    public void setTextToSearchField(){
        field.set("//*[@class='gLFyf']","test");
    }

    public void clickSearchButton(){
        field.click("//*[@class='FPdoLc lJ9FBc']//*[@class='gNO89b']");
    }
}
