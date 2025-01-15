package Auto1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BaseClass.Base;

public class HandlingNewTabandPopup extends Base {
	
	@Test(priority=0)
	public void handleNewTab()
	{
		String parentWindow=driver.getWindowHandle();
		System.out.println(parentWindow);
	WebElement newTab=driver.findElement(By.xpath("//button[normalize-space()='New Tab']"));
	if(newTab.isEnabled())
		{
		  newTab.click();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		  Set<String> allWindows=driver.getWindowHandles();
		  for(String win:allWindows)
		  {
			  System.out.println(win);
			  if(!win.equals(parentWindow))
			  {
				  driver.switchTo().window(win);
				  System.out.println("Title of NewTab window: "+driver.getTitle());
				  driver.close();
				  System.out.println("Driver Closed");
				  driver.switchTo().window(parentWindow);
			  }
		   }
		}
	}
	
	@Test(priority=1)
	public void popUp()
	{
		String parentWindow=driver.getWindowHandle();
		System.out.println(parentWindow);
		WebElement pop=driver.findElement(By.id("PopUp"));
		if(pop.isEnabled())
		{
			pop.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.numberOfWindowsToBe(3));
			Set<String> allWindows=driver.getWindowHandles();
			System.out.println(allWindows);
			for(String pops:allWindows)
			{
				if(!pops.equals(parentWindow))
				{
					driver.switchTo().window(pops);
					System.out.println("Popup window Title: "+driver.getTitle());
					driver.close();
					System.out.println("Popup window closed");
					driver.switchTo().window(parentWindow);
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
