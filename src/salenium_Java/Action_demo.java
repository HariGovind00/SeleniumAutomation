package salenium_Java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action_demo 
{
public static void main(String[] args)
{
System.out.println("************************");	
System.setProperty("webdriver.chrome.driver", "E:\\Salenium Application\\Chrome drivers\\chromedriver_win32\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get("https://www.amazon.in/");
Actions act=new Actions(driver);
WebElement mouseOver=driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
act.moveToElement(mouseOver).build().perform();

act.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
act.scrollToElement(driver.findElement(By.xpath("//div[@aria-label='hello kitty']"))).sendKeys(Keys.ARROW_DOWN).click().build().perform();
act.moveToElement(mouseOver).contextClick().click().build().perform();
//enter 'HELLO' in search box
//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("HELLO");

driver.close();

//quit the browser
driver.quit();
System.out.println("************************");	
}
}
