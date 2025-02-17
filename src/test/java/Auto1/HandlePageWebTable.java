package Auto1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseClass.Base;

public class HandlePageWebTable extends Base 
{

	@Test(priority=0)
	public void pageTable()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//div[@id='HTML8']")));
				
		
		int rows=driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
		int cols=driver.findElements(By.xpath("//table[@id='productTable']//tr//th")).size();
		System.out.println("No.of Rows:"+rows);
		System.out.println("No.of columns:"+cols);
		
		for(int j=1;j<cols;j++)
		{
			String value=driver.findElement(By.xpath("//table[@id='productTable']//tr[1]//th["+j+"]")).getText();
			System.out.print(value);
		}
		System.out.println("");
		for(int r=1;r<=rows;r++)
		{
			for(int c=1;c<=cols;c++)
			{
			   String value=driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]//td["+c+"]")).getText();
			   System.out.print(value);
			}
			System.out.println();
		}

	}	

		@Test(priority=1)
		public void pageTable1()
		{
			
			List<WebElement> lists=driver.findElements(By.xpath("//ul[@id='pagination']//li"));
			for(int i=1;i<=lists.size();i++)
			{
				WebElement wt=driver.findElement(By.xpath("//ul[@id='pagination']//li["+i+"]"));
				String s=wt.getText();
				int nPages=Integer.parseInt(s);
				System.out.println("Page Number :"+nPages);
				if(nPages>1)
				{
					wt.click();
				}
				int rows=driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
				for(int j=1;j<=rows;j++)
				{
					WebElement rowsdata=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+j+"]//td[2]"));
					System.out.println(rowsdata.getText());
					List<WebElement> chkbox=driver.findElements(By.xpath("//table[@id='productTable']//input[@type='checkbox']"));
					for(int k=0;k<chkbox.size();k++)
					{
					  if(!chkbox.get(k).isSelected())
					   {
						chkbox.get(k).click();
						System.out.println("Checkbox clicked");
					   }
					}
				}
				
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
