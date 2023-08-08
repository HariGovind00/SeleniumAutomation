package salenium_Java;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Book_future_dated_calendar_Ticket {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Welcome to HGK Airlines!!!");

//User input for Flight Booking date
		Scanner Sc1 = new Scanner(System.in);
		System.out.println("Please enter the date for the flight booking:");
		int day = Sc1.nextInt();

//Load Browser Webdriver
		WebDriver driver = new ChromeDriver();

//Implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//Maximize the Browser
		driver.manage().window().maximize();

//Load the Url
		driver.get("https://www.makemytrip.com/flights/");

// select the calendar

		driver.findElement(By.xpath("//div[@class='fsw_inputBox dates inactiveWidget ']")).click();
//While loop to check Calendar Month and click button

		while (!driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText().contains("November 2023")) {

			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();

		}
// Display the final month selected
		String month = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
//Display the month and year in console of IDE

		System.out.println("Month selected is:" + month);

//Specific day from the calendar
		List<WebElement> cal = driver.findElements(By.xpath("//div[@class='DayPicker-Months'] /div[1]//div[@class='dateInnerCell']/p[1]"));

//loop the date till the match is found.
		for (int i = 0; i < cal.size(); i++) {
			System.out.println(cal.get(i).getText());
			int date = Integer.parseInt(cal.get(i).getText());
			if (date == day) {
				driver.findElements(
						By.xpath("//div[@class='DayPicker-Months'] /div[1]//div[@class='dateInnerCell']/p[1]")).get(i)
						.click();
				System.out.println("Flight Booked on: " + date + " " + month);
				break;
			}

		}

//close the browser
		driver.close();

		System.out.println("**************************");
	}
}
