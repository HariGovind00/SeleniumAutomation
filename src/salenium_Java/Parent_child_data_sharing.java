package salenium_Java;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parent_child_data_sharing
{

	public static void main(String[] args) throws InterruptedException
	{

		// call the Browser Driver
		WebDriver driver = new ChromeDriver();

		// max the browser
		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//Load parent url
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		//click on the url from Parent page to get username
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		
		Set<String> windows=driver.getWindowHandles();  //win[0]parent, win[1]child windows
		Iterator<String> it=windows.iterator();
		String parentid=it.next();
		String childid=it.next();
		driver.switchTo().window(childid);
		Thread.sleep(3000);
		//String email=driver.findElement(By.xpath("//a[text()='mentor@rahulshettyacademy.com']")).getText();
		//or
		String email=driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(email);
		driver.switchTo().window(parentid);
		driver.findElement(By.id("username")).sendKeys(email);
		
		
		
		
		
	}

}
