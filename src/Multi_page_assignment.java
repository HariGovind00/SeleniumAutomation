import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Multi_page_assignment 
{
	public static void main(String[] args) throws InterruptedException
	{

		// call the Browser Driver
		WebDriver driver = new ChromeDriver();

		// max the browser
		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//load url
		driver.get("https://the-internet.herokuapp.com/windows");
	
		//click on click Here
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		Set<String> win=driver.getWindowHandles();
		Iterator<String> i=win.iterator();
		String parent=i.next();
		String child=i.next();
		driver.switchTo().window(child);
		//display the content of the Click Here page
		String childText=driver.findElement(By.tagName("h3")).getText();
		System.out.println(childText);
		
		driver.switchTo().window(parent);
		String ParentText=driver.findElement(By.tagName("h3")).getText();
		System.out.println(ParentText);
		
		driver.quit();
	
	}
}
