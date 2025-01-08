package BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base
{	
		public static WebDriver driver;
		@BeforeClass
		public void setUpUpload()
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			driver.get("https://testautomationpractice.blogspot.com/");
			driver.manage().deleteAllCookies();
		}
		
		@AfterClass
		public void tearDown()
		{
			driver.close();
		}
	
		public static void main(String args[]) throws Exception
		{
			Base bc=new Base();
			bc.setUpUpload();
			bc.tearDown();
			
		}

	}


