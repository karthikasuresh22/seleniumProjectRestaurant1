package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.ExpensePage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.WaitersPage;

public class WaitersPageTestClass extends BaseClass {
	

	LoginPage lp;
	HomePage hp;
	WaitersPage wp;
	
  @Test(priority=1)
  public void verifyTheWaitersPageIsVisibleByClickingOnWaiterUnderPeopleTab() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  wp=new WaitersPage(driver);
	  
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  wp.clickToPeopleTab();
	  wp.clickToWaiterTab();
	   
	  Boolean actual=wp.isWaiterNameDisplayed();
	  Assert.assertTrue(actual);	  
  }
  
  @Test(priority=2)
  public void verifyAddButtonTabIsVisibleOrNot() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  wp=new WaitersPage(driver);
	  
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  wp.clickToPeopleTab();
	  wp.clickToWaiterTab();
	  
	  Boolean actual=wp.isAddWaitBtnDisplayed();
	  Assert.assertTrue(actual);
	  
  }
  
  @Test(priority=3)
  public void verifyAddAnewWaiter() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  wp=new WaitersPage(driver);
	  
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  wp.clickToPeopleTab();
	  wp.clickToWaiterTab();
	  wp.clickToAddWaiterBtn();
	  wp.typeWaiterName("Arun");
	  wp.typePhoneNumber("9446934232");
	  wp.clickToSubmitBtn();
	  wp.refreshPage();
	  wp.typeToSearchField("Arun");
	  
	  String expected="Arun";
	  String actual=wp.getWaiterNameAfterSearch();
	  Assert.assertEquals(actual, expected);
	  
  }
  @Test(priority=4)
  public void verifyToSearchWaiterByUsingName() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  wp=new WaitersPage(driver);
	  
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  wp.clickToPeopleTab();
	  wp.clickToWaiterTab();
	  wp.typeToSearchField("Arun");
	  
	  String expected="Arun";
	  String actual=wp.getWaiterNameAfterSearch();
	  Assert.assertEquals(actual, expected);	  
  }
  
  @Test(priority=5)
  public void verifyToSearchWaiterByUsingMobileNumber() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  wp=new WaitersPage(driver);
	  
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  wp.clickToPeopleTab();
	  wp.clickToWaiterTab();
	  wp.typeToSearchField("9446934232");
	  
	  String expected="9446934232";
	  String actual=wp.getWaiterNumberAfterSearch();
	  Assert.assertEquals(actual, expected);		  
  }
}
