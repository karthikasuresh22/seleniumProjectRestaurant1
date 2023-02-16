package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;

public class HomePageTestClass extends BaseClass {
	
	LoginPage lp;
	HomePage hp;
	
  @Test(priority=1)
  public void verifyTheProductTabIsDisplyedOrNot() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);

	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();

	  Boolean actual=hp.isProductTabDisplayed();
	  Assert.assertTrue(actual);
	  	  
  }
  
  @Test(priority=2)
  public void verifyTheD4StoreIsDisplyedOrNot() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);

	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();

	  Boolean actual=hp.isd4StoreDisplayed();
	  Assert.assertTrue(actual);
	  	  
  }
  
  @Test(priority=3)
  public void verifyTheLogOutButtonIsWorkingFineOrNot() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);

	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  
	  hp.clickToLogoutButton();
	  
	  String expected="https://qalegend.com/restaurant/login";
	  String actual=lp.geturlOfCurrentPage();
	  Assert.assertEquals(actual, expected);
	  	  	  
  }
}
