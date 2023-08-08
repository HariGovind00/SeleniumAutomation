package salenium_Java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlightBookCountryDropdown 
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
				
			//Automate the search box
				driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("Ind");
				Thread.sleep(2000);
				//FindElements for finiding country start with Ind
				List<WebElement> text=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
				System.out.println(text.size());
				for(WebElement country: text)
				{
					if(country.getText().equalsIgnoreCase("India"))
					{
						country.click();
						break;
					}
				}
				
			//close the browser
				Thread.sleep(5000);
				driver.close();
				
}
}
