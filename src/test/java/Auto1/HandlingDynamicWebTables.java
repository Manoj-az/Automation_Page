package Auto1;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseClass.Base;

public class HandlingDynamicWebTables extends Base
{
	@Test(priority=1)
	public void getTitle()
	{
		String title=driver.findElement(By.xpath("//h2[normalize-space()='Dynamic Web Table']")).getText();
		System.out.println(title);
	}
	
	@Test(priority=2)
	public static void getTableData()
	{
	     int rows=driver.findElements(By.xpath("//table[@id='taskTable']//tr")).size();
	     System.out.println(rows);
	     int columns=driver.findElements(By.xpath("//table[@id='taskTable']//th")).size();
	     System.out.println(columns);
	     
	     @SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
	     System.out.println("Enter browser name: ");
	     String browser=sc.nextLine();
	     
	     boolean browserName=false;
	     for(int r=2;r<rows;r++)
	     {
             String names=driver.findElement(By.xpath("//table[@id='taskTable']//tr["+r+"]//td[1]")).getText();
      		 if(names.equalsIgnoreCase(browser))
      		 {
      			browserName =true;
      			 for(int c=1;c<=columns;c++)
      			 {
      				String value = driver.findElement(By.xpath("//table[@id='taskTable']//tr[" + r + "]//td[" + c + "]")).getText();
                    System.out.println(value);
      			 }
      			break;
      		  }
      	  }
	     if(!browserName)
  		 {
  		    System.out.println("Browser Not Found");
  		 }
	      
	}   
	     
	 @Test(priority=3)
     public void getDetailsOfDisplayValues()
     {
		 WebElement chromeCPU=driver.findElement(By.xpath("//strong[@class='chrome-cpu']"));
    	 System.out.println("CPU load of Chrome process: "+chromeCPU.getText());
    	 
    	 WebElement firefoxMemory=driver.findElement(By.xpath("//strong[@class='firefox-memory']"));
    	 System.out.println("Memory Size of Firefox process: "+firefoxMemory.getText());
    	 
    	 WebElement chromeNetwork=driver.findElement(By.xpath("//strong[@class='chrome-network']"));
    	 System.out.println("Network speed of Chrome process: "+chromeNetwork.getText());
    	 
    	 WebElement firefoxSpace=driver.findElement(By.xpath("//strong[@class='firefox-disk']"));
    	 System.out.println("Disk space of Firefox process:  "+firefoxSpace.getText());
    	 
    	 
     }
	 
	 public static void main(String[] args)
		{
			
			
			HandlingDynamicWebTables dt=new HandlingDynamicWebTables();
			dt.getTitle();
			HandlingDynamicWebTables.getTableData();
			dt.getDetailsOfDisplayValues();
			
		}

	}
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
//	     //Getting all data
//	     for(int r=2;r<rows;r++)
//	     {
//	    	 for(int c=1;c<=columns;c++)
//	    	 {
//	    		 String values=driver.findElement(By.xpath("//table[@id='taskTable']//tr["+ r +"]//td["+ c +"]")).getText();
//	    		 //System.out.println(values);
//	    	 }
//	     
//	    	 //Getting Browser Names
//	    	 int browserNames=driver.findElements(By.xpath("//table[@id='taskTable']//tr//td[1]")).size();
//	    	 //System.out.println(browserNames);
//	    	 for(int n=1;n<=browserNames;n++)
//	    	 {
//	    		 String names=driver.findElement(By.xpath("//table[@id='taskTable']//tr["+n+"]//td[1]")).getText();
//	    		 System.out.println(names);
//	    		 
//	    		 
//	    		 switch(names)
//	    		 {
//	    		 case "Chrome":
//	    			 			for(int ro=1;ro<=rows;ro++)
//	    			 			{
//	    			 				for(int c=1;c<=columns;c++)
//	    			 				{
//	    			 					String values=driver.findElement(By.xpath("//table[@id='taskTable']//tr["+ ro +"]//td["+ c +"]")).getText();
//	    			 					System.out.println("getting values: "+values);
//	    			 				}
//	    			 			}
//	    			 break;
//	    			 
//	    		 case "System":
//			 			for(int ro=1;ro<=rows;ro++)
//			 			{
//			 				for(int c=1;c<=columns;c++)
//			 				{
//			 					String values=driver.findElement(By.xpath("//table[@id='taskTable']//tr["+ ro +"]//td["+ c +"]")).getText();
//			 					System.out.println("getting values: "+values);
//			 				}
//			 			}
//			 		break;
//	    			 
//			 		
//	    		 case "Internet Explorer":
//			 			for(int ro=1;ro<=rows;ro++)
//			 			{
//			 				for(int c=1;c<=columns;c++)
//			 				{
//			 					String values=driver.findElement(By.xpath("//table[@id='taskTable']//tr["+ ro +"]//td["+ c +"]")).getText();
//			 					System.out.println("getting values: "+values);
//			 				}
//			 			}
//			       break;
//			       
//	    		 case "Firefox":
//			 			for(int ro=1;ro<=rows;ro++)
//			 			{
//			 				for(int c=1;c<=columns;c++)
//			 				{
//			 					String values=driver.findElement(By.xpath("//table[@id='taskTable']//tr["+ ro +"]//td["+ c +"]")).getText();
//			 					System.out.println("getting values: "+values);
//			 				}
//			 			}
//			       break;
//	    		 
//	    		 default:System.out.println("Enter in Limited Browser");
//	    		 }
//	    		
//	    		 if(names.equals("Chrome"))
//	    		 {
//	    			 for(int ro=1;ro<=rows;ro++)
//	    		     {
//	    		    	 for(int c=1;c<=columns;c++)
//	    		    	 {
//	    		    		 String values=driver.findElement(By.xpath("//table[@id='taskTable']//tr["+ r +"]//td["+ c +"]")).getText();
//	    		    		 System.out.println("getting values: "+values);
//	    		    	 }
//	    		     }
//	    		 }
//	    	 }
//	     
//	    	 
//	     }
//	     
//	}
	
	
	
	
	
	
	
