import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v110.page.Page.GetAppIdResponse;
import org.openqa.selenium.support.ui.Select;
//RahulShettyAcademy Assignment 6
public class Checkbox_dropdown_alert {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String[] arr = { "Option3" };
		List<String> usercheck = Arrays.asList(arr);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//radio option
		List<WebElement> check = driver.findElements(By.xpath("//div[@id='checkbox-example'] //label"));

		for (int i = 0; i < check.size(); i++) {
			System.out.println(check.get(i).getText());
			String syscheck = check.get(i).getText();
			if (usercheck.contains(syscheck)) {
				
				driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).click();

				WebElement drop = driver.findElement(By.id("dropdown-class-example"));
				Select sc = new Select(drop);
				String alertbox = syscheck;
				sc.selectByIndex(i + 1);

				// alert box steps
				driver.findElement(By.id("name")).sendKeys(alertbox);

				WebElement al = driver.findElement(By.id("alertbtn"));
				al.click();

				System.out.println("I'M alert: " + driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();

				System.out.println("Hello:" + syscheck);
			}

		}

	}
}
