package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class CustomersPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities ();
	ExplicitWaitClass exp=new ExplicitWaitClass();
	
	public CustomersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[text()='Customers']")
	WebElement customersTab;
	
	@FindBy(xpath="//button[@data-target='#AddCustomer']")
	WebElement addCustomerBtn;
	
	@FindBy(xpath="//input[@id='CustomerName']")
	WebElement customerName;
	
	@FindBy(xpath="//input[@id='CustomerPhone']")
	WebElement customerNumber;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//table[@id='Table']//tbody//tr[1]//td[1]")
	WebElement customerNameSearch;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchField;
	
	@FindBy(xpath="//table[@id='Table']//tbody//tr[1]//td[2]")
	WebElement customerNumberSearch;
	
	
	
	public void clickToCustomersTab() {
		gu.clickAnElement(customersTab, driver);
	}
	public String getUrlOfCustomersPage() {
		return gu.getCurrentUrl(driver);
	}
	public Boolean isAddCustomerBtnDisplayed() {
		return gu.isDisplayedMethod(addCustomerBtn);
	}
	public void clickToAddCustomerBtn() {
		gu.clickAnElement(addCustomerBtn, driver);
	}
	public void enterCustomerName(String data) {
		gu.typeIntoAnElement(customerName, data);
	}
	public void enterCustomerNumber(String data) {
		gu.typeIntoAnElement(customerNumber, data);
	}
	public void clickToSubmitBtn() {
		gu.clickAnElement(submitBtn, driver);
	}
	public void refreshPage() {
		gu.refreshPage(driver);
	}
	public String getTextCustomerNameSearch() {
		return gu.getTextOfAnElement(customerNameSearch);
	}
	public void enterCustomerNameToSearchField(String data) {
		gu.typeIntoAnElement(searchField, data);
	}
	public Boolean isCustomerNumberDisplayed() {
		return gu.isDisplayedMethod(customerNumberSearch);
	}
	public void addCustomer(String custmrn,String custmno) {
		clickToCustomersTab();
		enterCustomerName(custmrn);
		enterCustomerNumber(custmno);
		clickToSubmitBtn();
		
	}

}
