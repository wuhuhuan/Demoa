package test;

import org.junit.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegPage;
import utils.Browsers;
import utils.BrowsersType;
import utils.ParseProperties;
import utils.Wu;

public class TestCase1 extends Wu{
  private WebDriver driver;
  HomePage homePage;
  RegPage regPage;
  ParseProperties data;
  @BeforeClass
  public void inital (){
	  Browsers br =new Browsers(BrowsersType.chrome);
	  driver = br.driver;
	  data = new ParseProperties(System.getProperty("user.dir")+"\\tool\\testcase1.properties");
	  System.out.println(data.getValue("url"));
	  homePage = new HomePage(driver);
	  regPage = new RegPage(driver);
	  System.out.println("beforeclas `~~~~~~~~~~~~~~~~~");
  }
  
  @Test(dataProvider = "csv")
  public void reg(String url,String FirstName,String LastName, String Dob,String Gender,String Country,String helpLanguage,String Email,String 
		  PrimaryContactNumber,String Line1,String CountryId,String Password) throws InterruptedException   {
	  homePage.navigatetoReg(url).clickregButton();
//	  regPage.regSendContent(data.getValue("FirstName"), data.getValue("LastName"), data.getValue("Dob"), data.getValue("Gender"), data.getValue("Country"), data.getValue("helpLanguage"),data.getValue("Email") , data.getValue("PrimaryContactNumber") , data.getValue("Line1"),data.getValue("CountryId") ,data.getValue("passwords") );
//	  regPage.sendFirstName(data.getValue("FirstName")).sendLastName(data.getValue("LastName")).sendDob(data.getValue("Dob")).selectGender(data.getValue("Gender")).selectCountry(data.getValue("Country"))
//		.selectHelpLanguage(data.getValue("helpLanguage")).sendEmail(data.getValue("Email")).sendContactNumber(data.getValue("PrimaryContactNumber"))
//		.sendLine1(data.getValue("Line1")).selectCountryId(data.getValue("CountryId")).sendPassword(data.getValue("Password")).ClickIsTermsSigned();
	  
	  regPage.sendFirstName(FirstName).sendLastName(LastName).sendDob(Dob).selectGender(Gender).selectCountry(Country)
		.selectHelpLanguage(helpLanguage).moveScrollBar().sendEmail(Email).sendContactNumber(PrimaryContactNumber)
		.sendLine1(Line1).selectCountryId(CountryId).sendPassword(Password).ClickIsTermsSigned();
	  
	  
  }
  @AfterClass
  public void quit(){
	  driver.quit();
  }
}
