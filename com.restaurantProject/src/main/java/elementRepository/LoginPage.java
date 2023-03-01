package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class LoginPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities ();
	ExplicitWaitClass exp=new ExplicitWaitClass();
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//h1[text()='Login']")
	WebElement loginText;
	
	@FindBy(xpath="//img[@alt='logo']")
	WebElement logo;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@class='login loginmodal-submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//span[@class='hidden-xs']")
	WebElement adminName;

	
	
	
	public Boolean isLoginTextIsDisplayed() throws InterruptedException {
		//exp.presenceOfElementLocatedWaitByXpath(driver,"//h1[text()='Login']");
		gu.addThreadSleep();
		return gu.isDisplayedMethod(loginText);
	}
	
	public String getUrlOfLoginPage() {
		exp.presenceOfElementLocatedWaitByXpath(driver,"//h1[text()='Login']");
		return gu.getCurrentUrl(driver);
	}


	public String getTextLogin() {
		exp.presenceOfElementLocatedWaitByXpath(driver,"//h1[text()='Login']");
		return gu.getTextOfAnElement(loginText);
	}
	
	
	public Boolean isLogoisplayedOrNot() {
		return gu.isDisplayedMethod(logo);
	}
	
	public void enterUserName(String data) {
		gu.typeIntoAnElement(userName,data);
	
	}
	
	public void enterPssword(String data) {
		gu.typeIntoAnElement(password, data);
	}
	
	public void clickLoginButton() {
		exp.elementToBeClickableWait(loginButton, driver);
		gu.clickElement(loginButton);
	}
	
	public String getAdminNameText() {
		return gu.getTextOfAnElement(adminName);
		
	}
	public String geturlOfCurrentPage() {
		return driver.getCurrentUrl();
		
	}
	
	public String readUserName(int row,int col) throws IOException {
		return ExcelReadClass.readStringData(row, col);
		
	}
	public String readPassword(int row,int col) throws IOException {
		return ExcelReadClass.readStringData(row, col);
		
	}
	public void login() throws IOException {
		enterUserName(readUserName(0, 1));
		enterPssword(readPassword(1, 1));
		clickLoginButton();
	}
	
	
	
	

}
