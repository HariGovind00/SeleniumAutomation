package salenium_Java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Check_Broken_URL_FROM_LINL 
{
public static void main(String[] args)
{
	//load the chromeDriver
			WebDriver driver=new ChromeDriver();
			
			//max the browser
				driver.manage().window().maximize();
			
			//load the url
				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				
				//footer url
				driver.findElements(By.xpath("//div[@id='gf-BIG']"));
					
}
}
