package driver;

public class Page {
    private Field field;

    public Field field(String locator){
        return this.field = new Field(locator);
    }
}
