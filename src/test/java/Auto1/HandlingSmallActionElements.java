package Auto1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.Base;

public class HandlingSmallActionElements extends Base
{
	@Test(priority=0)
	public void handleMouserHover() throws InterruptedException
	{
		WebElement mouse=driver.findElement(By.xpath("//button[normalize-space()='Point Me']"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", mouse);
		mouse.click();
		Thread.sleep(3000);
		
		List<WebElement> mouseHover=driver.findElements(By.xpath("//div[@class='dropdown-content']//a"));
		Actions act=new Actions(driver);
		for (WebElement link : mouseHover) {
	        try 
	        	{
	                act.moveToElement(mouse).moveToElement(link).perform();
	                Thread.sleep(2000); 
	                System.out.println(link.getText()+" Clicked");
	                link.click(); 
	        	} 
	        	catch (Exception e) 
	        	{
	            System.out.println("Error interacting with link: " + e.getMessage());
	        	}
			}
		
       }
	
	
	@Test(priority=1)
	public void handleDoubleClick() throws InterruptedException
	{
		try {
		WebElement doubleClick=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		Actions act=new Actions(driver);
		act.doubleClick(doubleClick);
		Thread.sleep(2000);
		WebElement txt=driver.findElement(By.xpath("//input[@id='field2']"));
		@SuppressWarnings("deprecation")
		String value=txt.getAttribute("value");
		if(value.equals("Hello World!"))
		//using this value the text will failed because in input box Hello World! is not a text only it's value of attribute so it fails.
	    //see depends on method handleDC in that using sendKeys we get required output as same.
		{
		System.out.println("Double Clicked: "+value);
		System.out.println("Text Equals");
		}
		else
		{
			System.out.println("Text Not Equals");
		}
		}
		catch(Exception e)
		{
			System.out.println("Error Occured: "+e.getMessage());
		}

	}
	
	@Test(dependsOnMethods= {"handleDoubleClick"})
	public void handleDC() throws InterruptedException
	{
		WebElement dc=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		Actions act=new Actions(driver);
		act.doubleClick(dc);
		Thread.sleep(2000);
		WebElement txt=driver.findElement(By.xpath("//input[@id='field1']"));
		txt.clear();
		txt.sendKeys("Hey John");
		@SuppressWarnings("deprecation")
		String value=txt.getAttribute("value");
		if(value.equals("Hey John"))
		{
			System.out.println("input text1: "+value);
			System.out.println("Text Equals");
		}
		else
		{
			System.out.println("Text Not Equals");
		}	
	}
	
	@Test(priority=3)
	public void dragAndDrop() throws InterruptedException
	{
		try {
		WebElement drag=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		Actions act=new Actions(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",drop);
		act.dragAndDrop(drag, drop).perform();
		Thread.sleep(3000);
		WebElement dropable=driver.findElement(By.xpath("//div[@id='droppable']//p"));
		String dropablemsg=dropable.getText();
		if(dropablemsg.equals("Dropped!"))
		{
		System.out.println("Dropped: "+dropablemsg);
		}
		else
		{
		System.out.println("Drop here: "+dropablemsg);	
		}
		}
		catch(Exception e)
		{
			System.out.println("Error Occured: "+e.getMessage());
		}
	}
	
	
	
	@Test(priority=4)
	public void handleSliders() throws InterruptedException, IOException
	{
		WebElement slider=driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default'][1]"));
		WebElement nameOfSlider=driver.findElement(By.xpath("//h2[normalize-space()='Slider']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",nameOfSlider);
		int xLocation=slider.getLocation().getX();
		System.out.println("Intial X-Location value of Slider: "+xLocation);
		
		Actions act=new Actions(driver);
		act.dragAndDropBy(slider,-100,0).perform();
		
		//Taking Screenshot, we use to take some portion of web application
		WebElement forScreenshotPortion=driver.findElement(By.xpath("//div[@id='HTML7']"));
		File source=forScreenshotPortion.getScreenshotAs(OutputType.FILE);
		File target=new File("E:/AutomationPraticePage/Screenshots/SliderX.png");
		FileUtils.copyFile(source, target);
		
		Thread.sleep(2000); //For showing the slider Element we use thread.
		int xLocationAfterSlider=slider.getLocation().getX();
		System.out.println("After X-Location value of Slider: "+xLocationAfterSlider);
			if(xLocationAfterSlider!=xLocation)
			{
			System.out.println("The slider was moved: "+xLocationAfterSlider);
			}
			else
			{
			System.out.println("The slider was not moved: "+xLocationAfterSlider);
			}
		
		WebElement sliderY=driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		js.executeScript("arguments[0].scrollIntoView(true);",nameOfSlider);
		int yLocation=sliderY.getLocation().getY();
		System.out.println("Intial Y-Location value of Slider: "+yLocation);
		act.dragAndDropBy(sliderY,50,0).perform();
		File targetY=new File("E:/AutomationPraticePage/Screenshots/SliderX.png");
		FileUtils.copyFile(source, targetY);
		Thread.sleep(2000); //For showing the slider Element we use thread.
		int yLocationAfterSlider=sliderY.getLocation().getX();
		System.out.println("After Y-Location value of Slider: "+yLocationAfterSlider);
			if(yLocationAfterSlider!=yLocation)
			{
			System.out.println("The slider was moved: "+yLocationAfterSlider);
			}
			else
			{
			System.out.println("The slider was not moved: "+yLocationAfterSlider);
			}

	}

	
	@SuppressWarnings("deprecation")
	@Test(priority=5)
	public void handleSVG()
	{
		
		//Getting circle Attributes
		System.out.println("-------------------------Circle attributes----------------------------");
		WebElement svg=driver.findElement(By.xpath("//*[local-name()='svg']//*[local-name()='circle']"));
		
		String svgColor=svg.getAttribute("fill");
		String svgcx=svg.getAttribute("cx");
		String svgcy=svg.getAttribute("cy");
		String svgStroke=svg.getAttribute("stroke");
		System.out.println(svgColor+" "+"cx:"+svgcx+" "+"cy:"+svgcy+" "+"Stroke:"+svgStroke);
		Assert.assertEquals("red",svgColor);
		Assert.assertEquals("15",svgcx);
		Assert.assertEquals("15",svgcy);
		Assert.assertEquals("black",svgStroke);
	
		
		//Getting Rectangle(rect) attributes
		System.out.println("-------------------------rectangle attributes----------------------------");
		WebElement svgRect=driver.findElement(By.xpath("//*[local-name()='svg'][2]/*[local-name()='rect'][1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		@SuppressWarnings("unchecked")
		Map<String, String> attributes = (Map<String, String>) 
		js.executeScript(
		    "var items = {}; " +
		    "for (var i = 0; i < arguments[0].attributes.length; i++) { " +
		    "items[arguments[0].attributes[i].name] = arguments[0].attributes[i].value; " +
		    "} " +
		    "return items;", 
		    svgRect
		);
		// Print all attributes and their values
		for (Map.Entry<String, String> entry : attributes.entrySet()) 
		{
		    System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		
		
		for (Map.Entry<String, String> entry : attributes.entrySet()) 
		{
		    String key = entry.getKey();
		    String value = entry.getValue();
		    
		    // Assertions for specific key-value pairs
		    switch (key) {
		        case "fill":
		            Assert.assertEquals(value, "green", "Value for 'fill' is incorrect");
		            break;
		        case "height":
		            Assert.assertEquals(value, "15", "Value for 'height' is incorrect");
		            break;
		        case "stroke":
		            Assert.assertEquals(value, "black", "Value for 'stroke' is incorrect");
		            break;
		        case "stroke-width":
		            Assert.assertEquals(value, "2", "Value for 'stroke-width' is incorrect");
		            break;
		        case "width":
		            Assert.assertEquals(value, "24", "Value for 'width' is incorrect");
		            break;
		        case "x":
		            Assert.assertEquals(value, "3", "Value for 'x' is incorrect");
		            break;
		        case "y":
		            Assert.assertEquals(value, "5", "Value for 'y' is incorrect");
		            break;
		        default:
		            Assert.fail("Unexpected key: " + key);
		    }
		    
		    System.out.println(key + " = " + value); 
		}


		//Getting polygon attributes
		System.out.println("-------------------------Polygon attributes----------------------------");
		WebElement svgPoly=driver.findElement(By.xpath("//*[local-name()='svg']/*[local-name()='polygon']"));
		@SuppressWarnings("unchecked")
		Map<String, String> att = (Map<String, String>) 
		js.executeScript(
		    "var items = {}; " +
		    "for (var i = 0; i < arguments[0].attributes.length; i++) { " +
		    "items[arguments[0].attributes[i].name] = arguments[0].attributes[i].value; " +
		    "} " +
		    "return items;", 
		    svgPoly
		);
		// Print all attributes and their values
		for (Map.Entry<String, String> entry : att.entrySet()) 
		{
		    System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		
		for(Map.Entry<String, String> entry:att.entrySet())
		{
			String key = entry.getKey();
		    String value = entry.getValue();
		    
		    // Assertions for specific key-value pairs
		    switch (key) {
		        case "fill":
		            Assert.assertEquals(value, "blue", "Value for 'fill' is incorrect");
		            break;
		        case "points":
		            Assert.assertEquals(value, "15,3 3,27 27,27", "Value for 'points' is incorrect");
		            break;
		        case "stroke":
		            Assert.assertEquals(value, "black", "Value for 'stroke' is incorrect");
		            break;
		        case "stroke-width":
		            Assert.assertEquals(value, "1", "Value for 'stroke-width' is incorrect");
		            break;
		        default:
		            Assert.fail("Unexpected key: " + key);
		    }
		    
		    System.out.println(key + " = " + value); // Optional for debugging
		}
		
	}
		
	
	
	@Test(priority=6)
		public void handleScrollingElement()
		{
		
		WebElement handleScroll=driver.findElement(By.xpath("//input[@id='comboBox']"));
		if(handleScroll.isEnabled())
		{
			handleScroll.click();
			List<WebElement> dropDowns=driver.findElements(By.xpath("//div[@class='option']"));
			System.out.println(dropDowns.size());
			for(WebElement drops:dropDowns)
			{
				System.out.println(drops.getText());
			}
			WebElement item=driver.findElement(By.xpath("//div[normalize-space()='Item 37']"));
			if(item.isEnabled())
			{
			item.click();
			@SuppressWarnings("deprecation")
			String itemNumber=item.getAttribute("innerText");
			System.out.println("Item "+itemNumber+" clicked");
			}
		}
		
			
		}
		
			
		}

	
	
	
	
	
	
	
	
	

