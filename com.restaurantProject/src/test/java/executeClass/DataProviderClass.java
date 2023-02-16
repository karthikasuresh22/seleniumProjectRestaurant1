package executeClass;


import org.testng.annotations.DataProvider;

public class DataProviderClass {
 
  @DataProvider(name="successfullLogin")
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] { "admin", "password" }  
    };
  }
  
  @DataProvider(name="unsuccessfullLogin")
  public Object[][] dp2() {
    return new Object[][] {
      new Object[] { "admin", "restauarant" },  
      new Object[] { "name", "pwd123" },
      new Object[] { "nameadmin", "password" },
    };
  }
}
