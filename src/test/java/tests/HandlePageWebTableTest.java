package tests;

import org.testng.annotations.Test;

import BaseClass.Base;
import pageObjects.HandlePageWebTablePage;

public class HandlePageWebTableTest extends Base {

    @Test(priority = 0)
    public void testPageTable() {
        HandlePageWebTablePage page = new HandlePageWebTablePage(driver);
        page.scrollToTable();
        page.printTableData();
    }

    @Test(priority = 1)
    public void testPageTableWithPagination() {
        HandlePageWebTablePage page = new HandlePageWebTablePage(driver);
        page.handlePaginationAndCheckboxes();
    }
}
