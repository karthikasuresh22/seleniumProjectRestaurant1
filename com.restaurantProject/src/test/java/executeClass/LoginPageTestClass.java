package executeClass;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.PascalCaseStrategy;

import elementRepository.LoginPage;

public class LoginPageTestClass extends BaseClass {
	
	LoginPage lp;
	
  @Test(priority=1,groups = {"group-1"})
  public void verifyTheLoginPageIsLoadedWhileHittingTheUrl() throws InterruptedException {
	  
	  lp=new LoginPage(driver);
	  
	  Boolean actual=lp.isLoginTextIsDisplayed();
	  Assert.assertTrue(actual);
	  
  }
  @Test(priority=2,groups= {"group-1"})
  public void verifyTheLogoIsDisplayedOrNot() {
	  
	  lp=new LoginPage(driver);
	    
	  Boolean actual=lp.isLogoisplayedOrNot();
	  Assert.assertTrue(actual);
	  	  
  }
  
  @Test(priority=3,dataProvider="successfullLogin",dataProviderClass=DataProviderClass.class,groups = {"login-1"})
  public void verifyTheSuccessfullLogin(String uName,String passwrd) {
	  
	  lp=new LoginPage(driver);
	  
	  lp.enterUserName(uName);
	  lp.enterPssword(passwrd);
	  lp.clickLoginButton();
	  
	  String expected="  admin Doe";
	  String actual=lp.getAdminNameText();
	  Assert.assertEquals(actual, expected);
	 
  }
  @Test(priority=4,dataProvider="unsuccessfullLogin",dataProviderClass=DataProviderClass.class,groups = {"login-2"})
  public void verifyUnSuccessfullLogin(String uName,String passwrd) throws InterruptedException {
	  
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
