package salenium_Java;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Take_screenshot 
{
public static void main(String[] args) 
{
	// call the Browser Driver
			WebDriver driver = new ChromeDriver();

			// max the browser
			driver.manage().window().maximize();

			// implicit wait
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
			//load the url
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   // FileUtils.copyFile("E:\\SaleniumFileSavePath");
}

}
