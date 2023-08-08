import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table_Automate_Assignment7 {
	public static void main(String[] args) {
		// Load Browser Webdriver
		WebDriver driver = new ChromeDriver();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Maximize the Browser
		driver.manage().window().maximize();

		// Load the Url
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Print the total no of rows
		int noOfTotalRows = driver.findElements(By.cssSelector("[name='courses'] tr")).size();
		System.out.println("Total No Of Rows is: " + noOfTotalRows);

		int noOfCol = driver.findElements(By.cssSelector("[name='courses'] th")).size();
		System.out.println("No of column is: " + noOfCol);

		System.out.println(driver.findElement(By.xpath("//table/tbody/tr[3]")).getText());

		// close the browser
		driver.close();
	}
}
