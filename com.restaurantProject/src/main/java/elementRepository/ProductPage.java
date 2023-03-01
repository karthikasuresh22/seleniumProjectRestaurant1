package elementRepository;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class ProductPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities ();
	ExplicitWaitClass exp=new ExplicitWaitClass();
	
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//*[text()='Product'])[1]")
	WebElement productTypeText;
	
	@FindBy(xpath="//button[text()='Add Product']")
	WebElement addProductButton;
	
	@FindBy(xpath="//select[@id='Type']")
	WebElement typeDropDown;
	
	@FindBy(xpath="//input[@id='ProductCode']")
	WebElement productCode;
	
	@FindBy(xpath="//input[@id='ProductName']")
	WebElement productName;
	
	@FindBy(xpath="//input[@id='Tax']")
	WebElement tax;
	
	@FindBy(xpath="//input[@id='Price']")
	WebElement price;
	
	@FindBy(xpath="//input[@id='ImageInput']")
	WebElement chooseFileButton;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submitButton;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchField;
	
	@FindBy(xpath="//table[@id='Table']//tbody//td[2]")
	WebElement productNameArabianFalooda;
	
	@FindBy(xpath="//table[@id='Table']//tr//td")
	WebElement productCodeValue;
	
	@FindBy(xpath="//a[@data-toggle='tooltip']")
	WebElement editButton;
	
	@FindBy(xpath="//a[@class='btn btn-default']/preceding-sibling::a[1]")
	WebElement deleteButton;
	
	@FindBy(xpath="//a[text()='Yes, delete it!']")
	WebElement deleteMessage;
	
	@FindBy(xpath="//input[@id='Tax']")
	WebElement newTax;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submitButtonOfEditPage;
	
	@FindBy(xpath="//table[@id='Table']//tbody//td[5]")
	WebElement newTaxValue;
	
	@FindBy(xpath="//td[text()='No matching records found']")
	WebElement noMatchMessage;
	
	
	
	
	public Boolean isProductTypeTextDisplayed() {
		return gu.isDisplayedMethod(productTypeText);
	}
	
	public void clickToAddProductButton() {
		gu.scrollToFindAnElement(addProductButton, driver);
		gu.clickAnElement(addProductButton, driver);
	}
	
	public void selectTypeFromDropDown() {
		gu.selectByIndexFromDropDown(typeDropDown, 1);
	}
	
	public void enterProductCode(String data) {
		gu.typeIntoAnElement(productCode, data);
	}
	
	public void enterProductName(String data) {
		gu.typeIntoAnElement(productName, data);
	}
	
	public void enterTax(String data) {
		gu.scrollToFindAnElement(tax, driver);
		gu.typeIntoAnElement(tax, data);
	}
	public void enterPrice(String data) {
		gu.scrollToFindAnElement(price, driver);
		gu.typeIntoAnElement(price, data);
	}
	
	public void chooseImageFromResourses(String path) {
		gu.scrollToFindAnElement(chooseFileButton, driver);
		//gu.uploadImageUsingSendKeys(chooseFileButton, (System.getProperty("user.dir")+"\\src\\main\\resources\\falooda image.jpg"));	
		gu.typeIntoAnElement(chooseFileButton, path);
	}
	public void clickToSubmitButton() {
		gu.scrollToFindAnElement(submitButton, driver);
		gu.clickAnElement(submitButton, driver);
	}
	public String readProductCode(int i,int j) throws IOException {
		return ExcelReadClass.readIntegerData(i, j);
	}
	public String readProductName(int i,int j) throws IOException {
		return ExcelReadClass.readStringData(i, j);
	}
	public String readPrice(int i,int j) throws IOException {
		 return ExcelReadClass.readIntegerData(i, j);
	}
	public String readTax(int i,int j) throws IOException {
		return ExcelReadClass.readIntegerData(i, j);
	}
	public void enterTheNameToBeSearch(String data) {
		gu.typeIntoAnElement(searchField, data);
	}
	public Boolean isProductNameArabianFaloodaDisplayed() {
		return gu.isDisplayedMethod(productNameArabianFalooda);
	}
	public void refreshPage() {
		gu.refreshPage(driver);
	}
	public String getProductName() {
		//exp.presenceOfElementLocatedWaitByXpath(driver, "By.xpath(getProductCode(//table[@id='Table']//tbody//td[2]))");
		return gu.getTextOfAnElement(productNameArabianFalooda);
	}
	
	public Boolean isproductCodeIsDisplayedOrNot() {
		return gu.isDisplayedMethod(productCodeValue);
	}
	
	public void clickToEditButton() {
		gu.clickAnElement(editButton, driver);
	}
	
	public void clickToDeleteButton() {
		gu.clickAnElement(deleteButton, driver);
	}
	
	public void enterNewTax(String data) {
		gu.clearTextFromAnElement(newTax);
		gu.typeIntoAnElement(newTax, data);
	}
	public String readNewTax(int i,int j) throws IOException {
		return ExcelReadClass.readIntegerData(i, j);
	}
	
	public void clickToSubmitButtonOfEditPage() {
		gu.scrollToFindAnElement(submitButtonOfEditPage, driver);
		gu.clickAnElement(submitButtonOfEditPage, driver);
	}
	public Boolean isNewTaxValueDisplayed() {
		return gu.isDisplayedMethod(newTaxValue);
	}
	public void clickToDeleteMessage() {
		gu.clickAnElement(deleteMessage, driver);
	}
	public String getUrlOfProductPage() {
		return gu.getCurrentUrl(driver);		
	}
	
	public String getTheMessageDisplayedWhileSearchingAfterDeletingProduct() {
		exp.presenceOfElementLocatedWaitByXpath(driver,"//td[text()='No matching records found']");
		return gu.getTextOfAnElement(noMatchMessage);
	}
	public String enterCode() throws InterruptedException
	{   
		gu.addThreadSleep();
		gu.typeIntoAnElement(productCode,gu.get_autogeneratedCode());
		return gu.get_autogeneratedCode();
		
	}
	public String addProduct() throws IOException, InterruptedException {
		
		clickToAddProductButton();
		selectTypeFromDropDown();
		String code=enterCode();
		enterProductName(readProductName(3, 1));
		enterPrice(readPrice(4, 1));
		enterTax(readTax(5, 1));
		chooseImageFromResourses(System.getProperty("user.dir")+"\\src\\main\\resources\\falooda image.jpg");
		clickToSubmitButton();
		refreshPage();
		return code;
	}
	
	

}
