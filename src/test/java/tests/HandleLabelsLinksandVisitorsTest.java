package tests;

import org.testng.annotations.Test;

import BaseClass.Base;
import pageObjects.HandleLabelsLinksandVisitorsPage;

public class HandleLabelsLinksandVisitorsTest extends Base {

    // Test method for handling mobile labels
    @Test(priority = 0)
    public void testHandleMobileLabels() {
        HandleLabelsLinksandVisitorsPage page = new HandleLabelsLinksandVisitorsPage();
        page.handleMobileLabels();
    }

    // Test method for handling laptop links
    @Test(priority = 1)
    public void testHandleLaptopLinks() throws InterruptedException {
        HandleLabelsLinksandVisitorsPage page = new HandleLabelsLinksandVisitorsPage();
        page.handleLaptopLinks();
    }

    // Test method for handling broken links
    @Test(priority = 2)
    public void testHandleBrokenLinks() {
        HandleLabelsLinksandVisitorsPage page = new HandleLabelsLinksandVisitorsPage();
        page.handleBrokenLinks();
    }

    // Test method for handling visitors section
    @Test(priority = 3)
    public void testHandleVisitors() {
        HandleLabelsLinksandVisitorsPage page = new HandleLabelsLinksandVisitorsPage();
        page.handleVisitors();
    }
}
