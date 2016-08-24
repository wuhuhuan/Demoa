package TestModule1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.thoughtworks.selenium.Wait;

import utils.Browsers;
import utils.BrowsersType;
import utils.ParseProperties;





public class Register {

	private WebDriver driver;
	private ParseProperties data;
	private ParseProperties locator;
	
	@BeforeClass
	
	public void beforeClass(){
		data = new ParseProperties(System.getProperty("user.dir")+"\\tool\\test.properties");
		locator = new ParseProperties(System.getProperty("user.dir")+"\\tool\\locator.properties");
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
	}
//	@Parameters("TestData")
	@Test
	public void start() throws InterruptedException{
//		Wait wait =new Wait(driver);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); 
		driver.get(data.getValue("url"));
		driver.findElement(By.linkText(locator.getValue("linkText"))).click();
		driver.findElement(By.xpath(locator.getValue("FirstName"))).sendKeys(data.getValue("FirstName"));
		driver.findElement(By.xpath(locator.getValue("LastName"))).sendKeys(data.getValue("LastName"));
		driver.findElement(By.xpath(locator.getValue("Dob"))).sendKeys(data.getValue("Dob"));
		Select Gender = new Select(driver.findElement(By.xpath(locator.getValue("Gender"))));
		Gender.selectByVisibleText(data.getValue("Gender"));
		Select Country = new Select(driver.findElement(By.xpath(locator.getValue("Country"))));
		Country.selectByVisibleText(data.getValue("Country"));
		Select helpLanguage = new Select(driver.findElement(By.xpath(locator.getValue("helpLanguage"))));
		helpLanguage.selectByVisibleText(data.getValue("helpLanguage"));
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)", "");
		driver.findElement(By.xpath(locator.getValue("Email"))).sendKeys(data.getValue("Email"));
		driver.findElement(By.xpath(locator.getValue("ConfirmEmail"))).sendKeys(data.getValue("ConfirmEmail"));
		driver.findElement(By.xpath(locator.getValue("PrimaryContactNumber"))).sendKeys(data.getValue("PrimaryContactNumber"));
		driver.findElement(By.xpath(locator.getValue("SecondaryContactNumber"))).sendKeys(data.getValue("SecondaryContactNumber"));
		driver.findElement(By.xpath(locator.getValue("Line1"))).sendKeys(data.getValue("Line1"));
		Select CountryId = new Select(driver.findElement(By.xpath(locator.getValue("CountryId"))));
		CountryId.selectByVisibleText(data.getValue("CountryId"));
		driver.findElement(By.xpath(locator.getValue("Password"))).sendKeys(data.getValue("Password"));
		driver.findElement(By.xpath(locator.getValue("ConfirmPassword"))).sendKeys(data.getValue("ConfirmPassword"));
		driver.findElement(By.xpath(locator.getValue("IsTermsSigned"))).click();
		driver.findElement(By.xpath("//*[@id='btnSubmit']")).click();
		Thread.sleep(3000);
		//*[@id="IsTermsSigned"]
		
	}
	
	@AfterClass
	public void quit(){
		driver.quit();
	}
}
