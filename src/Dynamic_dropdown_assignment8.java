import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Dynamic_dropdown_assignment8
{
	public static void main(String[] args) throws InterruptedException {
		// Load Browser Webdriver
		WebDriver driver = new ChromeDriver();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Maximize the Browser
		driver.manage().window().maximize();

		// Load the Url
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//click the dropdown text
		
		//driver.findElement(By.id("#autocomplete")).click();
		driver.findElement(By.id("autocomplete")).sendKeys("Ind");
	   // driver.findElement(By.xpath("//div[text()='India']")).click();
		List<WebElement> country=driver.findElements(By.cssSelector("ul#ui-id-1"));
		
		for(int i=0;i<country.size();i++)
		{
			String CountryExp=country.get(i).getText();
			System.out.println(CountryExp);
		}
		
		//enter the Text
		
}
}
