package Auto1;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingUploadFiles {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUpUpload()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().deleteAllCookies();
	}
	
	@Test(priority=1)
	public void getTitleOfFiles()
	{
		WebElement title=driver.findElement(By.xpath("//h2[normalize-space()='Upload Files']"));
		System.out.println(title.getText());
    }
	
	@Test(priority=2)
	public void handleButtonWithoutUploadFile()
	{
		WebElement btn1=driver.findElement(By.xpath("//button[normalize-space()='Upload Single File']"));
		if(btn1.isEnabled())
		{
			btn1.click();
			WebElement statusOfButton1=driver.findElement(By.id("singleFileStatus"));
			System.out.println(statusOfButton1.getText());
			String statusOfSingleButton=statusOfButton1.getText();
			if(statusOfSingleButton.equals("No file selected."))
			{
				System.out.println("please upload a file");
			}
		}
		
		
		WebElement btn2=driver.findElement(By.xpath("//button[normalize-space()='Upload Multiple Files']"));
		if(btn2.isEnabled())
		{
			btn2.click();
			WebElement statusOfButton2=driver.findElement(By.id("multipleFilesStatus"));
			System.out.println(statusOfButton2.getText());
			String statusOfMultipleButtons=statusOfButton2.getText();
			if(statusOfMultipleButtons.equals("No files selected."))
			{
				System.out.println("please upload a Multiple files");
			}
		}
	}
	
	
	@Test(priority=3)
	public void inputHandles()
	{
		WebElement inputbox1=driver.findElement(By.xpath("//input[@id='singleFileInput']"));
	
		String pathLink="E:\\Testing\\Interview QA.pdf";
		if(inputbox1.isDisplayed())
		{
		  inputbox1.sendKeys(pathLink);
		  System.out.println("File Uploaded "+pathLink);
		}
		else
		{
			System.out.println("File Not Uploaded "+pathLink);
		}
		
		WebElement inputbox2=driver.findElement(By.id("multipleFilesInput"));
		
		if(inputbox2.isDisplayed())
		{
			inputbox2.sendKeys("E:\\Testing\\demo.xlsx");
			inputbox2.sendKeys("E:\\Testing\\demo1.xlsx");
			System.out.println("Files are Uploaded "+inputbox2);
		}
		else
		{
			System.out.println("Files are not Uploaded "+inputbox2);
		}
	}
	
	@Test(priority=4)
	public void buttonsHandles()
	{
		WebElement btn1=driver.findElement(By.xpath("//button[normalize-space()='Upload Single File']"));
		if(btn1.isEnabled())
		{
		btn1.click();
		System.out.println("Button Clicked "+btn1.getText());
		try 
		   {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);",btn1);
			TakesScreenshot ss=(TakesScreenshot)driver;
			File source=ss.getScreenshotAs(OutputType.FILE);
			File target=new File("E:/AutomationPraticePage/Screenshots/SingleFile.png");
			FileUtils.copyFile(source,target);
			System.out.println("Screenshot saved in folder :"+target);
		   }
		catch (Exception e) 
		   {
			System.out.println("An error occurred: " + e.getMessage());
		   }
		}
		else
		{
		System.out.println("Button not Clicked "+btn1.getText());
		}
		WebElement btn2=driver.findElement(By.xpath("//button[normalize-space()='Upload Multiple Files']"));
		if(btn2.isEnabled())
		{
			btn2.click();
		    System.out.println("Button Clicked "+btn2.getText());
		    try 
			   {
		    	JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView(true);",btn2);
				
				TakesScreenshot ss=(TakesScreenshot)driver;
				File source=ss.getScreenshotAs(OutputType.FILE);
				File target=new File("E:/AutomationPraticePage/Screenshots/MultipleFiles.png");
				FileUtils.copyFile(source,target);
				System.out.println("Screenshot saved in folder :"+target);
			   }
			catch (Exception e) 
			   {
				System.out.println("An error occurred: " + e.getMessage());
			   }
		}
		else
		{
		    System.out.println("Button not Clicked "+btn2.getText());
		}
	}
	
	@AfterClass
	public void tearDown() {
	    if (driver != null) {
	        driver.quit();
	    }
	}
	
	
	public static void main(String arg[])
	{
		HandlingUploadFiles uf=new HandlingUploadFiles();
		uf.getTitleOfFiles();
		uf.inputHandles();
		uf.buttonsHandles();
		
	}
	
	
	
	
	
	
	
	
}
