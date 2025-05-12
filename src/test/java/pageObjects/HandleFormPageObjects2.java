package pageObjects;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebDriver;

public class HandleFormPageObjects2 {

    WebDriver driver;

    // Constructor to initialize WebDriver and PageFactory elements
    public HandleFormPageObjects2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ------- Form Elements -------
    @FindBy(id = "input2")
    WebElement inputField;

    @FindBy(id = "btn2")
    WebElement submitButton;

    // ------- Actions -------
    public void enterDataAndSubmit(int data) {
        inputField.sendKeys(String.valueOf(data));
        System.out.println("Entered text: " + data);
        submitButton.click();
    }

    // ------- Utility -------
    public int generateRandomNumber() {
        int number = 793;
        Random rand = new Random();
        int rand_int = rand.nextInt(100);
        int result = number + rand_int;
        System.out.println("Generated random number: " + result);
        return result;
    }
}
