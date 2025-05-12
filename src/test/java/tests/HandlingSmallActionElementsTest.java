package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HandlingSmallActionElementsPage;

public class HandlingSmallActionElementsTest {
    private WebDriver driver;
    private HandlingSmallActionElementsPage elementsPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.com");  // Replace with the actual URL of the page
        elementsPage = new HandlingSmallActionElementsPage(driver);
    }

    @Test(priority = 0)
    public void testMouseHover() {
        elementsPage.mouseHoverAction();
    }

    @Test(priority = 1)
    public void testDoubleClick() {
        elementsPage.doubleClickAction();
    }

    @Test(priority = 2)
    public void testDragAndDrop() {
        elementsPage.dragAndDropAction();
    }

    @Test(priority = 3)
    public void testSlider() {
        elementsPage.moveSlider();
    }

    @Test(priority = 4)
    public void testSVG() {
        elementsPage.handleSVG();
    }

    @Test(priority = 5)
    public void testScrolling() {
        elementsPage.handleScrollingElement();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
