package tests;

import org.testng.annotations.Test;

import BaseClass.Base;
import pageObjects.HandleShadowDOMPageObjects;

public class HandleShadowDOMTest extends Base {

    @Test
    public void verifyShadowDOMInteractions() {
        HandleShadowDOMPageObjects shadowPage = new HandleShadowDOMPageObjects(driver);

        System.out.println("Shadow Text: " + shadowPage.getShadowContentText());
        System.out.println("Nested Shadow Text: " + shadowPage.getNestedShadowContentText());

        try {
            shadowPage.clickBlogLink();
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("Error clicking blog link: " + e.getMessage());
        }

        shadowPage.enterTextInInput("Hello");
        System.out.println("Entered text: " + shadowPage.getEnteredText());

        shadowPage.toggleCheckboxIfNotSelected();

        String filePath = "C:\\Users\\manoj\\Downloads\\info.txt";
        shadowPage.uploadFile(filePath);
        System.out.println("File upload completed.");

        try {
            shadowPage.clickYouTubeLink();
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("Error clicking YouTube link: " + e.getMessage());
        }
    }
}
