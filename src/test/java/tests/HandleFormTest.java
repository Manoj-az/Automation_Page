package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HandleFormPageObjects;

public class HandleFormTest {

    HandleFormPageObjects formPage = new HandleFormPageObjects();

    @Test(dataProvider = "dynamicText")
    public void testFormSubmission(String randomData) {
        formPage.fillAndSubmitForm(randomData);
    }

    @DataProvider(name = "dynamicText")
    public Object[][] getDynamicData() {
        return new Object[][] {
            {formPage.generateRandomText()},
            {formPage.generateRandomText()}
        };
    }
}
