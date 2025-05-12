package BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base
{	
		public static WebDriver driver;
		@BeforeClass
		public void setUpUpload()
		{
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https://testautomationpractice.blogspot.com/");
			driver.manage().deleteAllCookies();
		}
		
		@AfterClass
		public void tearDown() {
		    if (driver != null) {
		        driver.quit();
		    }
		}
}


