package salenium_Java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDropDown {

	public static void main(String[] args) throws InterruptedException 
	{
		System.out.println("Start of the code--:)");
		
		//load the chromeDriver
		WebDriver driver=new ChromeDriver();
		
		//max the browser
		driver.manage().window().maximize();
		
		//load the url
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//click the dropdown box
		driver.findElement(By.id("divpaxinfo")).click();
		System.out.println("Initial text Displayed:"+driver.findElement(By.id("divpaxinfo")).getText());
		
		Thread.sleep(2000L);
		//select the passangers count
		for(int i=1;i<=4;i++)
		{
		driver.findElement(By.id("hrefIncAdt")).click();
		}
		// display the total passanger selected in console
		System.out.println("Final text Displayed:"+driver.findElement(By.id("divpaxinfo")).getText());
		
		Thread.sleep(4000);
		//Click on done button
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println();
		
		System.out.println("End of the code..:)");
		
		driver.close();
	}

}
