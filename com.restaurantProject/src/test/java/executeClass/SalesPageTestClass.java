package executeClass;

import java.io.IOException;

import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.SalesPage;


public class SalesPageTestClass extends BaseClass {
	

	LoginPage lp;
	HomePage hp;
	SalesPage spc;
	
  @Test
  public void verifyTheSalesPageIsVisibleByClickingOnSalesTab() throws IOException {
	  
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  spc=new SalesPage(driver);
	 
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  spc.clickToSalesTab();
	  spc.isSalesTextDisplayed();
	  
  }
}
