package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.WebTablePage;

import java.time.Duration;
import java.util.Scanner;

public class HandlingWebTablesTest {
    WebDriver driver;
    WebTablePage webTablePage;
    int rows;
    int columns;

    @BeforeClass
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().deleteAllCookies();
        webTablePage = new WebTablePage(driver);
    }

    @Test(priority = 1)
    public void handleStaticWebTable() {
        System.out.println("Title of Element: " + webTablePage.getTableTitle());

        rows = webTablePage.getRowCount();
        System.out.println("Count of Rows: " + rows);

        columns = webTablePage.getColumnCount();
        System.out.println("Count of Columns: " + columns);

        // Get Table Headings
        for (int h = 1; h <= columns; h++) {
            String heading = webTablePage.getBookInfo(1, h);
            System.out.print(heading + " ");
        }
        System.out.println();

        // Read data from table
        for (int r = 2; r <= rows; r++) {
            for (int c = 1; c <= columns; c++) {
                String value = webTablePage.getBookInfo(r, c);
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    @Test(priority = 2)
    public void totalPriceofBooks() {
        int total = 0;

        for (int i = 2; i <= rows; i++) {
            total += webTablePage.getBookPrice(i);
        }
        System.out.println("Total price of all books: " + total);
    }

    @Test(priority = 3)
    public void authorAndPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter subject name: ");
        String mainSubject = sc.nextLine();
        boolean flag = false;

        try {
            for (int i = 2; i <= rows; i++) {
                String subject = webTablePage.getBookSubject(i);
                if (subject.equalsIgnoreCase(mainSubject)) {
                    flag = true;
                    String author = webTablePage.getBookAuthor(i);
                    System.out.println("Author: " + author);

                    String price = webTablePage.getBookPrice(i) + "";
                    System.out.println("Price: " + price);

                    String bookName = webTablePage.getBookName(i);
                    System.out.println("Name of Book: " + bookName);
                }
            }
            if (!flag) {
                System.out.println("Enter a valid subject name.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
