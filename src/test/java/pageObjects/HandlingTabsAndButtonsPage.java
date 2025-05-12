package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.commons.io.FileUtils;
import java.io.File;
import org.openqa.selenium.OutputType;
import java.util.List;
import java.util.Set;

public class HandlingTabsAndButtonsPage {
    WebDriver driver;

    // Locators for elements on the page
    By tab = By.id("Wikipedia1_wikipedia-search-input");
    By searchTab = By.xpath("//input[@class='wikipedia-search-button']");
    By searchResults = By.xpath("//div[@id='wikipedia-search-result-link']//a");
    By moreButton = By.xpath("//div[@id='Wikipedia1_wikipedia-search-more']//a");
    By btnStart = By.xpath("//button[@onclick='toggleButton(this)']");
    By btnStop = By.xpath("//button[@class='stop']");

    public HandlingTabsAndButtonsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with elements
    public WebElement getTab() {
        return driver.findElement(tab);
    }

    public WebElement getSearchTab() {
        return driver.findElement(searchTab);
    }

    public List<WebElement> getSearchResults() {
        return driver.findElements(searchResults);
    }

    public WebElement getMoreButton() {
        return driver.findElement(moreButton);
    }

    public WebElement getBtnStart() {
        return driver.findElement(btnStart);
    }

    public WebElement getBtnStop() {
        return driver.findElement(btnStop);
    }

    // Methods for Tabs and Search functionality
    public void searchForTerm(String term) {
        getTab().click();
        getTab().sendKeys(term);
        getSearchTab().click();
    }

    public void printSearchResults() {
        for (WebElement result : getSearchResults()) {
            System.out.println(result.getText());
        }
    }

    public void handleSearchResultsAndTabs() {
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window Handle: " + parentWindow);

        for (WebElement result : getSearchResults()) {
            result.click();
            Set<String> windowHandles = driver.getWindowHandles();

            for (String handle : windowHandles) {
                if (!handle.equals(parentWindow)) {
                    driver.switchTo().window(handle);
                    System.out.println("Child Window Title: " + driver.getTitle());
                    driver.close();
                }
            }
            driver.switchTo().window(parentWindow);
        }
    }

    // Methods for handling dynamic buttons
    public void clickStartButton() {
        if (getBtnStart().isEnabled()) {
            getBtnStart().click();
            takeScreenshot(getBtnStart(), "DynamicButton1.png");
            System.out.println("Start Button Clicked: " + getBtnStart().getText());
        } else {
            System.out.println("Start Button not Clicked");
        }
    }

    public void clickStopButton() {
        if (getBtnStop().isEnabled()) {
            getBtnStop().click();
            takeScreenshot(getBtnStop(), "DynamicButton2.png");
            System.out.println("Stop Button Clicked: " + getBtnStop().getText());
        } else {
            System.out.println("Stop Button not Clicked");
        }
    }

    private void takeScreenshot(WebElement element, String fileName) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            File source = element.getScreenshotAs(OutputType.FILE);
            File target = new File("E:/AutomationPraticePage/Screenshots/" + fileName);
            FileUtils.copyFile(source, target);
            System.out.println("Screenshot saved at: " + target);
        } catch (Exception e) {
            System.out.println("Error while taking screenshot: " + e.getMessage());
        }
    }

    // Method to handle "More" link
    public void clickMore() {
        getMoreButton().click();
    }
}
