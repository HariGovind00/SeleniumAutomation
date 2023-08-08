package salenium_Java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException
	{
	
		//declare and establish connection to browser
		System.setProperty("webdriver.chrome.driver", "E:\\Salenium Application\\Chrome drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//maximize the browser win
		driver.manage().window().maximize();
		
		//locate the URL
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Proceeding with Login page
		//Enter UserName
		driver.findElement(By.id("inputUsername")).sendKeys("HariGovind");
		
		//Enter your password
		driver.findElement(By.name("inputPassword")).sendKeys("Password123");
		
		//Click Login button
		driver.findElement(By.className("signInBtn")).click();
		
		//Display the error on the IDE
		WebElement err=driver.findElement(By.cssSelector("p.error"));
		System.out.println("Error is: "+err.getText());
		
//************************************************************************************************

		//Forget password and reset password page automate
		
//*************************************************************************************************		
	
		//Enter the Forget password url
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		//locate using xpath for name text
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Hari");
		
		//Locate using cssSelector tagname for email search box
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("test@gmail.com");
		
		//sleep
		Thread.sleep(5000);
		
		//when we don't have any element to call we use indexing 
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		
		//sleep 
		Thread.sleep(5000);
		
		//Add the new email id
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("hari@gmail.com");

		
		
		//Locate using xpath for phone no
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("8667023434");
		
		//Reset password using xpath
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		//sleep for 2 second
		Thread.sleep(5000);
		
		//close the browser
		driver.close();

	}
}
