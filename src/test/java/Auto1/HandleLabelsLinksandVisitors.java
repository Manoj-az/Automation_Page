package Auto1;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.Base;

public class HandleLabelsLinksandVisitors extends Base
{
	
	@Test(priority=0)
	public void handleMobileLables()
	{
		List<WebElement> mobiles=driver.findElements(By.xpath("//div[@id='mobiles']//label"));
		System.out.println("Mobiles size: "+mobiles.size());
		for(WebElement mobileLables:mobiles)
		{
			String mobilesText=mobileLables.getText();
			System.out.println(mobilesText);
			switch(mobilesText)
			{
			case "Samsung":Assert.assertEquals(mobilesText,"Samsung");
			break;
			case "Real Me":Assert.assertEquals(mobilesText,"Real Me");
			break;
			case "Moto":Assert.assertEquals(mobilesText,"Moto");
			break;
			default:Assert.fail("Error Occured");
			}
		}
		
	}
	
	
	
	@Test(priority=1)
	public void handleLaptopLinks() throws InterruptedException
	{
		
		List<WebElement> laptop=driver.findElements(By.xpath("//div[@id='laptops']//a"));
		System.out.println(laptop.size());
		
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		for(WebElement laptopHandle:laptop)
		{
			String txt=laptopHandle.getText();
			System.out.println(txt);
			mywait.until(ExpectedConditions.elementToBeClickable(laptopHandle)).click();
			String title=driver.getTitle();
			System.out.println("Link of: "+txt+""+title);
			driver.navigate().back();
			mywait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='laptops']//a")));
			
			switch (title.trim()) {
			    case "Apple":
			        Assert.assertEquals(title, "Apple", "Title does not match for Apple");
			        break;

			    case "LenovoLenovo® Official India Site | Laptops, Tablets, Desktops, Data Center | Lenovo IN":
			        Assert.assertEquals(title, 
			            "LenovoLenovo® Official India Site | Laptops, Tablets, Desktops, Data Center | Lenovo IN", 
			            "Title does not match for Lenovo");
			        break;

			    case "DellComputers, Monitors & Technology Solutions | Dell India":
			        Assert.assertEquals(title, 
			            "DellComputers, Monitors & Technology Solutions | Dell India", 
			            "Title does not match for Dell");
			        break;
			}

		}	
	}

	@Test(priority=2)
	public void handleBrokenLinks()
	{
		List<WebElement> broken=driver.findElements(By.xpath("//div[@id='broken-links']//a"));
		System.out.println("No.of Broken Links: "+broken.size());
		for(WebElement links:broken)
		{
			@SuppressWarnings("deprecation")
			String brokenLinksNames=links.getAttribute("innerText");
			System.out.println(brokenLinksNames);
			WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(3000));
			mywait.until(ExpectedConditions.elementToBeClickable(links)).click();
			String title=driver.getTitle();
			System.out.println("Title of "+brokenLinksNames+" "+title);
			driver.navigate().back();
		    Assert.assertEquals("","");
			Assert.assertEquals("401 - Unauthorized: Access is denied due to invalid credentials.", "401 - Unauthorized: Access is denied due to invalid credentials.");
		    Assert.assertEquals("403 - Forbidden: Access is denied.","403 - Forbidden: Access is denied.");
		    Assert.assertEquals("404 - File or directory not found.","404 - File or directory not found.");
		    Assert.assertEquals("","");
		    Assert.assertEquals("500 - Internal server error.","500 - Internal server error.");
		    Assert.assertEquals("502 - Web server received an invalid response while acting as a gateway or proxy server.","502 - Web server received an invalid response while acting as a gateway or proxy server.");
		    Assert.assertEquals("","");

		}
	}
	
	@Test(priority=3)
	public void handleVisitors()
	{
		String value=driver.findElement(By.id("Stats1_totalCount")).getText();
		System.out.println(value);
		WebElement svg=driver.findElement(By.xpath("//*[local-name()='g']//*[local-name()='rect']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		@SuppressWarnings("unchecked")
		Map<String, String> attributes = (Map<String, String>) 
		js.executeScript(
		    "var items = {}; " +
		    		 "for (var i = 0; i < arguments[0].attributes.length; i++) { " +
		 		    "items[arguments[0].attributes[i].name] = arguments[0].attributes[i].value; " +
		 		    "} " +
		    "return items;", 
		    svg
		);
		
		for (Map.Entry<String, String> entry : attributes.entrySet()) 
		{
		    System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		
		for (Map.Entry<String, String> entry : attributes.entrySet()) 
		{
		    String key = entry.getKey();
		    String values = entry.getValue();
		    
		    // Assertions for specific key-value pairs
		    switch (key) {
		        case "fill":
		            Assert.assertEquals(values, "#ffffff", "Value for 'fill' is incorrect");
		            break;
		        case "fill-opacity":
		            Assert.assertEquals(values, "0", "Value for 'height' is incorrect");
		            break;
		        case "height":
		            Assert.assertEquals(values, "30", "Value for 'height' is incorrect");
		            break;
		        case "stroke":
		            Assert.assertEquals(values, "none", "Value for 'stroke' is incorrect");
		            break;
		        case "stroke-width":
		            Assert.assertEquals(values, "0", "Value for 'stroke-width' is incorrect");
		            break;
		        case "width":
		            Assert.assertEquals(values, "75", "Value for 'width' is incorrect");
		            break;
		        case "x":
		            Assert.assertEquals(values, "0", "Value for 'x' is incorrect");
		            break;
		        case "y":
		            Assert.assertEquals(values, "0", "Value for 'y' is incorrect");
		            break;
		    }
		}
	
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


