package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class for handling dynamic web tables using PageFactory.
 */
public class HandlingDynamicWebTablesPage {

    WebDriver driver;

    public HandlingDynamicWebTablesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[normalize-space()='Dynamic Web Table']")
    public WebElement title;

    @FindBy(xpath = "//table[@id='taskTable']//tr")
    public List<WebElement> allRows;

    @FindBy(xpath = "//table[@id='taskTable']//th")
    public List<WebElement> allColumns;

    @FindBy(xpath = "//strong[@class='chrome-cpu']")
    public WebElement chromeCPU;

    @FindBy(xpath = "//strong[@class='firefox-memory']")
    public WebElement firefoxMemory;

    @FindBy(xpath = "//strong[@class='chrome-network']")
    public WebElement chromeNetwork;

    @FindBy(xpath = "//strong[@class='firefox-disk']")
    public WebElement firefoxDisk;

    public String getTitleText() {
        return title.getText();
    }

    public int getRowCount() {
        return allRows.size();
    }

    public int getColumnCount() {
        return allColumns.size();
    }

    public String getCellData(int rowIndex, int colIndex) {
        return driver.findElement(
                org.openqa.selenium.By.xpath("//table[@id='taskTable']//tr[" + rowIndex + "]//td[" + colIndex + "]")
        ).getText();
    }

    public String getBrowserNameInRow(int rowIndex) {
        return driver.findElement(
                org.openqa.selenium.By.xpath("//table[@id='taskTable']//tr[" + rowIndex + "]//td[1]")
        ).getText();
    }
}
