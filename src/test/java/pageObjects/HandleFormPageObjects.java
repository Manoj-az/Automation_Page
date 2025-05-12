package pageObjects;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.Base;

public class HandleFormPageObjects extends Base {

    public HandleFormPageObjects() {
        PageFactory.initElements(driver, this);
    }

    // ------- Form Input Fields -------
    @FindBy(id = "input1")
    WebElement inputField1;

    @FindBy(id = "btn1")
    WebElement submitBtn1;

    @FindBy(id = "input2")
    WebElement inputField2;

    @FindBy(id = "btn2")
    WebElement submitBtn2;

    @FindBy(id = "input3")
    WebElement inputField3;

    @FindBy(id = "btn3")
    WebElement submitBtn3;

    // ------- Action Method -------
    public void fillAndSubmitForm(String randomData) {
        inputField1.sendKeys(randomData);
        System.out.println("Entered text1: " + randomData);
        submitBtn1.click();

        inputField2.sendKeys(randomData);
        System.out.println("Entered text2: " + randomData);
        submitBtn2.click();

        inputField3.sendKeys(randomData);
        System.out.println("Entered text3: " + randomData);
        submitBtn3.click();
    }

    // ------- Utility -------
    public String generateRandomText() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
}

