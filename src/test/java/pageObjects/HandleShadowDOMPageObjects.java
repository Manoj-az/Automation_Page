package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HandleShadowDOMPageObjects {
    WebDriver driver;

    public HandleShadowDOMPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#shadow_host")
    private WebElement shadowHost;

    @FindBy(css = "#HTML16")
    private WebElement widgetHTML;

    public String getShadowContentText() {
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement content = shadowRoot.findElement(By.cssSelector("#shadow_content"));
        return content.getText();
    }

    public String getNestedShadowContentText() {
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement nestedHost = shadowRoot.findElement(By.cssSelector("#nested_shadow_host"));
        SearchContext nestedRoot = nestedHost.getShadowRoot();
        WebElement nestedContent = nestedRoot.findElement(By.cssSelector("#nested_shadow_content"));
        return nestedContent.getText();
    }

    public void clickBlogLink() {
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement blogLink = shadowRoot.findElement(By.cssSelector("a[href=\"https://www.pavantestingtools.com/\"]"));
        blogLink.click();
    }

    public void enterTextInInput(String text) {
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement input = shadowRoot.findElement(By.cssSelector("input[type='text']"));
        input.sendKeys(text);
    }

    public String getEnteredText() {
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement input = shadowRoot.findElement(By.cssSelector("input[type='text']"));
        return input.getAttribute("value");
    }

    public void toggleCheckboxIfNotSelected() {
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement checkbox = shadowRoot.findElement(By.cssSelector("input[type='checkbox']"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void uploadFile(String path) {
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement fileInput = shadowRoot.findElement(By.cssSelector("input[type='file']"));
        fileInput.sendKeys(path);
    }

    public void clickYouTubeLink() {
        SearchContext widgetRoot = widgetHTML.getShadowRoot();
        WebElement ytLink = widgetRoot.findElement(By.cssSelector("a[href=\"https://www.youtube.com/@sdetpavan/videos/\"]"));
        ytLink.click();
    }
}
