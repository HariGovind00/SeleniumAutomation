package Java_stream;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Automate_filter_using_Stream {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("************");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
//select the first column from the given table
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
//Select the vegatable name from the given first column
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		
//3. Display the lsit ele and store it in new list
		List<String> originalList = elementsList.stream().map(s ->s.getText()).collect(Collectors.toList());
		System.out.println("Get List and added in new list:");
		System.out.println(originalList);
//sort the original list of step3-->sorted order
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		System.out.println("AFTER LIST SORTED AND UPDATED IN NEW LIST:");
		System.out.println(sortedList);
//Compare the original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		
//Let try to pick the price for the specific vegetable & click on the next page and look for veg
		List<String> vegpricelist;
		do
		{
		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
		vegpricelist=rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
		
		vegpricelist.forEach(a-> System.out.println("Price of the : "+a));
		
		if(vegpricelist.size()<1)
		{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}
		while(vegpricelist.size()<1);
		{
			//driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		
		
	}

	private static String getPriceVeggie(WebElement s) 
	{
		String itemprice=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return itemprice;
	}
}
