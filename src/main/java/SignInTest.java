
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest extends Base{
	WebPage spage;
		@BeforeMethod//call setDriverPath method here for start the application
		public void setup() {
			setDriverPath();
		}
   		@Test
    	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
   			spage=new WebPage(driver); //passing driver into webpage object class
    		spage.signInPage(driver);//calling signInpage method and passing driver
    	
      		String errors1 = driver.findElement(By.id("errors1")).getText();
        	Assert.assertTrue(errors1.contains("There were errors in your submission"));
     	}
    	
   		 @AfterMethod//call quit method here for close the webdriver after method execution
   		 public void tearDown() {
			driver.quit();
		} 
}
