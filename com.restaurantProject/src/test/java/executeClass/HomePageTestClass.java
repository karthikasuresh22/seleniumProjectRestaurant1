package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;

public class HomePageTestClass extends BaseClass {
	
	LoginPage lp;
	HomePage hp;
	
  @Test(priority=1,groups = {"group-1"})
  public void verifyTheProductTabIsDisplyedOrNot() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  lp.login();

	  Boolean actual=hp.isProductTabDisplayed();
	  Assert.assertTrue(actual);
	  	  
  }
  
  @Test(priority=2,groups = {"group-1"})
  public void verifyTheD4StoreIsDisplyedOrNot() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  lp.login();

	  Boolean actual=hp.isd4StoreDisplayed();
	  Assert.assertTrue(actual);
	  	  
  }
  
  @Test(priority=3,groups = {"functional"})
  public void verifyTheLogOutButtonIsWorkingFineOrNot() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  lp.login();
	  
	  hp.clickToLogoutButton();
	  
	  String expected="https://qalegend.com/restaurant/logi";
	  String actual=lp.geturlOfCurrentPage();
	  Assert.assertEquals(actual, expected);
	  	  	  
  }
}
