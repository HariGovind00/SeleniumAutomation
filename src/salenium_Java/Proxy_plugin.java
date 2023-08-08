package salenium_Java;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Proxy_plugin
{
public static void main(String[] args)
{
	System.out.println("*************************");
	
	ChromeOptions options=new ChromeOptions();
//	Proxy proxy=new Proxy();
//	proxy.setHttpProxy("ipaddreeeeess:4444");
//	options.setCapability("proxy", proxy);
	
	//Set the path to downlaod file
	Map<String, Object>prefs=new HashMap<String, Object>();
	prefs.put("download.default_directory", "E:\\SaleniumFileSavePath");
	options.setExperimentalOption("prefs", prefs);
	
	//To access insecure website successfully
	options.setAcceptInsecureCerts(true);
	
	//Impliment the above certificate and path to chrome browser
	WebDriver driver=new ChromeDriver(options);
	driver.get("https://expired.badssl.com/");
	System.out.println(driver.getTitle());
	
	System.out.println("*************************");
}
}
