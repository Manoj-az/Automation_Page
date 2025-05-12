package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadPage {

    WebDriver driver;

    // Constructor to initialize the driver
    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    private By title = By.xpath("//h2[normalize-space()='Upload Files']");
    private By btnSingleFile = By.xpath("//button[normalize-space()='Upload Single File']");
    private By btnMultipleFiles = By.xpath("//button[normalize-space()='Upload Multiple Files']");
    private By inputSingleFile = By.xpath("//input[@id='singleFileInput']");
    private By inputMultipleFiles = By.id("multipleFilesInput");
    private By statusSingleFile = By.id("singleFileStatus");
    private By statusMultipleFiles = By.id("multipleFilesStatus");

    // Getters for WebElements
    public WebElement getTitle() {
        return driver.findElement(title);
    }

    public WebElement getBtnSingleFile() {
        return driver.findElement(btnSingleFile);
    }

    public WebElement getBtnMultipleFiles() {
        return driver.findElement(btnMultipleFiles);
    }

    public WebElement getInputSingleFile() {
        return driver.findElement(inputSingleFile);
    }

    public WebElement getInputMultipleFiles() {
        return driver.findElement(inputMultipleFiles);
    }

    public WebElement getStatusSingleFile() {
        return driver.findElement(statusSingleFile);
    }

    public WebElement getStatusMultipleFiles() {
        return driver.findElement(statusMultipleFiles);
    }
}
