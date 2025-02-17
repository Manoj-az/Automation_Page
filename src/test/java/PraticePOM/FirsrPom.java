package PraticePOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirsrPom 
{
	
	WebDriver driver;
	PomForFirst pff;

	
	@Test
	@BeforeClass
	public void setUp()
	{
	driver=new ChromeDriver();
	driver.get("https://the-internet.herokuapp.com/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	driver.manage().deleteAllCookies();
	
	//Intilize pom 
    pff=new PomForFirst(driver);

	}

	@Test
	public void lp()
	{
       pff.userNameMethod("tomsmith");
       pff.pwd("SuperSecretPassword!");
       pff.button();
		
	}
	
	
	@Test
	@AfterClass
	public void tearDown()
	{
			driver.quit();
	}
	

}
