package salenium_Java;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VegatableMyCart {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");

		WebDriver driver = new ChromeDriver();

		// max the browser
		driver.manage().window().maximize();

		System.out.println("Welcome to Vegatable WebSite!!!");

		// Declare the product to be searched for in a arrayList[]
		String[] vegatables = { "Brocolli", "Cauliflower", "Cucumber", "Carrot" };

		// load the url
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		shopVegatable(driver, vegatables);
	}

	public static void shopVegatable(WebDriver driver, String[] vegatables) throws InterruptedException {

		// Conver Arrays to List of Arrays
		List<String> vegsearch = Arrays.asList(vegatables);

		// select the quantity of the product.
//		for(int j=0;j<2;j++)
//		{
//			driver.findElement(By.xpath("//a[@class='increment']")).click();
//			
//		}

		// All Product details selection
		List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));
		Thread.sleep(3000);
		int inc = 0;
		for (int i = 0; i < product.size(); i++) {
			// split the cucumber -1kg
			String[] name = product.get(i).getText().split("-");

			// above array for Cucumber - 1kg, will be splited into two seperate text
			// ie name[0]-> Cucumber
			// name[1]-> 1kg

			// Now let's remove the space after Cucumber
			String finalVegName = name[0].trim();
			System.out.println(finalVegName);

			if (vegsearch.contains(finalVegName)) {
				inc++;

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (inc == vegatables.length) {
					System.out.println("I have successfully Executed for: " + inc);
				}

			}

		}

		// click on mycart
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();

		// checkout the mycart
		driver.findElement(By.xpath("//div[@class='action-block'] //button[@type='button']")).click();

		// Enter the promocode
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");

		// Click on Apply button to avail the entered promo
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

		// Place the order
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();

		// Select the country where to delivery
		List<WebElement> countryName = driver.findElements(By.tagName("select"));
		Thread.sleep(2000);

		for (WebElement CountryNamelist : countryName) {
			CountryNamelist.click();
			String loc = CountryNamelist.getText();
			System.out.println(loc);

			if (loc.contains("India")) {
				driver.findElement(By.xpath("//option[@value='India']")).click();

			}
		}

		// check the checkbox for the agreement
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='chkAgree']")).click();

		// Proceed button
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();

		// Close the Browser

		Thread.sleep(3000);
		driver.close();

		System.out.println("Code Executed successfully...!!!");

		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");

	}

}
