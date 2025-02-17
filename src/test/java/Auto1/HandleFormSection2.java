package Auto1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFormSection2 
{
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.manage().deleteAllCookies();
	}
	
	
	private int generateRandomNumber()
	{
		int number=793;
		Random rand=new Random();
		int rand_int=rand.nextInt(100);
		int result=number+rand_int;
		System.out.println(result);
		return result;
	}
	
	@Test(dataProvider="dynamicText")
	public void getDymanicData(int data)
	{
		WebElement section=driver.findElement(By.id("input2"));
		//sendKeys() expects a String type as input, not an integer or any other data type.
		section.sendKeys(String.valueOf(data));
		System.out.println("Entered text: "+data);
		WebElement submit2=driver.findElement(By.id("btn2"));
		submit2.click();
	}
	
	@DataProvider(name="dynamicText")
	public Object[][] getRandom()
	{
		return new Object[][] {{generateRandomNumber()}};
	}
	
	@AfterClass
	public void tearDown() {
		if(driver!=null)
		{
			driver.quit();
		}
	}

}
