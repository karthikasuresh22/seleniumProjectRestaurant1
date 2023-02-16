package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.CustomersPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.WaitersPage;


public class CustomersPageTestClass extends BaseClass {
	
	LoginPage lp;
	HomePage hp;
	CustomersPage cp;
	WaitersPage wp;
	
  @Test(priority=1)
  public void verifyTheCustomersPageIsVisibleByClickingOnCustomersUnderPeopleTab() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  cp=new CustomersPage(driver);
	  wp=new WaitersPage(driver);
	  
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  wp.clickToPeopleTab();
	  cp.clickToCustomersTab();
	  
	  String expected="https://qalegend.com/restaurant/customers";
	  String actual=cp.getUrlOfCustomersPage();
	  Assert.assertEquals(actual, expected);			  
  }
  
  @Test(priority=2)
  public void verifyAddCustomerButtonIsVisibleOrNot() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  cp=new CustomersPage(driver);
	  wp=new WaitersPage(driver);
	  
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  wp.clickToPeopleTab();
	  cp.clickToCustomersTab();
	  
	  Boolean actual=cp.isAddCustomerBtnDisplayed();
	  Assert.assertTrue(actual);
  }
  
  @Test(priority=3)
  public void verifyAddNewCustomer() throws IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  cp=new CustomersPage(driver);
	  wp=new WaitersPage(driver);
	  
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  wp.clickToPeopleTab();
	  cp.clickToCustomersTab();
	  cp.clickToAddCustomerBtn();
	  cp.enterCustomerName("satheesh");
	  cp.enterCustomerNumber("8861231434");
	  cp.clickToSubmitBtn();
	  cp.refreshPage();
	  cp.enterCustomerNameToSearchField("satheesh");
	   
	  String expected="satheesh";
	  String actual=cp.getTextCustomerNameSearch();
	  Assert.assertEquals(actual,expected);
	  
  }
  
  @Test(priority=4)
  public void verifyToSearchCustomerByUsingName() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  cp=new CustomersPage(driver);
	  wp=new WaitersPage(driver);
	  
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  wp.clickToPeopleTab();
	  cp.clickToCustomersTab();
	  cp.enterCustomerNameToSearchField("satheesh");
	  
	  String expected="satheesh";
	  String actual=cp.getTextCustomerNameSearch();
	  Assert.assertEquals(actual,expected);
	  
  }
  @Test(priority=5)
  public void verifyToSearchCustomerByUsingMobileNumber() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  cp=new CustomersPage(driver);
	  wp=new WaitersPage(driver);
	  
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  wp.clickToPeopleTab();
	  cp.clickToCustomersTab();
	  cp.enterCustomerNameToSearchField("8861231434");
	  
	  Boolean actual=cp.isCustomerNumberDisplayed();
	  Assert.assertTrue(actual);	  
  }
}
