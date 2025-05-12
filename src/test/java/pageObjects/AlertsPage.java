package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    WebDriver driver;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    By simpleAlertBtn = By.id("alertBtn");
    By confirmAlertBtn = By.id("confirmBtn");
    By promptAlertBtn = By.id("promptBtn");
    By resultText = By.id("demo");

    public void triggerSimpleAlert() {
        driver.findElement(simpleAlertBtn).click();
        driver.switchTo().alert().accept();
    }

    public void acceptConfirmationAlert() {
        driver.findElement(confirmAlertBtn).click();
        driver.switchTo().alert().accept();
    }

    public void dismissConfirmationAlert() {
        driver.findElement(confirmAlertBtn).click();
        driver.switchTo().alert().dismiss();
    }

    public void acceptPromptAlert(String input) {
        driver.findElement(promptAlertBtn).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(input);
        alert.accept();
    }

    public void dismissPromptAlert(String input) {
        driver.findElement(promptAlertBtn).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(input);
        alert.dismiss();
    }

    public String getResultText() {
        return driver.findElement(resultText).getText();
    }
}
