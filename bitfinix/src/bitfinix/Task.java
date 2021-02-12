package bitfinix;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task {
	
	// Declare global variable
	public WebDriver driver; 
  
	@BeforeTest
	public void Setup()
	{
		// Local path to the chrome driver
		System.setProperty("webdriver.chrome.driver", "/home/joe/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	@Test
  public void loadPage()
	{
		// Load page
		driver.get("https://www.bitfinex.com/");
  }
	@AfterTest
	public void stop()
	{
		
	}
}
