package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ProductPage;

public class ProductPageTestClass extends BaseClass {
	
	LoginPage lp;
	HomePage hp;
	ProductPage pp;
	
  @Test(priority=1,groups = {"group-1"})
  public void verifyTheProductPageIsOpenedWhileClickingOnProducTab() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  pp=new ProductPage(driver);

	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  hp.clickProductTab();
	  
	  Boolean actual=pp.isProductTypeTextDisplayed();
	  Assert.assertTrue(actual);	  
  }
  
  @Test(priority=2,groups = {"add"})
  public void verifyToAddNewProduct() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  pp=new ProductPage(driver);

	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();

	  hp.clickProductTab();
	  pp.clickToAddProductButton();
	  pp.selectTypeFromDropDown();
	  pp.enterProductCode(pp.readProductCode(2, 1));
	  pp.enterProductName(pp.readProductName(3, 1));
	  pp.enterPrice(pp.readPrice(4, 1));
	  pp.enterTax(pp.readTax(5, 1));
	  pp.chooseImageFromResourses(System.getProperty("user.dir")+"\\src\\main\\resources\\falooda image.jpg");
	  pp.clickToSubmitButton();
	  pp.refreshPage();
	  pp.enterTheNameToBeSearch("Arabian Falooda");
	  pp.refreshPage();
	  
	  Boolean actual=pp.isProductNameArabianFaloodaDisplayed();
	  Assert.assertTrue(actual);	  
  }
  @Test(priority=3,groups = {"search"})
  public void verifySearchFuctionalityByUsingProductName() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  pp=new ProductPage(driver);

	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();

	  hp.clickProductTab();
	  pp.enterTheNameToBeSearch(pp.readProductName(3, 1));
	  
	  String expected="Arabian Falooda";
	  String actual=pp.getProductName();
	  Assert.assertEquals(actual, expected);	  
  }
  
  @Test(priority=4,groups = {"search"})
  public void VerifySearchFunctionalityByProductCode() throws IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  pp=new ProductPage(driver);

	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();

	  hp.clickProductTab();
	  pp.enterTheNameToBeSearch(pp.readProductCode(2, 1));
	  
	  String expected="56700";
	  String actual=pp.getProductCode();
	  Assert.assertEquals(actual, expected);	  
  }
  @Test(priority=5,groups = {"edit"})
  public void verifyEditFunctionalityOfTheProduct() throws IOException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  pp=new ProductPage(driver);

	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  hp.clickProductTab();
	  pp.enterTheNameToBeSearch(pp.readProductName(3, 1));
	  pp.clickToEditButton();
	  pp.enterNewTax(pp.readNewTax(6, 1));
	  pp.clickToSubmitButtonOfEditPage();
	  pp.refreshPage();
	  
	  Boolean actual=pp.isNewTaxValueDisplayed();
	  Assert.assertTrue(actual);	  
  }
  
  @Test(priority=6,groups = {"delete"})
  public void verifyDeleteFunctionalityOfTheProduct() throws IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  pp=new ProductPage(driver);

	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPssword(lp.readPassword(1, 1));
	  lp.clickLoginButton();
	  
	  hp.clickProductTab();
	  pp.enterTheNameToBeSearch(pp.readProductName(3, 1));
	  pp.clickToDeleteButton();
	  pp.clickToDeleteMessage();
	  pp.refreshPage();
	  pp.enterTheNameToBeSearch(pp.readProductName(3, 1));
	  
	  String expected="No matching records found";
	  String actual=pp.getTheMessageDisplayedWhileSearchingAfterDeletingProduct();
	  Assert.assertEquals(actual, expected);
	  	  
  }
 
}
