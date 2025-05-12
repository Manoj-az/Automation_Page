package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.PracticePage;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class HandlingGUIElementsTest {

    private WebDriver driver;
    private PracticePage practicePage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        practicePage = new PracticePage(driver);
    }

    @Test(priority = 1)
    public void inputNameHandling() throws IOException {
        practicePage.enterName("ABCD");
        takeScreenshot("NameInputBox.png");
    }

    @Test(priority = 2)
    public void inputEmailHandling() throws IOException {
        practicePage.enterEmail("abcde@gmail.com");
        takeScreenshot("MailInputBox.png");
    }

    @Test(priority = 3)
    public void inputPhoneHandling() throws IOException {
        practicePage.enterPhone("9999999999");
        takeScreenshot("NumberInputBox.png");
    }

    @Test(priority = 4)
    public void inputTextHandling() throws IOException {
        practicePage.enterText("Automation Test Practice");
        takeScreenshot("AddressBox.png");
    }

    @Test(priority = 5)
    public void checkBoxMale() throws IOException {
        practicePage.clickMaleRadioButton();
        takeScreenshot("GenderRadioButton.png");
    }

    @Test(priority = 6)
    public void days() {
        practicePage.selectDays();
    }

    @Test(priority = 7)
    public void boxSelected() throws IOException {
        practicePage.selectCheckboxes();
        takeScreenshot("DaysSelected.png");
    }

    @Test(priority = 8)
    public void countrySelected() throws IOException {
        practicePage.selectCountry("germany");
        takeScreenshot("CountrySelected.png");
    }

    @Test(priority = 9)
    public void colorSelected() throws IOException {
        practicePage.selectColor("white");
        takeScreenshot("ColorSelected.png");
    }

    @Test(priority = 10)
    public void sortedList() throws IOException {
        practicePage.selectAnimal("Lion");
        takeScreenshot("Animals.png");
    }

    @Test(priority = 11)
    public void datePicker() throws IOException {
        practicePage.pickDate1("6");
        takeScreenshot("DatePicker1.png");
    }

    @Test(priority = 12)
    public void datePicker2() throws IOException {
        practicePage.pickDate2("6");
        takeScreenshot("DatePicker2.png");
    }

    @Test(priority = 13)
    public void datePicker3() throws IOException {
        practicePage.pickDate3("6");
        takeScreenshot("DatePicker3.png");
    }

    @Test(priority = 14)
    public void subscribeToLink() {
        practicePage.subscribeToLink();
    }

    private void takeScreenshot(String fileName) throws IOException {
        TakesScreenshot ss = (TakesScreenshot) driver;
        File source = ss.getScreenshotAs(OutputType.FILE);
        File target = new File("E:/AutomationPraticePage/Screenshots/" + fileName);
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot saved in folder: " + target);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
