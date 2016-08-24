package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.regLoc;
import utils.Do;

public class RegPage {
	private WebDriver driver;
	private Do du;
	
	public RegPage(WebDriver driver){
		this.driver = driver;
		du=new Do(driver);
	}
	
	public RegPage sendFirstName(String FirstName){
		du.what(regLoc.FirstName).sendKeys(FirstName);
		return this;
	}
	
	public RegPage sendLastName(String LastName){
		du.what(regLoc.LastName).sendKeys(LastName);
		return this;
	}
	
	public RegPage sendDob(String Dob){
		du.what(regLoc.Dob).sendKeys(Dob);;
		return this;
	}
	
	public RegPage selectGender(String Gender){
		du.select(regLoc.Gender).selectByVisibleText(Gender);
		return this;
	}
	
	public RegPage selectCountry(String Country){
		du.select(regLoc.Country).selectByVisibleText(Country);
		return this;
	}
	
	public RegPage selectHelpLanguage(String helpLanguage){
		du.select(regLoc.helpLanguage).selectByVisibleText(helpLanguage);
		return this;
	}
	
	public RegPage sendEmail(String Email){
		for(WebElement re:du.whats(regLoc.Emails)){
			re.sendKeys(Email);
		}
		return this;
	}
	
	public RegPage sendContactNumber(String ContactNumber){
		for(WebElement re:du.whats(regLoc.ContactNumber)){
			re.sendKeys(ContactNumber);
		}
		return this;
	}
	
	
	public RegPage sendLine1(String Line1){
		du.what(regLoc.Line1).sendKeys(Line1);
		return this;
	}
	
	public RegPage selectCountryId(String CountryId){
		du.select(regLoc.CountryId).selectByVisibleText(CountryId);
		return this;
	}
	
	public RegPage sendPassword(String passwords){
		for(WebElement we:du.whats(regLoc.passwords)){
			we.sendKeys(passwords);
		}
		return this;
	}
	
	public RegPage ClickIsTermsSigned(){
		du.what(regLoc.IsTermsSigned).click();
		return this;
	}
	
	public void regSubmit(){
		du.what(regLoc.regSubmit).click();
		
	}
	public RegPage moveScrollBar(){
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)", "");
		return this;
	}
	public RegPage regSendContent(String FirstName,String LastName
			,String Dob,String Gender,String Country,String helpLanguage,String Email,String PrimaryContactNumber
			,String Line1,String CountryId,String Password){
		sendFirstName(FirstName).sendLastName(LastName).sendDob(Dob).selectGender(Gender).selectCountry(Country)
		.selectHelpLanguage(helpLanguage).sendEmail(Email).sendContactNumber(PrimaryContactNumber)
		.sendLine1(Line1).selectCountryId(CountryId).sendPassword(Password);
		
		
		return this;
	}
}
