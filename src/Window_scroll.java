import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_scroll {

	public static void main(String[] args) 
	{
		System.out.println("*****************");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//Below code will scroll the page
		js.executeScript("window.scrollBy(0,600)");
		
		//This will scroll the specific 
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		String txt=driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim();
		System.out.println(txt);
		 
		
		driver.close();
		

		System.out.println("*****************");
	}

	private static Iterable<WebElement> stream() {
		// TODO Auto-generated method stub
		return null;
	}

}
