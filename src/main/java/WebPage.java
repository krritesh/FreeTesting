
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WebPage extends Base{
	
//creating pageObject for signIn class
	 	@FindBy(linkText = "Your trips")
	    static WebElement tripsLink;

	    @FindBy(id = "SignIn")
	    static WebElement signInLink;

	    @FindBy(id = "signInButton")
	    static WebElement signInBtn;

	    public WebPage(WebDriver driver) {
	    	PageFactory.initElements(driver, this);
	    }
	  //creating signInPage method to perform action on web element
	    public  void signInPage(WebDriver driver) {
	    	
	    	tripsLink.click();
	    	waitFor(9000);
	    	signInLink.click();
	    	waitFor(9000);
	    	
	    	driver.switchTo().frame("modal_window");
	    	signInBtn.click();
	    	
	    }
	    
	  //creating pageObject  for HotelBooking class
	    @FindBy(linkText = "Hotels")
		static WebElement hotelLink;

		@FindBy(id = "Tags")
		static WebElement localityTextBox;
		
		@FindBy(xpath="//ul[@id='ui-id-1']")
		static WebElement localityName;

		@FindBy(id = "SearchHotelsButton")
		static WebElement searchButton;
		
		@FindBy(xpath=".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[6]/td[1]/a")
		static WebElement checkInDate;
		
		@FindBy(xpath=".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[1]/td[2]/a")
		static WebElement checkOutDate;

		@FindBy(id = "travellersOnhome")
		static WebElement travellerSelection;
	    
		//creating HotelBookingPage method to perform action on web element
		
		public void HotelBookingPage() {
	    	
	    	hotelLink.click();
	    	waitFor(5000);
	    	
	    	localityTextBox.clear();
	    	localityTextBox.sendKeys("Indiranagar, Bangalore");
	    	waitFor(5000);
	    	
	    	List<WebElement> originOptions = localityName.findElements(By.tagName("a"));
			originOptions.get(0).click();
			
			waitFor(5000);
			checkInDate.click();//here added date for checkIn
			waitFor(3000);
			checkOutDate.click();//here added date for checkOut
		
			waitFor(5000);
	    	new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
	    	
	    	waitFor(5000);
	    	searchButton.click();	//all fields filled in. Now click on searchButton
	    }
		  //creating pageObject  for flightBooking class
	    @FindBy(id = "OneWay")
	    private static WebElement oneWayLink;

	    @FindBy(id = "FromTag")
	    private static WebElement fromTag;

	    @FindBy(id = "ui-id-1")
	    private static WebElement fromName;

	    @FindBy(id = "ToTag")//Now id value is changed
	    private static WebElement toTag;

	    @FindBy(id = "ui-id-2")
	    private static WebElement toname;
	    
	    @FindBy(xpath = "//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[1]/td[2]/a")//added xpath for date 1 may 2018
	    private static WebElement searchDate;

	    @FindBy(id = "SearchBtn")
	    private static WebElement searchBtn;

	    public void flightBookingPage() {
	    	oneWayLink.click();//Now click on OneWay Link
	    	waitFor(5000); 
	    	
	    	fromTag.clear();//Now clear text field before sending value
	    	fromTag.sendKeys("Bangalore");//passing from locationName
	    	waitFor(4000);
	    	List<WebElement> originOptions = fromName.findElements(By.tagName("li"));
	        originOptions.get(0).click();//click on web element which is present at zero index
	        waitFor(3000);
	        
	    	toTag.clear();//Now clear text field before sending value
	    	toTag.sendKeys("Delhi");//passing TO locationName
	    	waitFor(4000);
	    	List<WebElement> destinationOptions =toname .findElements(By.tagName("li"));
		    destinationOptions.get(0).click();//click on web element which is present at zero index
		    
		    waitFor(5000);  
	    	searchDate.click();//Now click on searchDate
	    	
	    	 waitFor(5000);
	    	searchBtn.click();//all fields filled in. Now click on search
	    	
	    }
}

