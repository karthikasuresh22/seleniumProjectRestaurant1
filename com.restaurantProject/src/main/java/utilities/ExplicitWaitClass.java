package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitClass {
	WebDriverWait wait;

	public void elementToBeClickableWait(WebElement element,WebDriver driver) {
		
		 wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(element));		
	}
	public void elementToBeSelectedWait(WebElement element,WebDriver driver) {
		
		 wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeSelected(element));		
	}
	
	public void presenceOfElementLocatedWaitByXpath(WebDriver driver,String locator) {

		 wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));		
	}
	public void presenceOfElementLocatedWaitByName(WebDriver driver,String locator) {

		 wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
	}
	
	public void alertPresentWait(WebDriver driver) {
		 wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.alertIsPresent());
		
	}
	
}
