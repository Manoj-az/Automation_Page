package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BaseClass.Base;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class HandleLabelsLinksandVisitorsPage extends Base {

    // Locators for labels under 'Mobiles' section
    @FindBy(xpath = "//div[@id='mobiles']//label")
    private List<WebElement> mobiles;

    // Locators for links under 'Laptops' section
    @FindBy(xpath = "//div[@id='laptops']//a")
    private List<WebElement> laptops;

    // Locators for broken links under 'Broken Links' section
    @FindBy(xpath = "//div[@id='broken-links']//a")
    private List<WebElement> brokenLinks;

    // Locators for the Visitors section
    @FindBy(id = "Stats1_totalCount")
    private WebElement visitorsCount;

    @FindBy(xpath = "//*[local-name()='g']//*[local-name()='rect']")
    private WebElement svgElement;

    // Constructor to initialize elements
    public HandleLabelsLinksandVisitorsPage() {
        PageFactory.initElements(driver, this);
    }

    // Method to handle mobile labels
    public void handleMobileLabels() {
        System.out.println("Mobiles size: " + mobiles.size());
        for (WebElement mobileLabel : mobiles) {
            String mobilesText = mobileLabel.getText();
            System.out.println(mobilesText);
            switch (mobilesText) {
                case "Samsung":
                    Assert.assertEquals(mobilesText, "Samsung");
                    break;
                case "Real Me":
                    Assert.assertEquals(mobilesText, "Real Me");
                    break;
                case "Moto":
                    Assert.assertEquals(mobilesText, "Moto");
                    break;
                default:
                    Assert.fail("Error Occured");
            }
        }
    }

    // Method to handle laptop links
    public void handleLaptopLinks() throws InterruptedException {
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (WebElement laptopHandle : laptops) {
            String txt = laptopHandle.getText();
            System.out.println(txt);
            mywait.until(ExpectedConditions.elementToBeClickable(laptopHandle)).click();
            String title = driver.getTitle();
            System.out.println("Link of: " + txt + " " + title);
            driver.navigate().back();
            mywait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='laptops']//a")));
        }
    }

    // Method to handle broken links
    public void handleBrokenLinks() {
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        for (WebElement link : brokenLinks) {
            String brokenLinkName = link.getAttribute("innerText");
            System.out.println(brokenLinkName);
            mywait.until(ExpectedConditions.elementToBeClickable(link)).click();
            String title = driver.getTitle();
            System.out.println("Title of " + brokenLinkName + " " + title);
            driver.navigate().back();
            // Assert for various error codes
            Assert.assertEquals(title, "401 - Unauthorized: Access is denied due to invalid credentials.");
            Assert.assertEquals(title, "403 - Forbidden: Access is denied.");
            Assert.assertEquals(title, "404 - File or directory not found.");
            Assert.assertEquals(title, "500 - Internal server error.");
            Assert.assertEquals(title, "502 - Web server received an invalid response while acting as a gateway or proxy server.");
        }
    }

    // Method to handle the Visitors section
    public void handleVisitors() {
        String value = visitorsCount.getText();
        System.out.println(value);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        @SuppressWarnings("unchecked")
        Map<String, String> attributes = (Map<String, String>) js.executeScript(
                "var items = {}; " +
                        "for (var i = 0; i < arguments[0].attributes.length; i++) { " +
                        "items[arguments[0].attributes[i].name] = arguments[0].attributes[i].value; " +
                        "} " +
                        "return items;", svgElement);

        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // Assertions for specific key-value pairs
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String key = entry.getKey();
            String valueAttribute = entry.getValue();
            switch (key) {
                case "fill":
                    Assert.assertEquals(valueAttribute, "#ffffff", "Value for 'fill' is incorrect");
                    break;
                case "fill-opacity":
                    Assert.assertEquals(valueAttribute, "0", "Value for 'height' is incorrect");
                    break;
                case "height":
                    Assert.assertEquals(valueAttribute, "30", "Value for 'height' is incorrect");
                    break;
                case "stroke":
                    Assert.assertEquals(valueAttribute, "none", "Value for 'stroke' is incorrect");
                    break;
                case "stroke-width":
                    Assert.assertEquals(valueAttribute, "0", "Value for 'stroke-width' is incorrect");
                    break;
                case "width":
                    Assert.assertEquals(valueAttribute, "75", "Value for 'width' is incorrect");
                    break;
                case "x":
                    Assert.assertEquals(valueAttribute, "0", "Value for 'x' is incorrect");
                    break;
                case "y":
                    Assert.assertEquals(valueAttribute, "0", "Value for 'y' is incorrect");
                    break;
            }
        }
    }
}
