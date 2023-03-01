package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ProductPage;
import extendReport.TestListener;
@Listeners(TestListener.class)
public class ProductPageTestClass extends BaseClass {
	
	LoginPage lp;
	HomePage hp;
	ProductPage pp;
	String code;
	
  @Test(priority=1,groups = {"group-1"})
  public void verifyTheProductPageIsOpenedWhileClickingOnProducTab() throws IOException {
	  
	 TestListener.getTestInstance().get().assignCategory("smoke");
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  pp=new ProductPage(driver);
	  lp.login();
	  hp.clickProductTab();
	  
	  Boolean actual=pp.isProductTypeTextDisplayed();
	  Assert.assertTrue(actual);	  
  }
  
  @Test(priority=2,groups = {"add"})
  public void verifyToAddNewProduct() throws IOException, InterruptedException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  pp=new ProductPage(driver);
	  lp.login();

	  hp.clickProductTab();
	  pp.addProduct();
	 /* pp.clickToAddProductButton();
	  pp.selectTypeFromDropDown();
	  code=pp.enterCode();
	  pp.enterProductName(pp.readProductName(3, 1));
	  pp.enterPrice(pp.readPrice(4, 1));
	  pp.enterTax(pp.readTax(5, 1));
	  pp.chooseImageFromResourses(System.getProperty("user.dir")+"\\src\\main\\resources\\falooda image.jpg");
	  pp.clickToSubmitButton();
	  pp.refreshPage();*/
	  pp.enterTheNameToBeSearch("Arabian Falooda");
	  pp.refreshPage();
	  
	  Boolean actual=pp.isProductNameArabianFaloodaDisplayed();
	  Assert.assertTrue(actual);	  
  }
  @Test(priority=3,groups = {"search"})
  public void verifySearchFuctionalityByUsingProductName() throws IOException, InterruptedException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  pp=new ProductPage(driver);
	  lp.login();

	  hp.clickProductTab();
	  pp.addProduct();
	  pp.enterTheNameToBeSearch(pp.readProductName(3, 1));
	  
	  String expected="Arabian Falooda";
	  String actual=pp.getProductName();
	  Assert.assertEquals(actual, expected);	  
  }
  
  @Test(priority=4,groups = {"search"})
  public void VerifySearchFunctionalityByProductCode() throws IOException, InterruptedException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  pp=new ProductPage(driver);
	  lp.login();

	  hp.clickProductTab();
	  code=pp.addProduct();
	  pp.enterTheNameToBeSearch(code);
	  
	  Boolean actual=pp.isproductCodeIsDisplayedOrNot();
	  Assert.assertTrue(actual);
	  
  }
  @Test(priority=5,groups = {"edit"})
  public void verifyEditFunctionalityOfTheProduct() throws IOException, InterruptedException {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  pp=new ProductPage(driver);
	  lp.login();
	  
	  hp.clickProductTab();
	  pp.addProduct();
	  pp.enterTheNameToBeSearch(pp.readProductName(3, 1));
	  pp.clickToEditButton();
	  pp.enterNewTax(pp.readNewTax(6, 1));
	  pp.clickToSubmitButtonOfEditPage();
	  pp.refreshPage();
	  
	  Boolean actual=pp.isNewTaxValueDisplayed();
	  Assert.assertTrue(actual);	  
  }
  
  @Test(priority=6,groups = {"delete"})
  public void verifyDeleteFunctionalityOfTheProduct() throws IOException, InterruptedException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  pp=new ProductPage(driver);
	  lp.login();
	  
	  hp.clickProductTab();
	  code=pp.addProduct();
	  pp.enterTheNameToBeSearch("Arabian Falooda");
	  pp.clickToDeleteButton();
	  pp.clickToDeleteMessage();
	  pp.refreshPage();
	  pp.enterTheNameToBeSearch(code);
	  
	  String expected="No matching records found";
	  String actual=pp.getTheMessageDisplayedWhileSearchingAfterDeletingProduct();
	  Assert.assertEquals(actual, expected);
	  	  
  }
 
}
