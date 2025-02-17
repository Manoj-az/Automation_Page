package Auto1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BaseClass.Base;

public class HandleShawdowDOM extends Base
{
	
	//For Handling Shadow DOM we use CSS Selector because X-Path not work in Shadow DOM.
	
	@SuppressWarnings("deprecation")
	@Test
	public void handleShadowDomElements() 
	{  
	    WebElement shadowHost = driver.findElement(By.cssSelector("#shadow_host"));
	    
	    SearchContext shadowRoot=shadowHost.getShadowRoot();
	    
	    WebElement shadow_content=shadowRoot.findElement(By.cssSelector("#shadow_content"));
	    String shadowContentText=shadow_content.getText();
	    System.out.println("Shadow Content Text: "+shadowContentText);
	    
	    WebElement nested_shadow_host=shadowRoot.findElement(By.cssSelector("#nested_shadow_host"));
	    
	    SearchContext nestedShadowRoot=nested_shadow_host.getShadowRoot();
	    
	    WebElement nested_shadow_content=nestedShadowRoot.findElement(By.cssSelector("#nested_shadow_content"));
	    String nestedShadowtext=nested_shadow_content.getText();
	    System.out.println("Nested Shadow Text: "+nestedShadowtext);
	    
	    // Access blog link within the nested shadow DOM
	    SearchContext blogContext = shadowHost.getShadowRoot();
	    WebElement blogLink = blogContext.findElement(By.cssSelector("a[href=\"https://www.pavantestingtools.com/\"]"));
	    String blogLinkText = blogLink.getAttribute("innerText");
	    System.out.println("Blog Link Text: " + blogLinkText);
	    try {
	    blogLink.click();
	    driver.navigate().back();
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Error Occured: "+e.getMessage());
	    }
	    
	   //Access Input text
	     SearchContext shadowRoot1 = shadowHost.getShadowRoot();
	     WebElement inputField = shadowRoot1.findElement(By.cssSelector("input[type='text']"));
	     inputField.sendKeys("Hello");
	     String enteredText = inputField.getAttribute("value");
	     System.out.println("Entered Text: " + enteredText);
	        
	   //Access Input CheckBox
	     SearchContext chkbox = shadowHost.getShadowRoot();
	     WebElement checkBox = chkbox.findElement(By.cssSelector("input[type='checkbox']"));
	     if (checkBox.isDisplayed() && !checkBox.isSelected()) {
	    	    checkBox.click();
	    	    System.out.println("CheckBox clicked");
	    	} else {
	    	    System.out.println("CheckBox already selected or not visible");
	    	}

	        
	   //Access Input File
	     SearchContext fileHandle = shadowHost.getShadowRoot();
	     WebElement inputFile = fileHandle.findElement(By.cssSelector("input[type='file']"));
	     String filePath = "C:\\Users\\manoj\\Downloads\\info.txt";
	     inputFile.sendKeys(filePath);
	     System.out.println("File Uploaded success");
	        
	     
	     
	        
	  WebElement widgetHTML=driver.findElement(By.cssSelector("#HTML16"));
	  
	  //WebElement host = widgetContent.findElement(By.cssSelector("#non_host"));
	
	   SearchContext widget=widgetHTML.getShadowRoot();
	   try {
	   WebElement utube = widget.findElement(By.cssSelector("a[href=\"https://www.youtube.com/@sdetpavan/videos/\"]"));
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
	        wait.until(ExpectedConditions.elementToBeClickable(utube));
		   utube.click();
		   driver.navigate().back();
	      }
	   catch(Exception e)
	   {
		   System.out.println("Error Occured: "+e.getMessage());
	   }
	   
	

	    
	    
}
	

	}
	
	


		
	


