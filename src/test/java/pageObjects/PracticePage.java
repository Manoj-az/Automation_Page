package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PracticePage {

    private WebDriver driver;

    public PracticePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By title = By.xpath("//h1[@class='title']");
    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By phoneField = By.id("phone");
    private By textArea = By.id("textarea");
    private By maleRadioButton = By.id("male");
    private By daysCheckboxes = By.xpath("//div[@class='form-check form-check-inline']//input[@type='checkbox']");
    private By countryDropdown = By.id("country");
    private By colorDropdown = By.id("colors");
    private By animalsDropdown = By.id("animals");
    private By datePicker1 = By.xpath("//input[@id='datepicker']");
    private By datePicker2 = By.xpath("//input[@id='txtDate']");
    private By datePicker3 = By.xpath("//input[@id='start-date']");
    private By subscribeLink = By.xpath("//a[@class='feed-link']");

    // Methods
    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void enterName(String name) {
        WebElement nameElement = driver.findElement(nameField);
        if (nameElement.isEnabled()) {
            nameElement.sendKeys(name);
        }
    }

    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        if (emailElement.isEnabled()) {
            emailElement.sendKeys(email);
        }
    }

    public void enterPhone(String phone) {
        WebElement phoneElement = driver.findElement(phoneField);
        if (phoneElement.isEnabled()) {
            phoneElement.sendKeys(phone);
        }
    }

    public void enterText(String text) {
        WebElement textElement = driver.findElement(textArea);
        if (textElement.isEnabled()) {
            textElement.sendKeys(text);
        }
    }

    public void clickMaleRadioButton() {
        WebElement maleElement = driver.findElement(maleRadioButton);
        if (!maleElement.isSelected()) {
            maleElement.click();
        }
    }

    public void selectDays() {
        // Logic to select days (if needed)
    }

    public void selectCheckboxes() {
        // Logic for selecting some checkboxes
    }

    public void selectCountry(String country) {
        Select countryDropdownElement = new Select(driver.findElement(countryDropdown));
        countryDropdownElement.selectByValue(country);
    }

    public void selectColor(String color) {
        Select colorDropdownElement = new Select(driver.findElement(colorDropdown));
        colorDropdownElement.selectByValue(color);
    }

    public void selectAnimal(String animal) {
        Select animalDropdownElement = new Select(driver.findElement(animalsDropdown));
        animalDropdownElement.selectByVisibleText(animal);
    }

    public void pickDate1(String date) {
        WebElement dateElement = driver.findElement(datePicker1);
        dateElement.click();
        WebElement selectDate = driver.findElement(By.xpath("//a[@data-date='" + date + "']"));
        selectDate.click();
    }

    public void pickDate2(String date) {
        WebElement dateElement = driver.findElement(datePicker2);
        dateElement.click();
        WebElement selectDate = driver.findElement(By.xpath("//a[@data-date='" + date + "']"));
        selectDate.click();
    }

    public void pickDate3(String date) {
        WebElement dateElement = driver.findElement(datePicker3);
        dateElement.click();
    }

    public void subscribeToLink() {
        WebElement link = driver.findElement(subscribeLink);
        link.click();
    }
}
