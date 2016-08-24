
package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegPage;
import utils.Browsers;
import utils.BrowsersType;
import utils.ParseProperties;

public class NewTest {
  private WebDriver driver;
  private HomePage homePage;
  private RegPage regPage;
  public ParseProperties data=new ParseProperties(System.getProperty("user.dir")+"\\tool\\testcase1.properties");;
  
  @BeforeClass
  public void inital(){
	  Browsers br =new Browsers(BrowsersType.chrome);
	  driver = br.driver;
//	  data = new ParseProperties(System.getProperty("user.dir")+"\\tool\\testcase1.properties");
	  System.out.println(data.getValue("url"));
	  homePage = new HomePage(driver);
	  regPage = new RegPage(driver);
  }
  @Test
  public void testcase1() throws InterruptedException {
	  System.out.println(data.getValue("url"));
	  homePage.navigatetoReg(data.getValue("url"));
	  homePage.clickregButton();
	  regPage.regSendContent(data.getValue("FirstName"), data.getValue("LastName"), data.getValue("Dob"), data.getValue("Gender"), data.getValue("Country"), data.getValue("helpLanguage"),data.getValue("Email") , data.getValue("PrimaryContactNumber") , data.getValue("Line1"),data.getValue("CountryId") ,data.getValue("passwords") );
	  
	  
  }
  @AfterClass
  public void quit(){
	  driver.quit();
  }
}