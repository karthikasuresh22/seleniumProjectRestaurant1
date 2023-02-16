package executeClass;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.PascalCaseStrategy;

import elementRepository.LoginPage;

public class LoginPageTestClass extends BaseClass {
	
	LoginPage lp;
	
  @Test(priority=4)
  public void verifyTheLoginPageIsLoadedWhileHittingTheUrl() {
	  
	  lp=new LoginPage(driver);
	  
	  Boolean actual=lp.isLoginTextIsDisplayed();
	  Assert.assertTrue(actual);
	  
  }
  @Test(priority=3)
  public void verifyTheLogoIsDisplayedOrNot() {
	  
	  lp=new LoginPage(driver);
	    
	  Boolean actual=lp.isLogoisplayedOrNot();
	  Assert.assertTrue(actual);
	  	  
  }
  
  @Test(priority=1,dataProvider="successfullLogin",dataProviderClass=DataProviderClass.class)
  public void verifyTheSuccessfullLogin(String uName,String passwrd) {
	  
	  lp=new LoginPage(driver);
	  
	  lp.enterUserName(uName);
	  lp.enterPssword(passwrd);
	  lp.clickLoginButton();
	  
	  String expected="  admin Doe";
	  String actual=lp.getAdminNameText();
	  Assert.assertEquals(actual, expected);
	 
  }
  @Test(priority=2,dataProvider="unsuccessfullLogin",dataProviderClass=DataProviderClass.class)
  public void verifyUnSuccessfullLogin(String uName,String passwrd) {
	  
	  lp=new LoginPage(driver);

	  lp.enterUserName(uName);
	  lp.enterPssword(passwrd);
	  lp.clickLoginButton();

	  Boolean actual=lp.isLoginTextIsDisplayed();
	  Assert.assertTrue(actual);

	  // Boolean actual=lp.isLogoisplayedOrNot();
	  //Assert.assertTrue(actual);
	 	  	  
  }
    
}
