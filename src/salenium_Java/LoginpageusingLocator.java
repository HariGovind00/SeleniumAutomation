package salenium_Java;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginpageusingLocator 
{

	private Object getpassword;


	public static void main(String[] args) throws InterruptedException
	{

		//declare and establish connection to browser
				System.setProperty("webdriver.chrome.driver", "E:\\Salenium Application\\Chrome drivers\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				
				//maximize the browser win
				driver.manage().window().maximize();
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
				//Calling the getpassword() method to enter the password instead of hardcoding
				String password=getpasswordfun(driver);
				
				//locate the URL
				driver.get("https://rahulshettyacademy.com/locatorspractice/");
				
			
				
				
				//username using xpath 
				driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/input[1]")).sendKeys("Harigovind");
				
				//Enter password
				driver.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys(password);

				
				//click on the checkbox 
				driver.findElement(By.cssSelector("input[name='chkboxOne']")).click();
				
				//click on login button
				WebElement login=driver.findElement(By.xpath("//button[@class='submit signInBtn']"));
				login.click();
				
				Thread.sleep(3000);
				//display the login page content on the console of ide
				WebElement contentDisp=driver.findElement(By.xpath("//div[@class='login-container']"));
				System.out.println(contentDisp.getText());
				Thread.sleep(2000);
				//logout user
				driver.findElement(By.xpath("//button[@class='logout-btn']")).click();
				
				Thread.sleep(5000);
				driver.close();
				
				
			
	}

	
	public static String getpasswordfun(WebDriver driver) throws InterruptedException
	{
		
		//locate the URL
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//forget password url
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		
		//Reset password url
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		Thread.sleep(2000);
		
		//get the text 
		WebElement text=driver.findElement(By.cssSelector("p[class='infoMsg']"));
		System.out.println(text.getText());
		
		//text is: "Please use temporary password 'rahulshettyacademy' to Login."
		String []getpass=text.getText().split("'");
		
		//getpass[0]==>Please use temporary password
		//getpass[1]==>rahulshettyacademy' to Login.
		
			//rahulshettyacademy' to Login.
			String [] getpass1=getpass[1].split("'");
		      //getpass1[0]==>rahulshettyacademy
			 // getpass1[1]==>to Login.
			
			//STORE THE PASSWORD IN NEW STRING VAR
			String getpassword=getpass1[0];
			return getpassword;
		
		
		
	}
}
