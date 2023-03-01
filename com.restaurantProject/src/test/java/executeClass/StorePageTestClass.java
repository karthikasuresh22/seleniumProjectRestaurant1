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
	  lp.login();
	 	  
	  sp.clickToStoreTab();
	  Boolean actual=sp.isStoreNameDisplayed();
	  Assert.assertTrue(actual);	  
  }
  
  @Test(priority=2)
  public void verifyToCreateAnewStore() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  sp=new StorePage(driver);
	
	  lp.login();
	  sp.addStore("Orange Store2147483647","9495866070" ,"india");
	  sp.refreshPage();
	  sp.enterProductNameToSearchField("Orange Store2147483647");
 
	  String expected="Orange Store2147483647";
	  String actual=sp.getTextOfStoreName();
	  Assert.assertEquals(actual, expected);
  }
  @Test(priority=3)
  public void verifyStoreNameSearchByUsingStoreName() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  sp=new StorePage(driver);
	
	  lp.login();
	  sp.addStore("Orange Store2147483647","94958660" ,"india");
	  sp.enterProductNameToSearchField("Orange Store2147483647");
	  
	  String expected="Orange Store2147483647";
	  String actual=sp.getTextOfStoreName();
	  Assert.assertEquals(actual, expected);
	  
	  	  
  }
  @Test(priority=4)
  public void verifyAddStoreButtonIsVisibleOrNot() throws IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  sp=new StorePage(driver);
	  lp.login();
	  sp.clickToStoreTab();
	  
	  Boolean actual=sp.isaddStorEButtonDisplayed();
	  Assert.assertTrue(actual);
	  
	  
  }
  
}
