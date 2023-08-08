package salenium_Java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeDemo {

	public static void main(String[] args) throws InterruptedException 
	{
		//declare and establish connection to browser
		System.setProperty("webdriver.chrome.driver", "E:\\Salenium Application\\Chrome drivers\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		//load the url
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");	
		
		//locate the login and click on the url
		WebElement loginbtn=driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]"));
		loginbtn.click();
		String logintext=loginbtn.getText();
		System.out.println(logintext);
		
		
		if(logintext.equals("Login"))
		{
			Thread.sleep(3000);
			System.out.println("Login button is clicked:"+logintext);
		}
		else
		{
			System.out.println("Login button is not clicked...!!!");
		}
		//close the browser
		Thread.sleep(2000);
		driver.close();
	}

}
