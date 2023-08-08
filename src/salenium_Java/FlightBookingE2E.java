package salenium_Java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightBookingE2E
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
					
					
				//select the country
					driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("Ind");	
					Thread.sleep(1000);
					//select India from the dynamic dropdown
					List<WebElement> country=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
					System.out.println(country.size());
			
					for(WebElement options: country)
					{
						System.out.println(options.getText());
						
						if(options.getText().equalsIgnoreCase("India"))
						{
							System.out.println("Welcome to Airways!!!");
							options.click();
						    
						}
						
					}
					
					//Steps to select the Journey details
					
					//From 
					driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
					
					driver.findElement(By.xpath("//a[@value='PAT']")).click();
					
					//To
					driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

					//Choose the date of journey from calendar
					Thread.sleep(2000);
					driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();
					
					//select the passanger count
					
					driver.findElement(By.id("divpaxinfo")).click();
					Thread.sleep(2000);
					  //Add the passanger
					    for(int i=1;i<=4;i++)
					    {
						driver.findElement(By.id("hrefIncAdt")).click();
						
					    }
					    WebElement count=driver.findElement(By.id("divpaxinfo"));
					    System.out.println(count.getText());
					    
					    //click on the done button
					    driver.findElement(By.xpath("//input[@value='Done']")).click();
					    
					   
					    //select the currency 
					    
					    Select option=new Select(driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency")));
					    option.selectByVisibleText("USD");
					  
					    
					    //SELECT THE CHECKBOX
					    driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).click();
					    
					    //search for the flight
					    driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
					    
					    //Close the browser
				          Thread.sleep(3000);
				          driver.close();
					
}
}
