package tests;

import java.util.Set;

import org.testng.annotations.Test;
import pageObjects.HandlingTabsAndButtonsPage;
import BaseClass.Base;

public class HandlingTabsAndButtonsTest extends Base {

    @Test(priority = 0)
    public void handleTabAndSearch() {
        HandlingTabsAndButtonsPage tabsAndButtonsPage = new HandlingTabsAndButtonsPage(driver);

        // Perform search operation
        tabsAndButtonsPage.searchForTerm("google");
        tabsAndButtonsPage.printSearchResults();
    }

    @Test(priority = 1)
    public void accessSearchResultsAndHandleTabs() {
        HandlingTabsAndButtonsPage tabsAndButtonsPage = new HandlingTabsAndButtonsPage(driver);

        // Handle search result tabs
        tabsAndButtonsPage.handleSearchResultsAndTabs();
    }

    @Test(priority = 2)
    public void handlingMore() throws InterruptedException {
        HandlingTabsAndButtonsPage tabsAndButtonsPage = new HandlingTabsAndButtonsPage(driver);

        // Handle "More" button
        tabsAndButtonsPage.clickMore();
        Set<String> allWindows = driver.getWindowHandles();
        String parentWindow = driver.getWindowHandle();
        for (String moreHandle : allWindows) {
            if (!moreHandle.equals(parentWindow)) {
                driver.switchTo().window(moreHandle);
                System.out.println("More Window Title: " + driver.getTitle());
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
    }

    @Test(priority = 3)
    public void handleDynamicButtons() {
        HandlingTabsAndButtonsPage tabsAndButtonsPage = new HandlingTabsAndButtonsPage(driver);

        // Click on dynamic buttons (start/stop)
        tabsAndButtonsPage.clickStartButton();
        tabsAndButtonsPage.clickStopButton();
    }
}
