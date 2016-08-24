package pages;

import org.openqa.selenium.WebDriver;


import utils.Do;
import utils.regLoc;

public class HomePage {
	public WebDriver driver;
	private Do du;
	public HomePage(WebDriver driver){
		this.driver = driver;
		du=new Do(driver);
	}
	public HomePage logEmail(String email){
		du.what(regLoc.email);
		return this;
	}
	public HomePage logPassword(String password){
		du.what(regLoc.logPassword);
		return this;
	}
	public HomePage logSubmit(){
		du.what(regLoc.logbtnSubmit).click();
		return this;
	}
	public HomePage navigatetoReg(String url) throws InterruptedException{
		driver.get(url);
		return this;
	}
	
	public void clickregButton(){
		du.whatLinkText(regLoc.linkText).click();;
		
	}
}
