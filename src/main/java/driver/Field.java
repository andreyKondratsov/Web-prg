package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Field {
    DriverManager driverManager = new DriverManager();

    private WebElement getWebElement(String locator) {
        WebElement element = null;
        if (locator.contains("css=")) return driverManager.getDriver().findElement(By.cssSelector(locator.replace("css=", "")));
        if (locator.contains("//")) return driverManager.getDriver().findElement(By.xpath(locator));
        if (locator.contains("name=")) return driverManager.getDriver().findElement(By.name(locator.replace("name=", "")));
        if (locator.contains("id=")) return driverManager.getDriver().findElement(By.id(locator.replace("id=", "")));
        try {
            element = driverManager.getDriver().findElement(By.id(locator));
        } catch (NoSuchElementException e) {
            element = driverManager.getDriver().findElement(By.name(locator));
        }
        return element;
    }

    public void click(String locator) {
        System.out.println("Click to " + locator);
        WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(getWebElement(locator)));
        element.click();
        try {
            Thread.sleep(500); // Добавляем задержку в 500 миллисекунд (полсекунды)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void set(String locator, String text) {
        System.out.println("Set text to " + locator);
        WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(5));

        WebElement element = getWebElement(locator);
        element.clear();
        element.sendKeys(text);
        wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));

    }

    public String get(String locator) {
        System.out.println("Get text from " + locator);
        WebElement element = getWebElement(locator);
        String text = element.getText();
        System.out.println(text);
        return text;
    }
}
