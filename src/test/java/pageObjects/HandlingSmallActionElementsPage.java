package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HandlingSmallActionElementsPage {
    private WebDriver driver;

    // Constructor to initialize the driver
    public HandlingSmallActionElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By mouseHoverButton = By.xpath("//button[normalize-space()='Point Me']");
    private By dropdownLinks = By.xpath("//div[@class='dropdown-content']//a");
    private By doubleClickButton = By.xpath("//button[normalize-space()='Copy Text']");
    private By inputField1 = By.xpath("//input[@id='field1']");
    private By inputField2 = By.xpath("//input[@id='field2']");
    private By draggableElement = By.id("draggable");
    private By droppableElement = By.id("droppable");
    private By sliderHandle = By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default'][1]");
    private By svgCircle = By.xpath("//*[local-name()='svg']//*[local-name()='circle']");
    private By svgRect = By.xpath("//*[local-name()='svg'][2]/*[local-name()='rect'][1]");
    private By svgPolygon = By.xpath("//*[local-name()='svg']/*[local-name()='polygon']");
    private By scrollInput = By.xpath("//input[@id='comboBox']");
    private By dropdownOptions = By.xpath("//div[@class='option']");

    // Methods
    public void mouseHoverAction() {
        WebElement mouse = driver.findElement(mouseHoverButton);
        mouse.click();
        List<WebElement> mouseHoverLinks = driver.findElements(dropdownLinks);
        Actions actions = new Actions(driver);
        for (WebElement link : mouseHoverLinks) {
            actions.moveToElement(mouse).moveToElement(link).perform();
            System.out.println(link.getText() + " Clicked");
            link.click();
        }
    }

    public void doubleClickAction() {
        WebElement doubleClickButtonElement = driver.findElement(doubleClickButton);
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButtonElement).perform();
    }

    public void dragAndDropAction() {
        WebElement drag = driver.findElement(draggableElement);
        WebElement drop = driver.findElement(droppableElement);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop).perform();
    }

    public void moveSlider() {
        WebElement slider = driver.findElement(sliderHandle);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, -100, 0).perform();
    }

    public void handleSVG() {
        WebElement svgCircleElement = driver.findElement(svgCircle);
        String svgColor = svgCircleElement.getAttribute("fill");
        String svgCx = svgCircleElement.getAttribute("cx");
        String svgCy = svgCircleElement.getAttribute("cy");
        String svgStroke = svgCircleElement.getAttribute("stroke");
        System.out.println(svgColor + " cx:" + svgCx + " cy:" + svgCy + " Stroke:" + svgStroke);

        WebElement svgRectElement = driver.findElement(svgRect);
        WebElement svgPolyElement = driver.findElement(svgPolygon);

        // Add any logic you want to handle SVG rectangle or polygon here...
    }

    public void handleScrollingElement() {
        WebElement handleScroll = driver.findElement(scrollInput);
        handleScroll.click();
        List<WebElement> dropdownItems = driver.findElements(dropdownOptions);
        System.out.println(dropdownItems.size());
        for (WebElement item : dropdownItems) {
            System.out.println(item.getText());
        }
    }
}
