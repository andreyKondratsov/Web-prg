package core.driver;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class CSVHelper {

    public String getPathData(String fileName) { //todo update path to main
        String newFileName = "C:/Users/chiki/IdeaProjects/Web-prg/src/main/java/" + (this.getClass().getName() + "/").replace(".", "/").replace(this.getClass().getSimpleName() + "/" + this.getClass().getSimpleName(), this.getClass().getSimpleName()) + "data/" + fileName + ".csv";
        return newFileName;
    }

    public String getTextFromCSV(String filePath,  String columnName, String rowName) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] headers = reader.readNext();

            int columnIndex = -1;

            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equalsIgnoreCase(columnName)) {
                    columnIndex = i;
                    break;
                }
            }

            if (columnIndex == -1) {
                throw new IllegalArgumentException("Invalid column name");
            }

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String rowValue = nextLine[0];
                if (rowValue.equalsIgnoreCase(rowName)) {
                    return nextLine[columnIndex];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

