package Auto1;

import java.time.Duration;
import java.util.Scanner;
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
	int rows;
	int columns;
	
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
	public void handleStaticWebTable()
	{
		WebElement title=driver.findElement(By.xpath("//h2[normalize-space()='Static Web Table']"));
		System.out.println("Tile of Element: "+title.getText());
		
		rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Count of Rows :"+rows);
		
		columns=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("Count of Columns"+columns);
		
		//Get Table Headings
		for(int h=1;h<=columns;h++)
		{
			String heading=driver.findElement(By.xpath("//table[@name='BookTable']//tr[1]//th["+h+"]")).getText();
			System.out.print(heading+" ");
		}
		System.out.println(" ");
		
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
	}
	
	//Total amount of price from BookTable
	@Test(priority=2)
	public void totalPriceofBooks()
	{
		int total=0;
	
		for(int i=2;i<=rows;i++)
		{
			String s=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[4]")).getText();
			total=total+Integer.parseInt(s);
		}
		System.out.println("Total prices of all books: "+total);
	}
	
	
	//Validate author and price of subject
	@Test(priority=3)
	public void authorAndPrice()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter subject name: ");
		String mainSubject=sc.nextLine();
		boolean flag=false;
		
		try 
		{
		  for(int i=2;i<=rows;i++)
		  {
			String subject=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[3]")).getText();
			if (subject.equalsIgnoreCase(mainSubject))
			{
				flag=true;
				String author=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[2]")).getText();
				System.out.println("Author: "+author);
				
				String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[4]")).getText();
				System.out.println("Price: "+price);
				
				String bookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[1]")).getText();
				System.out.println("Name of a Book: "+bookName);	
			}
		  }
			if(!flag)
			{
				System.out.println("Enter valid subject name");
		    }
		}
		catch(Exception e)
		{
			System.out.println("Error occured: "+e.getMessage());
		}
		finally
		{
			sc.close();
		}
     }
		
	@AfterClass	
	public void tearDown()
	{
		if(driver!=null)
		{
		driver.quit();
		}
	}

}
