package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.WindowHandlingPage;
import java.time.Duration;

public class HandlingNewTabandPopupTest {

    private WebDriver driver;
    private WindowHandlingPage windowHandlingPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.com");  // Replace with the actual URL of the page
        windowHandlingPage = new WindowHandlingPage(driver);
    }

    @Test(priority = 0)
    public void handleNewTab() {
        String parentWindow = driver.getWindowHandle();
        windowHandlingPage.clickNewTabButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Switch to the new tab and close it
        windowHandlingPage.switchToWindow(parentWindow);
        System.out.println("Title of New Tab window: " + driver.getTitle());
        windowHandlingPage.closeAndSwitchToParent(parentWindow);
    }

    @Test(priority = 1)
    public void handlePopUp() {
        String parentWindow = driver.getWindowHandle();
        windowHandlingPage.clickPopUpButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));

        // Switch to the popup window and close it
        windowHandlingPage.switchToWindow(parentWindow);
        System.out.println("Popup window Title: " + driver.getTitle());
        windowHandlingPage.closeAndSwitchToParent(parentWindow);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
