package salenium_Java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsNavigationActivity 
{
public static void main(String[] args) throws InterruptedException
{
System.out.println("Starting point of the code:):)(:(:");

//load the chrome driver
System.setProperty("webdriver.chrome.driver", "E:\\Salenium Application\\Chrome drivers\\chromedriver_win32\\chromedriver.exe");

//call the web Browser
WebDriver driver=new ChromeDriver();
//maximize the browser win
driver.manage().window().maximize();
//load the url
driver.get("https://rahulshettyacademy.com/AutomationPractice/");

//nav to new page
driver.navigate().to("https://www.google.com");
//load back practice page
driver.navigate().back();
driver.navigate().forward();


System.out.println("Ending point of the code:):)(:(:");

//Thread.sleep

Thread.sleep(4000);
driver.close();

}
}
