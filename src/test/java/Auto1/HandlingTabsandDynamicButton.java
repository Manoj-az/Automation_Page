package Auto1;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BaseClass.Base;

public class HandlingTabsandDynamicButton extends Base
{
	
	@Test(priority=0)
	public void handleTab()
		{
			WebElement tab=driver.findElement(By.id("Wikipedia1_wikipedia-search-input"));
			if(tab.isEnabled()==true)
			{
			tab.click();
			tab.sendKeys("google");
			WebElement searchTab=driver.findElement(By.xpath("//input[@class='wikipedia-search-button']"));
				if(searchTab.isEnabled())
				{
				searchTab.click();
				List<WebElement> searchResults=driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']//a"));
				System.out.println(searchResults.size());
					for(int i=0;i<searchResults.size();i++)
					{
						System.out.println(searchResults.get(i).getText());
					}
				}
			}
		}
	
	
	
	@Test(priority = 1)
    public void accessToSearchResults() 
	{
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window Handle: " + parentWindow);

        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']//a"));
        System.out.println("Number of search results: " + searchResults.size());

        for (WebElement result : searchResults) 
        {
            result.click(); 
            Set<String> windowHandles = driver.getWindowHandles();

            for (String handle : windowHandles) 
            {
                if (!handle.equals(parentWindow)) 
                {
                    driver.switchTo().window(handle);
                    System.out.println("Child Window Title: " + driver.getTitle());
                    driver.close(); 
                }
            }
            driver.switchTo().window(parentWindow);   
            
        }     
	}
	
	
	@Test(priority=2)
	public void handlingMore()
	{
		String parentWindow=driver.getWindowHandle();
		System.out.println(parentWindow);
		
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement more=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='Wikipedia1_wikipedia-search-more']//a")));
		//WebElement more=driver.findElement(By.xpath("//div[@id='Wikipedia1_wikipedia-search-more']//a"));
		more.click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> allWindows=driver.getWindowHandles();
		System.out.println("All Windows "+allWindows);
		for(String moreHandle:allWindows)
		{
			if(!moreHandle.equals(parentWindow))
			{
				driver.switchTo().window(moreHandle);
				System.out.println("more Window Title: "+driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);	
		
	}
	
	
	@Test(priority=3)
	public void handleDynamicBtn()
	{
		WebElement btnStart=driver.findElement(By.xpath("//button[@onclick='toggleButton(this)']"));
		if(btnStart.isEnabled())
		{
			btnStart.click();
			try 
			{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);",btnStart);
			File source=btnStart.getScreenshotAs(OutputType.FILE);
			File target=new File("E:/AutomationPraticePage/Screenshots/DynamicButton1.png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot saved in folder :"+target);
			}
			catch(Exception e)
			{
				System.out.println("An error occurred: " + e.getMessage());
			}
		System.out.println("Button Clicked: "+btnStart.getText());
		}
		else
		{
			System.out.println("Button not Clicked");
		}
		WebElement btnStop=driver.findElement(By.xpath("//button[@class='stop']"));
		if(btnStop.isEnabled())
		{
			btnStop.click();
			try {
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView(true)",btnStop);
				File source=btnStop.getScreenshotAs(OutputType.FILE);
				File target=new File("E:/AutomationPraticePage/Screenshots/DynamicButton2.png");
				FileUtils.copyFile(source, target);
				System.out.println("Screenshot saved in folder :"+target);
			}
			catch(Exception e)
			{
				System.out.println("An error occurred: "+e.getMessage());
			}
			System.out.println("Button Clicked: "+btnStop.getText());
		}
		else
		{
			System.out.println("Button not Clicked");	
		}
	
	}
	
	

	public static void main(String args[])
	{
		HandlingTabsandDynamicButton td= new HandlingTabsandDynamicButton();
		td.handleTab();
		td.accessToSearchResults();
		td.handlingMore();
		td.handleDynamicBtn();
	}

}
