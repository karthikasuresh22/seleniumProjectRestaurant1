package utilities;



import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	
	public void clickElement(WebElement element) {
		element.click();	
	}
	
	public void typeIntoAnElement(WebElement element,String data) {
		element.sendKeys(data);
	} 
	
	public void clearTextFromAnElement(WebElement element) {
		element.clear();	
	}
	public void submitElement(WebElement element) {
		element.submit();	
	}
	
	public String getTextOfAnElement(WebElement element) {
		return element.getText();
	}
	
	public String getTagNameOfAnElement(WebElement element) {
		return element.getTagName();
	}
	public String getCssValueOfAnElement(WebElement element,String cssValue) {
		return element.getCssValue(cssValue);
	}
	
	public String getAttrbuteValueOfAnElement(WebElement element,String attributeName) {
		return element.getAttribute(attributeName);
	}
	
	public Dimension getSizeOfAnElement(WebElement element) {
		return element.getSize();
	}
	public Point getLocationOfAnElement(WebElement element) {
		return element.getLocation();
	}
	
	public Boolean isDisplayedMethod(WebElement element) {
		return element.isDisplayed();
	}
	
	public Boolean isSelectedMethod(WebElement element) {
		return element.isSelected();
	}
	
	public Boolean isEnabledMethod(WebElement element) {
		return element.isEnabled();
	}

	public void addThreadSleep() throws InterruptedException {
		Thread.sleep(5000);
	}
	
	public void scrollToFindAnElement(WebElement element,WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public void clickAnElement(WebElement element,WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void selectByIndexFromDropDown(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectByValueFromDropDown(WebElement element,String data) {
		Select select=new Select(element);
		select.selectByValue(data);
	}
	
	public void selectByVisibleTextFromDropDown(WebElement element,String data) {
		Select select=new Select(element);
		select.selectByVisibleText(data);
	}
	
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();	
	}
	
	public String getTitle(WebDriver driver) {
		return driver.getTitle();	
	}
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void uploadImageUsingSendKeys(WebElement element,String data) {
		element.sendKeys(data);
		
	}
	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	
	


}
