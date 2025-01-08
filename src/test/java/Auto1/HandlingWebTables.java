package Auto1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class HandlingWebTables
{
	WebDriver driver;
	@BeforeClass
	public void setUpUpload()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().deleteAllCookies();
	}

	
	@Test(priority=1)
	public void handleStaticWebTable()
	{
		WebElement title=driver.findElement(By.xpath("//h2[normalize-space()='Static Web Table']"));
		System.out.println(title.getText());
		
		int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Count of Rows :"+rows);
		
		int columns=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("Count of Columns"+columns);
		
		
		
		
		//Get Table Headings
		for(int h=1;h<=columns;h++)
		{
			String heading=driver.findElement(By.xpath("//table[@name='BookTable']//tr[1]//th["+h+"]")).getText();
			System.out.print(heading+" ");
		}
		
		
		
		//Read data from table
		for(int r=2;r<=rows;r++)
		{
			for(int c=1;c<=columns;c++)
			{
				String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+ r +"]//td["+ c +"]")).getText();
				System.out.print(value+" ");
			}
			System.out.println();
		}	
		//driver.close();
	}
	
	
	//Total amount of price from BookTable
	@Test(priority=2)
	public void totalPriceofBooks()
	{
		int total=0;
		
		int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		//System.out.println("Count of rows"+rows);
		
		for(int i=2;i<=rows;i++)
		{
			String s=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[4]")).getText();
			total=total+Integer.parseInt(s);
		}
		System.out.println(total);
	}
	
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

	

	public static void main(String[] args) 
	{
		
		HandlingWebTables sw=new HandlingWebTables();
		sw.handleStaticWebTable();

	}

}
