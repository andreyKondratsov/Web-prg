package core.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Field {

    String locator;

    public Field(String locator){
        this.locator = locator;
    }

    DriverManager driverManager = new DriverManager();

    public String getLocator(){
        return this.locator;
    }

    private WebElement getWebElement(){
        return getWebElement(getLocator());
    }

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

    public void click(){
        click(getLocator());
    }

    public void click(String locator) {
        System.out.println("Click to " + locator + "\n");
        WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(getWebElement(locator)));
        element.click();
        try {
            Thread.sleep(500); // Добавляем задержку в 500 миллисекунд (полсекунды)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void set(String text){
        set(getLocator(), text);
    }

    public void set(String locator, String text) {
        System.out.println("Set text to " + locator + "\n");
        WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(5));

        WebElement element = getWebElement(locator);
        element.clear();
        element.sendKeys(text);
        wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));

    }

    public String get(){
        return get(getLocator());
    }

    public String get(String locator) {
        System.out.println("Get text from " + locator + "\n");
        WebElement element = getWebElement(locator);
        String text = element.getText();
        System.out.println(text + "\n");
        return text;
    }

    public void sendKeys(Keys... keysToSend){
        sendKeys(getLocator(), keysToSend);
    }

    public void sendKeys(String locator, Keys... keysToSend){
        System.out.println("Send Keys " + keysToSend +" at "+ locator + "\n");
        WebElement element = getWebElement(locator);
        element.sendKeys(keysToSend);
    }
}
