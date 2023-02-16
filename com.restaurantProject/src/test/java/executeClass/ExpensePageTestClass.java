package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.ExpensePage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.SalesPage;

public class ExpensePageTestClass extends BaseClass {
	
	LoginPage lp;
	HomePage hp;
	ExpensePage ep;
	
  @Test(priority=1)
  public void verifyExpensePageIsVisibleByClickingOnExpenseTab() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  ep=new ExpensePage(driver);
	  
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  ep.clickToExenseTab();
	  
	  String expected="Expence";
	  String actual=ep.getExpenseTextDisplayed();
	  Assert.assertEquals(actual, expected);
  }
  @Test(priority=2)
  public void verifyAddExpenseButtonIsVisibleOrNot() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  ep=new ExpensePage(driver);
	  	 
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  ep.clickToExenseTab();
	  
	  Boolean actual=ep.isAddExpenseTabDisplayed();
	  Assert.assertTrue(actual);
	  
	  
	  
  }
}
