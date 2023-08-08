package salenium_Java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookFlightAutomate
{
public static void main(String[] args) throws InterruptedException
{
System.out.println("********************************");
//load the chromeDriver
		WebDriver driver=new ChromeDriver();
		
		//max the browser
			driver.manage().window().maximize();
		
		//load the url
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			
		//From text box xpath 
			driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
			
			//search the specific journey from
				driver.findElement(By.xpath("//a[@value='MAA']")).click();
				Thread.sleep(2000);
				
		//To text box using parent child relationship xpath
			driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click();
			
			
		//Load the passanger class details SetDropDown.java class
			SelectDropDown sdd=new SelectDropDown();
			sdd.main(null);
			
			
			
	//CLOSE THE BROWSER
			Thread.sleep(2000);
			driver.close();
System.out.println("Congratulation!!! we have executed the script successfully...@!!!");
System.out.println("********************************");


}
}
