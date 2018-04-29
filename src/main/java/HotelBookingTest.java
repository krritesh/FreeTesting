
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HotelBookingTest extends Base{
	 
		WebPage spage;
		@BeforeMethod
		public void setup() {
			setDriverPath();
		}
	  	@Test 
	   	public void shouldBeAbleToSearchForHotels() {
	    		spage=new WebPage(driver);//passing driver into webpage object class 
	    		spage.HotelBookingPage(); //call HotelBookingPage method 
	   	 }
	   	@AfterMethod
		public void tearDown() {
			driver.quit();

	    }  
}

