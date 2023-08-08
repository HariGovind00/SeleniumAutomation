package Selenium.Locators;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Locators
{
public static void main(String[] args) 
{
	System.setProperty("webdriver.chrome.driver", "E:\\Salenium Application\\Chrome drivers\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	//Max the screen
	driver.manage().window().maximize();
	
	//load url
	driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	
	//locate the url
	//user name 
	driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
	//Password
	driver.findElement(By.name("password")).sendKeys("learning");
	
	//click the radio button
	driver.findElement(By.xpath("//label[@class='customradio'][1]")).click();
	
	//select the dropdown options
Select selopt=new Select(driver.findElement(By.xpath("//select[@class='form-control']")));

//selopt.selectByIndex(2);
	
//selopt.selectByValue("teach");
selopt.selectByVisibleText("Teacher");

//checkbox selection
driver.findElement(By.id("terms")).click();

//signInBtn
driver.findElement(By.id("signInBtn")).click();
	
	
	//close the browser
	//driver.close();
	
}
}
