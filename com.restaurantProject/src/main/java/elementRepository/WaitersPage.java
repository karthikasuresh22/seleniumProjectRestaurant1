package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class WaitersPage {
	

	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities ();
	ExplicitWaitClass exp=new ExplicitWaitClass();
	
	public WaitersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[text()='People']")
	WebElement peopleTab;
	
	@FindBy(xpath="//*[text()='Waiters']")
	WebElement WaitersTab;
	
	@FindBy(xpath="//th[text()='Waiter Name']")
	WebElement waiterNameText;
	
	@FindBy(xpath="//button[@data-target='#AddWaiter']")
	WebElement addWaiterBtn;
	
	@FindBy(xpath="//input[@id='WaiterName']")
	WebElement waiterName;
	
	@FindBy(xpath="//input[@id='WaiterPhone']")
	WebElement waiterPhoneNumber;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchField;
	
	@FindBy(xpath="//table[@id='Table']//tbody//tr[1]//td[1]")
	WebElement waiterNameSearch;
	
	@FindBy(xpath="//table[@id='Table']//tbody//tr[1]//td[2]")
	WebElement waiterNumberSearch;
	
	
	
	public void clickToPeopleTab() {
		gu.clickAnElement(peopleTab, driver);
	}
	
	public void clickToWaiterTab() {
		gu.clickAnElement(WaitersTab, driver);		
	}
	
	public Boolean isWaiterNameDisplayed() {
		return gu.isDisplayedMethod(waiterNameText);
	}
	
	public Boolean isAddWaitBtnDisplayed() {
		gu.scrollToFindAnElement(addWaiterBtn, driver);
		return gu.isDisplayedMethod(addWaiterBtn);
	}
	public void clickToAddWaiterBtn() {
		gu.clickAnElement(addWaiterBtn, driver);
	}
	public void typeWaiterName(String data) {
		gu.typeIntoAnElement(waiterName, data);
	}
	public void typePhoneNumber(String data) {
		gu.typeIntoAnElement(waiterPhoneNumber, data);
	}
	public void clickToSubmitBtn() {
		gu.clickAnElement(submitBtn, driver);
	}
	public void refreshPage() {
		gu.refreshPage(driver);
	}
	public void typeToSearchField(String data) {
		gu.typeIntoAnElement(searchField, data);
	}
	public String getWaiterNameAfterSearch() {
		return gu.getTextOfAnElement(waiterNameSearch);
	}
	public String getWaiterNumberAfterSearch() {
		return gu.getTextOfAnElement(waiterNumberSearch);
	}

}
