package executeClass;

import java.io.IOException;

import org.testng.Assert;
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
	  lp.login();
	  spc.clickToSalesTab();

	  Boolean actual= spc.isSalesTextDisplayed();
	  Assert.assertTrue(actual);
	  
  }
}
