package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ProductPage;
import elementRepository.StorePage;

public class StorePageTestClass extends BaseClass {
	
	LoginPage lp;
	HomePage hp;
	StorePage sp;
	
  @Test(priority=1)
  public void VerifyTheStorePageIsVisibleByClickingOnStoreTab() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  sp=new StorePage(driver);
	 

	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  
	  sp.clickToStoreTab();
	  Boolean actual=sp.isStoreNameDisplayed();
	  Assert.assertTrue(actual);	  
  }
  
  @Test(priority=2)
  public void verifyToCreateAnewStore() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  sp=new StorePage(driver);
	
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  sp.clickToStoreTab();
	  sp.clickToAddStoreTab();
	  sp.enterStoreNameToTheStoreNameField(sp.readStoreName(7, 1));
	  sp.enterStoreNameToTheStoreNameField(sp.readStorePhoneNumber(8, 1));
	  sp.enterCountry(sp.readCountryName(9, 1));
	  sp.clickToSubmitButton();
	  sp.refreshPage();
	  sp.enterProductNameToSearchField(sp.readStoreName(7, 1));
 
	  String expected="Orange Store2147483647";
	  String actual=sp.getTextOfStoreName();
	  Assert.assertEquals(actual, expected);
  }
  @Test(priority=3)
  public void verifyStoreNameSearchByUsingStoreName() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  sp=new StorePage(driver);
	
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  sp.clickToStoreTab();
	  sp.enterProductNameToSearchField(sp.readStoreName(7, 1));
	  
	  String expected="Orange Store2147483647";
	  String actual=sp.getTextOfStoreName();
	  Assert.assertEquals(actual, expected);
	  
	  	  
  }
  @Test(priority=4)
  public void verifyAddStoreButtonIsVisibleOrNot() throws IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  sp=new StorePage(driver);
	
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  sp.clickToStoreTab();
	  
	  Boolean actual=sp.isaddStorEButtonDisplayed();
	  Assert.assertTrue(actual);
	  
	  
  }
  
}
