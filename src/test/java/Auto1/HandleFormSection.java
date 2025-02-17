package Auto1;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.Base;

public class HandleFormSection extends Base
{
	
	private String generateRandomText()
	{
		String characters="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		Random random=new Random();
		StringBuilder sb=new StringBuilder();
		
		//generate random text
		for (int i=1;i<=7;i++)
		{
			int index=random.nextInt(characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
	
	@Test(dataProvider="dynamicText")
	public void dynamicText(String randomData)
	{
		WebElement section1=driver.findElement(By.id("input1"));
		section1.sendKeys(randomData);
		System.out.println("Entered text1: "+randomData);
		WebElement submit1=driver.findElement(By.id("btn1"));
		submit1.click();
		
		WebElement section2=driver.findElement(By.id("input2"));
		section2.sendKeys(randomData);
		System.out.println("Entered text2: "+randomData);
		WebElement submit2=driver.findElement(By.id("btn2"));
		submit2.click();
		
		WebElement section3=driver.findElement(By.id("input3"));
		section3.sendKeys(randomData);
		System.out.println("Entered text3: "+randomData);
		WebElement submit3=driver.findElement(By.id("btn3"));
		submit3.click();
	}
	
	
	@DataProvider(name="dynamicText")
	public Object[][] getDynamicData()
	{
		return new Object[][] {{generateRandomText()},{generateRandomText()}};
	}
	
	
	

}
