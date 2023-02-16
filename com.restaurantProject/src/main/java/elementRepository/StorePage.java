package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class StorePage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities ();
	ExplicitWaitClass exp=new ExplicitWaitClass();
	
	public StorePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[text()='Stores']")
	WebElement storeTab;
	
	@FindBy(xpath="//table[@id='Table']//th[text()='Store Name']")
	WebElement storeName;
	
	@FindBy(xpath="  //button[@class='btn btn-add btn-lg']")
	WebElement addStoreTab;
	
	@FindBy(xpath="//input[@id='StoreName']")
	WebElement storeNameField;
	
	@FindBy(xpath="//input[@id='StorePhone']")
	WebElement storePhoneNumberField;
	
	@FindBy(xpath="//input[@id='Country']")
	WebElement countryField;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//input[@aria-controls='Table']")
	WebElement searchField;
	
	@FindBy(xpath="//table[@id='Table']//tbody//tr[1]//td[1]")
	WebElement storeNamesearch;
	
	
	public void clickToStoreTab() {
		gu.clickAnElement(storeTab, driver);
	}
	public Boolean isStoreNameDisplayed() {
		return gu.isDisplayedMethod(storeName);
	}
	public void clickToAddStoreTab() {
		gu.scrollToFindAnElement(addStoreTab, driver);
		gu.clickAnElement(addStoreTab, driver);
	}
	public String readStoreName(int r,int c) throws IOException {
		return ExcelReadClass.readStringData(r, c);
	}
	public void enterStoreNameToTheStoreNameField(String data) {
		gu.typeIntoAnElement(storeNameField, data);
	}
	public String readStorePhoneNumber(int r,int c) throws IOException {
		return ExcelReadClass.readIntegerData(r, c);
	}
	public void enterStorePhoneNumber(String data) {
		gu.typeIntoAnElement(storePhoneNumberField, data);		
	}
	public String readCountryName(int r,int c) throws IOException {
		return ExcelReadClass.readStringData(r, c);		
	}
	public void enterCountry(String data) {
		gu.typeIntoAnElement(countryField, data);		
	}
	public void clickToSubmitButton() {
		gu.clickAnElement(submitBtn, driver);
	}
	public void refreshPage() {
		gu.refreshPage(driver);
	}
	public void enterProductNameToSearchField(String data) {
		gu.typeIntoAnElement(searchField, data);
		
	}
	public String getTextOfStoreName() {
		return gu.getTextOfAnElement(storeNamesearch);
	}
	public Boolean isaddStorEButtonDisplayed() {
		return gu.isDisplayedMethod(addStoreTab);
	}

}
