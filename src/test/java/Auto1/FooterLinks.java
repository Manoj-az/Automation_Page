package Auto1;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BaseClass.Base;

public class FooterLinks extends Base
{


	@Test(priority=0)
	public void handleHome()
	{
		WebElement home=driver.findElement(By.xpath("//a[@href=\"http://testautomationpractice.blogspot.com/\"]"));
		if(home.isEnabled())
		{
			home.click();
			System.out.println("Home link clicked");
		}
	}
	
	
	@Test(priority=1)
	public void handleHiddenandAjaxElements() throws InterruptedException
	{
		WebElement handleHidden=driver.findElement(By.xpath("//a[@href=\"https://testautomationpractice.blogspot.com/p/gui-elements-ajax-hidden.html\"]"));
		if(handleHidden.isEnabled())
		{
			handleHidden.click();
			System.out.println("Hidden Element clicked");
		}
		
		WebElement input1=driver.findElement(By.id("input1"));
		input1.sendKeys("Hello dear");
		
		WebElement toggleInputBox2=driver.findElement(By.id("toggleInput"));
		toggleInputBox2.click();
		
		WebElement input2=driver.findElement(By.id("input2"));
		input2.sendKeys("Hello Max");
		
		WebElement checkbox1=driver.findElement(By.id("checkbox1"));
		checkbox1.click();
		
		WebElement toggleCheckBox=driver.findElement(By.id("toggleCheckbox"));
		toggleCheckBox.click();
		
		WebElement checkbox2=driver.findElement(By.id("checkbox2"));
		checkbox2.click();
		
		WebElement ajaxLoadContent=driver.findElement(By.id("loadContent"));
		ajaxLoadContent.click();
		Thread.sleep(3000);
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.presenceOfElementLocated(By.id("loadContent")));
		mywait.until(ExpectedConditions.elementToBeClickable(By.id("loadContent")));
		
		WebElement status=driver.findElement(By.id("statusLabel"));
		System.out.println("status :"+status.getText());
		
		WebElement ajaxContent=driver.findElement(By.id("ajaxContent"));
		System.out.println("ajax Content:"+ajaxContent.getText());
		
		
		WebElement subscribeTo=driver.findElement(By.xpath("//a[@class='feed-link']"));
		String parentWindow=driver.getWindowHandle();
		System.out.println(parentWindow);
		
		if(subscribeTo.isEnabled())
		{
			subscribeTo.click();
			System.out.println("subscribeTo clicked");
			Set<String> allWindows=driver.getWindowHandles();
			System.out.println("Get all windows: "+allWindows);
			
			for(String windowHandle:allWindows)
			{
				System.out.println(windowHandle);
				if(!parentWindow.equals(windowHandle))
				{
					driver.switchTo().window(windowHandle);
					System.out.println("In Child Window");
					driver.close();
				}
			}
			driver.switchTo().window(parentWindow);
			System.out.println("In parent Window");
		
		}
		
		WebElement homeElement=driver.findElement(By.xpath("//a[@class='home-link']"));
		homeElement.click();
		
	}


	
	@Test(priority=2)
	public void downloadFiles() throws InterruptedException
	{
		   WebElement file=driver.findElement(By.xpath("//a[normalize-space()='Download Files']"));
		   file.click();
		   
		   WebElement text=driver.findElement(By.id("inputText"));
		   text.sendKeys("Welcome to this world!");
		   
		   WebElement btn=driver.findElement(By.id("generateTxt"));
		   btn.click();
		   
		   WebElement downloadLink=driver.findElement(By.id("txtDownloadLink"));
		   downloadLink.click();
		   
		   
		   String downloadFilePath = System.getProperty("user.home") + "\\Downloads";
		    System.out.println("Download Directory: " + downloadFilePath);

		    @SuppressWarnings("deprecation")
			String fileName = downloadLink.getAttribute("download");
		    System.out.println("File Name: " + fileName);

		    File txtFile = new File(downloadFilePath + "\\" + fileName);

		    if (txtFile.exists()) 
		    {
		        System.out.println("File downloaded successfully!");
		    } else
		    {
		        System.out.println("File not found!");
		    }
		   
		    
		    WebElement btnPdf=driver.findElement(By.id("generatePdf"));
		    btnPdf.click();
			   
			WebElement downloadPdfLink=driver.findElement(By.id("pdfDownloadLink"));
			downloadPdfLink.click();
			
			
			 String downloadPdfPath = System.getProperty("user.home") + "\\Downloads";
			    System.out.println("Download Directory: " + downloadPdfPath);

			    @SuppressWarnings("deprecation")
				String pdfName = downloadPdfLink.getAttribute("download");
			    System.out.println("File Name: " + pdfName);

			    File pdfFile = new File(downloadFilePath + "\\" + fileName);

			    if (pdfFile.exists()) 
			    {
			        System.out.println("PDF File downloaded successfully!");
			    } else
			    {
			        System.out.println("PDF File not found!");
			    }
		   

			    WebElement homeElement=driver.findElement(By.xpath("//a[@class='home-link']"));
				homeElement.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
