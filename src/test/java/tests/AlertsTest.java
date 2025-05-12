package tests;

import org.testng.annotations.Test;

import BaseClass.Base;
import pageObjects.AlertsPage;

public class AlertsTest extends Base {

    @Test(priority = 0)
    public void testSimpleAlert() throws InterruptedException {
        AlertsPage alerts = new AlertsPage(driver);
        alerts.triggerSimpleAlert();
    }

    @Test(priority = 1)
    public void testConfirmationAlert() throws InterruptedException {
        AlertsPage alerts = new AlertsPage(driver);
        alerts.acceptConfirmationAlert();
        System.out.println("Confirmation accept text: " + alerts.getResultText());

        alerts.dismissConfirmationAlert();
        System.out.println("Confirmation dismiss text: " + alerts.getResultText());
    }

    @Test(priority = 2)
    public void testPromptAlert() throws InterruptedException {
        AlertsPage alerts = new AlertsPage(driver);
        alerts.acceptPromptAlert("John");
        System.out.println("Prompt accept text: " + alerts.getResultText());

        alerts.dismissPromptAlert("John");
        System.out.println("Prompt dismiss text: " + alerts.getResultText());
    }
}
