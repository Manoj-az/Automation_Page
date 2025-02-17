package Auto1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseClass.Base;

public class HandlingAlerts extends Base {
	

	@Test(priority=0)
	public void simpleAlert() throws InterruptedException
	{
		try
		{
			WebElement simple=driver.findElement(By.id("alertBtn"));
				if(simple.isEnabled())
				{
					simple.click();
					Thread.sleep(2000);
					driver.switchTo().alert().accept();
				}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
}

	
	@Test(priority=1)
	public void conformationAlert() throws InterruptedException
	{
		//ACCEPT
		WebElement conformation=driver.findElement(By.id("confirmBtn"));
		if(conformation.isEnabled())
		{
			conformation.click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			WebElement accepttext=driver.findElement(By.id("demo"));
			System.out.println("conformation accept text: "+accepttext.getText());
		}
		
		//Dismiss
		if(conformation.isEnabled())
		{
			conformation.click();
			Thread.sleep(2000);
			driver.switchTo().alert().dismiss();
			WebElement dismisstext=driver.findElement(By.id("demo"));
			System.out.println("conformation dismiss text: "+dismisstext.getText());
		}
	}

	@Test(priority=2)
	public void promptAlert() throws InterruptedException
	{
		WebElement prompt=driver.findElement(By.id("promptBtn"));
		try {
		if(prompt.isEnabled())
		{
			prompt.click();
			Thread.sleep(2000);
			Alert alert=driver.switchTo().alert();
			alert.sendKeys("John");
			alert.accept();
			WebElement promptaccepttext=driver.findElement(By.id("demo"));
			System.out.println("prompt accept text: "+promptaccepttext.getText());	
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		try {
		if(prompt.isEnabled())
		{
			prompt.click();
			Thread.sleep(2000);
			Alert alert=driver.switchTo().alert();
			alert.sendKeys("John");
			alert.dismiss();
			WebElement promptdismisstext=driver.findElement(By.id("demo"));
			System.out.println("prompt dismiss text: "+promptdismisstext.getText());
		}	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}	
	}	
}
