package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class Do {

	private WebDriver driver;
	private Wait waiter;
	
	public Do(WebDriver driver){
		this.driver = driver;	
		waiter = new Wait(driver);
	}
	
	public WebElement what(String locatorname) {
		WebElement we=null;
		try{
			//this.waitForElementPresent(locatorname);
			we = driver.findElement(By.xpath(locatorname));
	     }catch(NoSuchElementException e){
		    System.out.println("-----:(-----");
	    }
		return we;
	}
	
	public WebElement whatLinkText(String locatorname) {
		WebElement we=null;
		try{
			//this.waitForElementPresent(locatorname);
			we = driver.findElement(By.linkText(locatorname));
	     }catch(NoSuchElementException e){
		    System.out.println("-----:(-----");
	    }
		return we;
	}
	
	public Select select(String locatorname) {
		Select we=null;
//		Select selectelement=null
		try{
			//this.waitForElementPresent(locatorname);
			 we = new Select(driver.findElement(By.xpath(locatorname)));
	     }catch(NoSuchElementException e){
		    System.out.println("-----:(-----");
	    }
		return we;
	}
	
	
	
	
	public List<WebElement> whats(String locatorname){
		return driver.findElements(By.xpath(locatorname));
	}
	
	public void waitForElementPresent(String locatorname){
		waiter.waitForElementPresent(locatorname);
	}
	
	public void waitForElementIsEnable(String locatorname){
		waiter.waitForElementIsEnable(locatorname);
	}
	
	
	public WebElement whatCSS(String locatorname) {
		WebElement we=null;
		try{
			//this.waitForElementPresent(locatorname);
			we = driver.findElement(By.cssSelector(locatorname));
	     }catch(NoSuchElementException e){
		    System.out.println("-----:(-----");
	    }
		return we;
	}
	
	
	public void waitFor(long timeout){
		waiter.waitFor(timeout);
	}
	
}
