package pageObjects;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.Base;

public class FooterLinksPageObjects extends Base {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public FooterLinksPageObjects() {
        PageFactory.initElements(driver, this);
    }

    // ---------- Footer Links ----------
    @FindBy(xpath = "//a[@href='http://testautomationpractice.blogspot.com/']")
    WebElement homeLink;

    @FindBy(xpath = "//a[@href='https://testautomationpractice.blogspot.com/p/gui-elements-ajax-hidden.html']")
    WebElement hiddenElementsLink;

    @FindBy(xpath = "//a[normalize-space()='Download Files']")
    WebElement downloadFilesLink;

    @FindBy(xpath = "//a[@class='home-link']")
    WebElement homeReturnLink;

    // ---------- Hidden Elements Section ----------
    @FindBy(id = "input1")
    WebElement input1;

    @FindBy(id = "toggleInput")
    WebElement toggleInput;

    @FindBy(id = "input2")
    WebElement input2;

    @FindBy(id = "checkbox1")
    WebElement checkbox1;

    @FindBy(id = "toggleCheckbox")
    WebElement toggleCheckbox;

    @FindBy(id = "checkbox2")
    WebElement checkbox2;

    @FindBy(id = "loadContent")
    WebElement loadContentBtn;

    @FindBy(id = "statusLabel")
    WebElement statusLabel;

    @FindBy(id = "ajaxContent")
    WebElement ajaxContent;

    @FindBy(xpath = "//a[@class='feed-link']")
    WebElement subscribeTo;

    // ---------- File Download Section ----------
    @FindBy(id = "inputText")
    WebElement inputText;

    @FindBy(id = "generateTxt")
    WebElement generateTxtBtn;

    @FindBy(id = "txtDownloadLink")
    WebElement txtDownloadLink;

    @FindBy(id = "generatePdf")
    WebElement generatePdfBtn;

    @FindBy(id = "pdfDownloadLink")
    WebElement pdfDownloadLink;

    // ---------- Actions ----------
    public void clickHome() {
        if (homeLink.isEnabled()) {
            homeLink.click();
            System.out.println("Home link clicked");
        }
    }

    public void handleHiddenAndAjaxElements() throws InterruptedException {
        hiddenElementsLink.click();
        System.out.println("Hidden Element clicked");

        input1.sendKeys("Hello dear");
        toggleInput.click();
        input2.sendKeys("Hello Max");

        checkbox1.click();
        toggleCheckbox.click();
        checkbox2.click();

        loadContentBtn.click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(loadContentBtn));

        System.out.println("status: " + statusLabel.getText());
        System.out.println("ajax Content: " + ajaxContent.getText());

        String parentWindow = driver.getWindowHandle();
        if (subscribeTo.isEnabled()) {
            subscribeTo.click();
            Set<String> allWindows = driver.getWindowHandles();
            for (String window : allWindows) {
                if (!parentWindow.equals(window)) {
                    driver.switchTo().window(window);
                    driver.close();
                }
            }
            driver.switchTo().window(parentWindow);
        }

        homeReturnLink.click();
    }

    public void downloadFiles() throws InterruptedException {
        downloadFilesLink.click();
        inputText.sendKeys("Welcome to this world!");
        generateTxtBtn.click();
        txtDownloadLink.click();

        String downloadDir = System.getProperty("user.home") + "\\Downloads";
        String txtName = txtDownloadLink.getAttribute("download");
        File txtFile = new File(downloadDir + "\\" + txtName);
        System.out.println(txtFile.exists() ? "File downloaded successfully!" : "File not found!");

        generatePdfBtn.click();
        pdfDownloadLink.click();

        String pdfName = pdfDownloadLink.getAttribute("download");
        File pdfFile = new File(downloadDir + "\\" + pdfName);
        System.out.println(pdfFile.exists() ? "PDF File downloaded successfully!" : "PDF File not found!");

        homeReturnLink.click();
    }
}
