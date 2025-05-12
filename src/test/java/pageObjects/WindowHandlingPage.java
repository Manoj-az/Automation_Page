package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class WindowHandlingPage {
    private WebDriver driver;

    // Constructor to initialize the driver
    public WindowHandlingPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for elements on the page
    private By newTabButton = By.xpath("//button[normalize-space()='New Tab']");
    private By popUpButton = By.id("PopUp");

    // Method to click on the New Tab button and handle the new tab
    public void clickNewTabButton() {
        WebElement newTab = driver.findElement(newTabButton);
        if (newTab.isEnabled()) {
            newTab.click();
        }
    }

    // Method to click on the Popup button and handle the popup
    public void clickPopUpButton() {
        WebElement pop = driver.findElement(popUpButton);
        if (pop.isEnabled()) {
            pop.click();
        }
    }

    // Method to switch to a new window
    public void switchToWindow(String parentWindow) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String win : allWindows) {
            if (!win.equals(parentWindow)) {
                driver.switchTo().window(win);
                break;
            }
        }
    }

    // Method to close the current window and switch back to the parent window
    public void closeAndSwitchToParent(String parentWindow) {
        driver.close();
        driver.switchTo().window(parentWindow);
    }
}
