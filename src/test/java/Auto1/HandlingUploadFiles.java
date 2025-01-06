package Auto1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
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
	
	
	
	@Test(priority=3)
	public void buttonsHandles()
	{
		WebElement btn1=driver.findElement(By.xpath("//button[normalize-space()='Upload Single File']"));
		if(btn1.isEnabled())
		{
		btn1.click();
		System.out.println("Button Clicked "+btn1.getText());
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
		}
		else
		{
		    System.out.println("Button not Clicked "+btn2.getText());
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
