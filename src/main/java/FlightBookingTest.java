
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlightBookingTest extends Base{
	WebPage spage;
	
	@BeforeMethod
	public void setup() {
		setDriverPath();
	}
	@Test
	public void testThatResultsAppearForAOneWayJourney() {
		 spage=new WebPage(driver);//passing driver into webpage object class
		 spage.flightBookingPage();//calling flightBookingPage method
		 Assert.assertTrue(isElementPresent(By.className("searchSummary")));//verify that result appears for the provided journey search
	 }
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

