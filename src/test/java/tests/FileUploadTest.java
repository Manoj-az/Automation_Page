package tests;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.FileUploadPage;

public class FileUploadTest {

    WebDriver driver;
    FileUploadPage fileUploadPage;

    @BeforeClass
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        
        // Pass driver to the page object
        fileUploadPage = new FileUploadPage(driver);
    }

    @Test(priority = 1)
    public void getTitleOfFiles() {
        System.out.println(fileUploadPage.getTitle().getText());
    }

    @Test(priority = 2)
    public void handleButtonWithoutUploadFile() {
        if (fileUploadPage.getBtnSingleFile().isEnabled()) {
            fileUploadPage.getBtnSingleFile().click();
            System.out.println(fileUploadPage.getStatusSingleFile().getText());
        }
        
        if (fileUploadPage.getBtnMultipleFiles().isEnabled()) {
            fileUploadPage.getBtnMultipleFiles().click();
            System.out.println(fileUploadPage.getStatusMultipleFiles().getText());
        }
    }

    @Test(priority = 3)
    public void inputHandles() {
        String pathSingleFile = "E:\\Testing\\Interview QA.pdf";
        if (fileUploadPage.getInputSingleFile().isDisplayed()) {
            fileUploadPage.getInputSingleFile().sendKeys(pathSingleFile);
            System.out.println("File Uploaded: " + pathSingleFile);
        }

        String pathMultipleFiles = "E:\\Testing\\demo.xlsx";
        if (fileUploadPage.getInputMultipleFiles().isDisplayed()) {
            fileUploadPage.getInputMultipleFiles().sendKeys(pathMultipleFiles);
            fileUploadPage.getInputMultipleFiles().sendKeys("E:\\Testing\\demo1.xlsx");
            System.out.println("Files Uploaded: " + pathMultipleFiles);
        }
    }

    @Test(priority = 4)
    public void buttonsHandles() {
        if (fileUploadPage.getBtnSingleFile().isEnabled()) {
            fileUploadPage.getBtnSingleFile().click();
            System.out.println("Button Clicked: " + fileUploadPage.getBtnSingleFile().getText());
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", fileUploadPage.getBtnSingleFile());
                TakesScreenshot ss = (TakesScreenshot) driver;
                File source = ss.getScreenshotAs(OutputType.FILE);
                File target = new File("E:/AutomationPraticePage/Screenshots/SingleFile.png");
                FileUtils.copyFile(source, target);
                System.out.println("Screenshot saved in folder: " + target);
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        if (fileUploadPage.getBtnMultipleFiles().isEnabled()) {
            fileUploadPage.getBtnMultipleFiles().click();
            System.out.println("Button Clicked: " + fileUploadPage.getBtnMultipleFiles().getText());
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", fileUploadPage.getBtnMultipleFiles());
                TakesScreenshot ss = (TakesScreenshot) driver;
                File source = ss.getScreenshotAs(OutputType.FILE);
                File target = new File("E:/AutomationPraticePage/Screenshots/MultipleFiles.png");
                FileUtils.copyFile(source, target);
                System.out.println("Screenshot saved in folder: " + target);
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
