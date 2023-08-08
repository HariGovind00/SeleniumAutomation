package salenium_Java;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Mobile_app {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("******************************");

		// call the Browser Driver
		WebDriver driver = new ChromeDriver();

		// max the browser
		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Please enter phone name
		String[] phone = { "iphone X", "Blackberry", "Nokia Edge" };
		
		// Converting arrays to ArrayList to declare data in dynamic way
				List userReqPhone = Arrays.asList(phone);

		// Load the Url
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		// Call static Login form method
		loginForm(driver);
	
		// call static selectPhone method
		selectPhone(driver, userReqPhone);
		
		//call phoneQty method
		phoneQty(driver, userReqPhone);
				
		// close the browser
		
	}

	public static void loginForm(WebDriver driver) throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Starting point of the Login page Automate

		// User defined input for the username

		// Please enter your Username
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rahulshettyacademy");

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("learning");

		// checkbox
		driver.findElement(By.xpath("//label[2]")).click();
		Thread.sleep(6000);

		// alert box
		driver.findElement(By.xpath("//button[text()='Okay']")).click();

		// select the dropdown
		WebElement options = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select accdrop = new Select(options);
		accdrop.selectByVisibleText("Consultant");

		// check box
		driver.findElement(By.cssSelector("#terms")).click();

		// login
		System.out.println(driver.findElement(By.id("signInBtn")).getText());
		driver.findElement(By.id("signInBtn")).click();

	}

	public static void selectPhone(WebDriver driver, List userReqPhone)
	{
		

//Display the names of the phone by selecting all phone names
		List<WebElement> phoneName = driver.findElements(By.cssSelector("h4.card-title"));
		for (int i = 0; i < phoneName.size(); i++) {
			String list = phoneName.get(i).getText();
//print the list of phones name in console
			System.out.println(list);
			if (userReqPhone.contains(list)) {
				System.out.println("Your option selected successfully!!");
				driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
			} else {
				System.out.println("Sorry, Out of Stock!!!");
			}
		}
	}

   public static void phoneQty(WebDriver driver,List userReqPhone)
   {
	   driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
	   
	   driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
					
	}

}
