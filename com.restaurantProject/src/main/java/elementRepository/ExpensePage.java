package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class ExpensePage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities ();
	ExplicitWaitClass exp=new ExplicitWaitClass();
	
	public ExpensePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[text()='Expense']")
	WebElement expenseTab;
	
	@FindBy(xpath="//h3[text()='Expence']")
	WebElement expenseText;
	
	@FindBy(xpath="//button[@data-target='#AddExpence']")
	WebElement addExpenseTab;
	
	
	public void clickToExenseTab() {
		gu.clickAnElement(expenseTab, driver);
	}
	public String getExpenseTextDisplayed() {
		return gu.getTextOfAnElement(expenseText);
	}
	public Boolean isAddExpenseTabDisplayed() {
		gu.scrollToFindAnElement(addExpenseTab, driver);
		return gu.isDisplayedMethod(addExpenseTab);
	}
	

}
