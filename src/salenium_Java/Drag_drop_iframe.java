package salenium_Java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_drop_iframe
{
	public static void main(String[] args) throws InterruptedException
	{

		// call the Browser Driver
		WebDriver driver = new ChromeDriver();

		// max the browser
		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		//load the url
		driver.get("https://jqueryui.com/droppable/");
		
		//load the iframe
		//There are three ways to declare frame() method
			//1.frameByiNDEX
		 	//3.by element locator
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement designation=driver.findElement(By.id("droppable"));
		Actions act=new Actions(driver);
		act.dragAndDrop(source, designation).build().perform();
		
		//once you are done working with iframe now come back to default to use other function
		//driver.switchTo().defaultContent();
		//if you are not passing the above method you won't be able to use other non iframe locator 
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(4000);
		driver.close();
	}
}
