package salenium_Java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownSelectDeselect {

	public static void main(String[] args) throws InterruptedException 
	{
	//load the chrome driver
		WebDriver driver=new ChromeDriver();
	
	//maximize the screen
		driver.manage().window().maximize();
		
	//load the url
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
	//access the dropdown using select class
		WebElement dropdown=driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
		
		Select accdrop=new Select(dropdown);
		
		//select the dropdown using selectByIndex();
		accdrop.selectByIndex(3);
		System.out.println(accdrop.getFirstSelectedOption().getText());
		Thread.sleep(3000);
		
		////select the dropdown using selectByVisibleText();
		accdrop.selectByVisibleText("INR");
		System.out.println(accdrop.getFirstSelectedOption().getText());
		Thread.sleep(3000);
		
		////select the dropdown using selectByValue();
		accdrop.selectByValue("AED");
		System.out.println(accdrop.getFirstSelectedOption().getText());
		Thread.sleep(3000);
		
		//close the browser
		driver.close();
		
		
	}

}
