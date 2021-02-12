package bitfinix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task {
	
	// Declare global variable
	public WebDriver driver; 
	WebDriverWait wait;
	
	@BeforeTest
	public void Setup()
	{
		// Local path to the chrome driver
		System.setProperty("webdriver.chrome.driver", "/home/joe/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 20);
	}
	@Test
  public void loadPage()
	{
		// Load page
		driver.get("https://www.bitfinex.com/");
  }
	@Test
	public void cookies()
	{
		// Need to wait for page to load
		//Allow cookies
		WebElement cookies = driver.findElement(By.xpath("//button[@class='bp3-button cookies_btn']"));
		wait.until(ExpectedConditions.elementToBeClickable(cookies));
		cookies.click();
		//Agree to cookies popup
		driver.switchTo().activeElement().click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/button")).click();
	}
	@Test
	public void search()
	{
		// Click search icon
		driver.findElement(By.cssSelector("#homepage_wrapper > div.extra_content > div.landing_ticker.blue.bp3-dark.center > div > div.landing-tickers__header > div > div.visible-desktop > div.bp3-tabs.ccy-tabs > div > a.landing-tickers__search > span")).click();
		// Send text
		driver.findElement(By.xpath("//*[@id=\"homepage_wrapper\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/input")).sendKeys("Unus Sed Leo");
	}
	@Test
	public void clickResult()
	{
		driver.findElement(By.cssSelector("#homepage_wrapper > div.extra_content > div.landing_ticker.blue.bp3-dark.center > div > div.landing-tickers__wrap-table.landing-tickers__trading-table > div.stat-table__wrapper.landing-tickers__table.custom-scrollbar > table")).click();
	}
	@Test
	public void validateResult()
	{
		String expectedUrl = "​https://trading.bitfinex.com/t/LEO:USD?demo=true" ; 
		// Wait for page to load
	    wait.until(ExpectedConditions.urlMatches(expectedUrl));
		String actualUrl = driver.getCurrentUrl(); 
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	@AfterTest
	public void stop()
	{
		driver.close();
		driver.quit();
		
	}
}
