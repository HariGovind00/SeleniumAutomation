import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Nested_Frame_assignment 
{
public static void main(String[] args) {
	// call the Browser Driver
			WebDriver driver = new ChromeDriver();

			// max the browser
			driver.manage().window().maximize();

			// implicit wait
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
			//load url
			driver.get("https://the-internet.herokuapp.com/nested_frames");
			
			//load the frame-top 
			driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));
			
			//Load the middle frame from the frame-top
			driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
			
			String text=driver.findElement(By.id("content")).getText();
			System.out.println(text);
			
			driver.close();		
}
}
