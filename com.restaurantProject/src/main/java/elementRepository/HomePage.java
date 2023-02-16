package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class HomePage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities ();
	ExplicitWaitClass exp=new ExplicitWaitClass();
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//*[text()='Product'])[1]")
	WebElement productTab;
	
	@FindBy(xpath="(//*[text()='D4'])[1]")
	WebElement d4store;
	
	@FindBy(xpath="//a[@title='Logout']")
	WebElement logoutButton;
	
	public Boolean isProductTabDisplayed() {
		return gu.isDisplayedMethod(productTab);		
	}
	
	public void clickProductTab() {
		gu.clickAnElement(productTab, driver);
	}

	public Boolean isd4StoreDisplayed() {
		return gu.isDisplayedMethod(d4store);		
	}
	public void clickToLogoutButton() {
		gu.clickElement(logoutButton);
			
	}
	
	
}
