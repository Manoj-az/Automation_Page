package tests;

import org.testng.annotations.Test;
import BaseClass.Base;
import pageObjects.HandlingDynamicWebTablesPage;

import java.util.Scanner;

public class HandlingDynamicWebTablesTest extends Base {

    HandlingDynamicWebTablesPage tablePage;

    @Test(priority = 1)
    public void printTitle() {
        tablePage = new HandlingDynamicWebTablesPage(driver);
        System.out.println("Page Title: " + tablePage.getTitleText());
    }

    @Test(priority = 2)
    public void getSpecificBrowserRowData() {
        tablePage = new HandlingDynamicWebTablesPage(driver);

        int rows = tablePage.getRowCount();
        int columns = tablePage.getColumnCount();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter browser name: ");
        String browser = sc.nextLine();
        boolean found = false;

        for (int r = 2; r <= rows; r++) {
            String browserName = tablePage.getBrowserNameInRow(r);
            if (browserName.equalsIgnoreCase(browser)) {
                found = true;
                System.out.println("Data for " + browser + ":");
                for (int c = 1; c <= columns; c++) {
                    System.out.println(tablePage.getCellData(r, c));
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Browser Not Found");
        }
    }

    @Test(priority = 3)
    public void getDisplayDetails() {
        tablePage = new HandlingDynamicWebTablesPage(driver);
        System.out.println("CPU load of Chrome process: " + tablePage.chromeCPU.getText());
        System.out.println("Memory Size of Firefox process: " + tablePage.firefoxMemory.getText());
        System.out.println("Network speed of Chrome process: " + tablePage.chromeNetwork.getText());
        System.out.println("Disk space of Firefox process: " + tablePage.firefoxDisk.getText());
    }
}
