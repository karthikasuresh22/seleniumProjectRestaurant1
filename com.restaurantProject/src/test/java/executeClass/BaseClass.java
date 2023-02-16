package executeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	WebDriver driver;
	public static Properties property;
	
	public static void readProperty() throws IOException {
		 property=new Properties();
		 FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Config.properties");
		 property.load(file);
	}
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  readProperty();
	  WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	 driver.quit();
  }

}
