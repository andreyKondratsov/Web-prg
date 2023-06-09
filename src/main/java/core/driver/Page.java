package core.driver;

import core.Logger.Log;

public class Page {
    private Field field;

    public Log log = new Log();

    public Field field(String locator){
        return this.field = new Field(locator);
    }
}
