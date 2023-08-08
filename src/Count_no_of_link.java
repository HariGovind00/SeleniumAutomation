import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Count_no_of_link
{
	public static void main(String[] args) {
		// call the Browser Driver
				WebDriver driver = new EdgeDriver();

				// max the browser
				driver.manage().window().maximize();

				// implicit wait
	
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				
				int linkcount=driver.findElements(By.tagName("a")).size();
	
				System.out.println("Total no of link is: "+linkcount);
				
				// display the count and link from the footer of the page
				WebElement foot=driver.findElement(By.id("gf-BIG"));
				//int footlinkcount=driver.findElements(By.tagName("li")).size();
				int footlinkcount=foot.findElements(By.tagName("a")).size();
				System.out.println("Footer link count is: "+footlinkcount);
				
				//foind the footer first column links
				//int firstColFooter=driver.findElements(By.xpath("(//ul)[1]/li")).size();
				WebElement Foot=driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
				int firstColFooter=Foot.findElements(By.tagName("a")).size();
				System.out.println("First column footer link count is: "+firstColFooter);
				
				//click on the link of the first column footer
//				for(int i=1;i<firstColFooter;i++)
//				{
//					
//					Foot.findElements(By.tagName("a")).get(i).sendKeys(Keys.CONTROL,Keys.ENTER);
//				}
				Set<String> click=driver.getWindowHandles();
				Iterator<String> it=click.iterator();
				while(it.hasNext())
				{
					driver.switchTo().window(it.next());
					System.out.println(driver.getTitle());
				}
				
				
				driver.close();
	}
}
