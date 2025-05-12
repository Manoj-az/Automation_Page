package pageObjects;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HandlePageWebTablePage {

    private WebDriver driver;

    // Constructor to initialize WebDriver and PageFactory
    public HandlePageWebTablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Web elements for table and pagination
    @FindBy(xpath = "//table[@id='productTable']//tbody//tr")
    private List<WebElement> rows;

    @FindBy(xpath = "//table[@id='productTable']//tr//th")
    private List<WebElement> cols;

    @FindBy(xpath = "//ul[@id='pagination']//li")
    private List<WebElement> paginationLinks;

    @FindBy(xpath = "//table[@id='productTable']//tr[1]//th")
    private List<WebElement> tableHeader;

    @FindBy(xpath = "//table[@id='productTable']//input[@type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//div[@id='HTML8']")
    private WebElement tableSection;

    // Method to scroll into view for the table
    public void scrollToTable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", tableSection);
    }

    // Method to get row and column size and print values
    public void printTableData() {
        int rowsCount = rows.size();
        int colsCount = cols.size();
        System.out.println("No.of Rows: " + rowsCount);
        System.out.println("No.of Columns: " + colsCount);

        // Print table header
        for (int j = 1; j < colsCount; j++) {
            String value = driver.findElement(By.xpath("//table[@id='productTable']//tr[1]//th[" + j + "]")).getText();
            System.out.print(value + " ");
        }
        System.out.println();

        // Print table data
        for (int r = 1; r <= rowsCount; r++) {
            for (int c = 1; c <= colsCount; c++) {
                String value = driver.findElement(By.xpath("//table[@id='productTable']//tr[" + r + "]//td[" + c + "]")).getText();
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // Method to handle pagination and checkbox selection
    public void handlePaginationAndCheckboxes() {
        for (WebElement pageLink : paginationLinks) {
            String pageNumber = pageLink.getText();
            int pageNum = Integer.parseInt(pageNumber);
            System.out.println("Page Number: " + pageNum);

            if (pageNum > 1) {
                pageLink.click();
            }

            int rowsCount = rows.size();
            for (int j = 1; j <= rowsCount; j++) {
                WebElement rowData = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + j + "]//td[2]"));
                System.out.println(rowData.getText());

                for (WebElement checkbox : checkboxes) {
                    if (!checkbox.isSelected()) {
                        checkbox.click();
                        System.out.println("Checkbox clicked");
                    }
                }
            }
        }
    }
}
