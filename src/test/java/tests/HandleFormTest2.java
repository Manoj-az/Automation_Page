package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HandleFormPageObjects2;

import java.time.Duration;

public class HandleFormTest2 {

    WebDriver driver;
    HandleFormPageObjects2 formPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().deleteAllCookies();
        formPage = new HandleFormPageObjects2(driver);
    }

    @Test(dataProvider = "dynamicText")
    public void testFormSubmission(int randomData) {
        formPage.enterDataAndSubmit(randomData);
    }

    @DataProvider(name = "dynamicText")
    public Object[][] getDynamicData() {
        return new Object[][] {
            {formPage.generateRandomNumber()}
        };
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
