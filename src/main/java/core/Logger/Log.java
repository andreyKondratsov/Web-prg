package core.Logger;

public class Log {

    public void step(String description) {
        System.out.println(description + "\n");
    }

    public boolean check(String description, String actualData, String expectedData) {
        System.out.println(description);

        if (actualData.equals(expectedData)) {
            System.out.println("Actual equals expected");
            System.out.println("Actual:" + actualData);
            System.out.println("Expected:" + expectedData + "\n");
            return true;
        } else {
            System.out.println("Actual not equals expected");
            System.out.println("Actual:" + actualData);
            System.out.println("Expected:" + expectedData + "\n");
            return false;
        }
    }

    public boolean check(String description, String actualData, String expectedData, String compareType) {
        if (compareType.equalsIgnoreCase("contains"))
            return checkContains(description,actualData, expectedData);
        else if (compareType.equalsIgnoreCase("matches"))
            return checkMatches(description, actualData, expectedData);
        else {
            System.out.println("Comparison type not available:" + compareType);
            return false;
        }

    }

    public boolean checkContains(String description, String actualData, String expectedData) {
        System.out.println(description);

        if (actualData.contains(expectedData)) {
            System.out.println("Actual contains expected");
            System.out.println("Actual:" + actualData);
            System.out.println("Expected:" + expectedData + "\n");
            return true;
        } else {
            System.out.println("Actual not contains expected");
            System.out.println("Actual:" + actualData);
            System.out.println("Expected:" + expectedData + "\n");
            return false;
        }
    }

    public boolean checkMatches(String description, String actualData, String expectedData) {
        System.out.println(description);

        if (actualData.matches(expectedData)) {
            System.out.println("Actual matches expected");
            System.out.println("Actual:" + actualData);
            System.out.println("Expected:" + expectedData + "\n");
            return true;
        } else {
            System.out.println("Actual not matches expected");
            System.out.println("Actual:" + actualData);
            System.out.println("Expected:" + expectedData + "\n");
            return false;
        }
    }

    public boolean check(String description, double actualData, double expectedData) {
        System.out.println(description);

        if (actualData == expectedData) {
            System.out.println("Actual equals expected");
            System.out.println("Actual:" + actualData);
            System.out.println("Expected:" + expectedData + "\n");
            return true;
        } else {
            System.out.println("Actual not equals expected");
            System.out.println("Actual:" + actualData);
            System.out.println("Expected:" + expectedData + "\n");
            return false;
        }
    }

    public boolean check(String description, int actualData, int expectedData) {
        System.out.println(description);

        if (actualData == expectedData) {
            System.out.println("Actual equals expected");
            System.out.println("Actual:" + actualData);
            System.out.println("Expected:" + expectedData + "\n");
            return true;
        } else {
            System.out.println("Actual not equals expected");
            System.out.println("Actual:" + actualData);
            System.out.println("Expected:" + expectedData + "\n");
            return false;
        }
    }

}
