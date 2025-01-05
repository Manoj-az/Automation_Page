package Auto1;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class HandlingGUIElements {
	
	
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().deleteAllCookies();
		
		/* Instead using this you can use navigate to(driver.navigate().to()) to get the url 
		 * driver.naviagte().to("https://testautomationpractice.blogspot.com/");
		 */
	}
	@Test(priority=1)
	public void inputNameHandling()
	{
		WebElement title=driver.findElement(By.xpath("//h1[@class='title']"));
		System.out.println(title.getText());
		WebElement name=driver.findElement(By.id("name"));
		if(name.isEnabled()==true)
		{
			name.sendKeys("ABCD");
			System.out.println("Name Entered");
		}
		else
		{
			System.out.println("Unable to enter name");
		}
	
	}
	@Test(priority=2)
	public void inputEmailHandling()
	{
		WebElement email=driver.findElement(By.id("email"));
		if(email.isEnabled()==true)
		{
			email.sendKeys("abcde@gmail.com");
			System.out.println("Email Entered");
		}
		else
		{
			System.out.println("Unable to enter email");
		}
	
	}
	
	@Test(priority=3)
	public void inputPhoneHandling()
	{
		WebElement phone=driver.findElement(By.id("phone"));
		if(phone.isEnabled()==true)
		{
			phone.sendKeys("9999999999");
			System.out.println("phone Entered");
		}
		else
		{
			System.out.println("Unable to enter phone");
		}
	
	}
	@Test(priority=4)
	public void inputTextHandling()
	{
		WebElement textArea=driver.findElement(By.id("textarea"));
		if(textArea.isEnabled()==true)
		{
			textArea.sendKeys("Automation Test Pratice");
			System.out.println("Text Entered");
		}
		else
		{
			System.out.println("Unable to enter Text");
		}
	
	}
	
	
	@Test(priority=5)
	public void checkBoxMale()
	{
		WebElement male=driver.findElement(By.id("male"));
		if(male.isSelected()==false)
		{
			male.click();
			System.out.println("Clicked");
		}
		else
		{
			System.out.println("Not Clickable");
		}
	}
	
	@Test(priority=6)
	public void days() 
	{
	    List<WebElement> days = driver.findElements(By.xpath("//div[@class='form-check form-check-inline']//input[@type='checkbox']"));
	    for (int i = 0; i < days.size(); i++) 
	    {
	        String dayName = days.get(i).findElement(By.xpath("./following-sibling::label")).getText();
	        System.out.print(dayName+" ");
	    }
	}
	@Test(priority=7)
	public void boxSelected()
	{
	    List<WebElement> days = driver.findElements(By.xpath("//div[@class='form-check form-check-inline']//input[@type='checkbox']"));
	    for(int i=0;i<days.size();i++)
	    {
	    	if(i%2==1)
	    	{
	    		WebElement day=days.get(i);
	    		day.click();
	    	}
	    }
    }
	
	@Test(priority=8)
	public void countrySelected()
	{
		WebElement country=driver.findElement(By.id("country"));
		Select cntry=new Select(country);
		cntry.selectByValue("germany");
	}

	@Test(priority=9)
	public void colorSelected()
	{
		WebElement colors=driver.findElement(By.id("colors"));
		Select color=new Select(colors);
		color.selectByValue("white");
	}
	
	@Test(priority=10)
	public void sortedList()
	{
		WebElement sortedList=driver.findElement(By.id("animals"));
		Select animals=new Select(sortedList);
		animals.selectByVisibleText("Lion");
	}

	
	@Test(priority=11)
	public void datePicker()
	{
		WebElement date=driver.findElement(By.xpath("//input[@id='datepicker']"));
		date.click();
		WebElement selectDate=driver.findElement(By.xpath("//a[@data-date='6']"));
		selectDate.click();
	}
	
	
	@Test(priority=12)
	public void datePicker2()
	{
		WebElement date=driver.findElement(By.xpath("//input[@id='txtDate']"));
		date.click();
		WebElement selectDate=driver.findElement(By.xpath("//a[@data-date='6']"));
		selectDate.click();
	}
	
	
	@Test(priority=13)
	public void datePicker3()
	{
		WebElement date=driver.findElement(By.xpath("//input[@id='start-date']"));
		date.click();
	}

	
	@Test(priority=14)
	public void subscribeToLink()
	{
		WebElement link=driver.findElement(By.xpath("//a[@class='feed-link']"));
		System.out.println(link.getText());
		link.click();
		String windowHandle=driver.getWindowHandle();
		System.out.println(windowHandle);
		Set<String> windowHandles=driver.getWindowHandles();
		System.out.println(windowHandles);
		for(String handles:windowHandles)
		{
		    if(!handles.equals(windowHandle))
		    {
		    	driver.switchTo().window(handles);
			    driver.close();
			    driver.switchTo().window(windowHandle);
		    }
		    else
		    {
			System.out.println("Not able to windowHandled");
		    }
		}
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	
	public static void main(String args[])
	
	{
		HandlingGUIElements hge=new HandlingGUIElements();
		hge.setUp();
		hge.inputNameHandling();
		hge.inputEmailHandling();
		hge.inputPhoneHandling();
		hge.checkBoxMale();
		hge.days();
		hge.boxSelected();
		hge.countrySelected();
		hge.sortedList();
		hge.datePicker();
		hge.datePicker2();
		hge.datePicker3();
		hge.subscribeToLink();
		hge.tearDown();
	}
	

}
