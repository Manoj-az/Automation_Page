package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTablePage {
    WebDriver driver;

    // Constructor
    public WebTablePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By tableTitle = By.xpath("//h2[normalize-space()='Static Web Table']");
    private By rowsLocator = By.xpath("//table[@name='BookTable']//tr");
    private By columnsLocator = By.xpath("//table[@name='BookTable']//th");
    private By priceColumnLocator = By.xpath("//table[@name='BookTable']//tr//td[4]");
    private By subjectColumnLocator = By.xpath("//table[@name='BookTable']//tr//td[3]");
    private By authorColumnLocator = By.xpath("//table[@name='BookTable']//tr//td[2]");
    private By bookNameColumnLocator = By.xpath("//table[@name='BookTable']//tr//td[1]");

    // Get title
    public String getTableTitle() {
        return driver.findElement(tableTitle).getText();
    }

    // Get row count
    public int getRowCount() {
        return driver.findElements(rowsLocator).size();
    }

    // Get column count
    public int getColumnCount() {
        return driver.findElements(columnsLocator).size();
    }

    // Get book information from the table
    public String getBookInfo(int row, int column) {
        return driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + row + "]//td[" + column + "]")).getText();
    }

    // Get price from the table
    public int getBookPrice(int row) {
        String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + row + "]//td[4]")).getText();
        return Integer.parseInt(price);
    }

    // Get author from the table
    public String getBookAuthor(int row) {
        return driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + row + "]//td[2]")).getText();
    }

    // Get subject from the table
    public String getBookSubject(int row) {
        return driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + row + "]//td[3]")).getText();
    }

    // Get book name from the table
    public String getBookName(int row) {
        return driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + row + "]//td[1]")).getText();
    }
}
