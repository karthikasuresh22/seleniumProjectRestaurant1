package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class SalesPage {
	

	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities ();
	ExplicitWaitClass exp=new ExplicitWaitClass();
	
	public SalesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[text()='Sales']")
	WebElement salesTab;
	
	@FindBy(xpath="//h3[text()='Sales']")
	WebElement salesText;
	
	public void clickToSalesTab() {
		gu.clickAnElement(salesTab, driver);
	}
	public Boolean isSalesTextDisplayed() {
		return gu.isDisplayedMethod(salesText);
		
	}

}
