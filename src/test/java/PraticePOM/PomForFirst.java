package PraticePOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PomForFirst 
{
	
	public WebDriver driver;
	
	
	//constructor
	PomForFirst(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locators
	By userName=By.id("username");
	By password=By.id("password");
	By btnClick=By.xpath("//button[@class='radius']");
	
	
	
	//Action Methods
	
	public void userNameMethod(String name)
	{
		driver.findElement(userName).sendKeys(name);
	}
	
	public void pwd(String passwordText)
	{
		driver.findElement(password).sendKeys(passwordText);
	}
	
	public void button()
	{
		driver.findElement(btnClick).click();
	}

}
