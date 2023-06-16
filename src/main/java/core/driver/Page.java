package core.driver;

import core.Logger.Log;

public class Page {
    private Field field;
    public Log log = new Log();
    public CSVHelper csvHelper = new CSVHelper();

    public Field field(String locatorName) {
        if (locatorName.contains("//") || locatorName.contains("css=") || locatorName.contains("name=") || locatorName.contains("id=")) {
            return this.field = new Field(locatorName);
        } else {
            String filePath = getPathData("locators/Locators");
            return this.field = new Field(csvHelper.getTextFromCSV(filePath, "Value", locatorName));
        }

    }

    public String getDataFromCSV(String fileName, String columnName, String rowName) {
        String filePath = getPathData(fileName);
        return csvHelper.getTextFromCSV(filePath, columnName, rowName);
    }

    public String getPathData(String fileName) { //todo update path to main
        return "C:/Users/chiki/IdeaProjects/Web-prg/src/main/java/" + (this.getClass().getName() + "/")
                .replace(".", "/").replace(this.getClass().getSimpleName() + "/"
                        + this.getClass().getSimpleName(), this.getClass().getSimpleName()) + "data/" + fileName + ".csv";
    }
}
