package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProcessOfPaymentPage {
	
	
	

@FindBy (xpath = "//a[@class='red_button2']")private WebElement CheckOut;
@FindBy (xpath = "(//input[@placeholder='Enter mobile number'])[2]")private WebElement EnterMobileNo;
@FindBy (xpath = "(//input[@value='Continue'])[2]")private WebElement Continue;
@FindBy (xpath = "//input[@id='gc-registration-otp-panel-submit']")private WebElement submit;

@FindBy (xpath = "//input[@name='firstName']")private WebElement firstName;
@FindBy (xpath = "//input[@name='lastName']")private WebElement lastName;
@FindBy (xpath = "//select[@id='fktitle_id']")private WebElement title;
@FindBy (xpath = "//textarea[@id='address']")private WebElement address;
@FindBy (xpath = "//input[@id='pincode']")private WebElement pincode;
@FindBy (xpath = "//select[@id='state']")private WebElement state;
@FindBy (xpath = "//select[@id='city']")private WebElement city;
@FindBy (xpath = "//input[@id='mobile']")private WebElement MobileNo;
@FindBy (xpath = "//a[@id='addEditButton']")private WebElement addAddress;
@FindBy (xpath = "//ul[@class='verticalslider_tabs']//li")private List<WebElement> paymentOption;
@FindBy (xpath = "//a[@class='red_button_normal']")private WebElement placeOrderButton; 
@FindBy (xpath = "//span[text()=' Ship to This Address ']")private List<WebElement> shipToThisAdd; 
@FindBy (xpath = "//a[text()='Track Order']")private WebElement trackorder;
@FindBy (xpath = "//a[text()='Cancel Order']")private WebElement cancelOrder;



public ProcessOfPaymentPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}


	public void clickOnCheckOut()
	{
		CheckOut.click();
	}
	
	public void clickOnContinue()
	{
		Continue.click();
	}
	
	public void enterMobileNumber(String MobileNumber) throws InterruptedException
	{
		Thread.sleep(3000);
		EnterMobileNo.sendKeys(MobileNumber);
	}
	
	public void clickOnSubmit() throws InterruptedException
	{
		Thread.sleep(50000);
		submit.click();
	}
	
	public void selectTitle(String Title) {
		Select select=new Select(title);
		select.selectByVisibleText(Title);
	}
	
	public void enterFirstName(String FirstName) 
	{
		firstName.sendKeys(FirstName);
	}
	
	public void enterLastName(String LastName) 
	{
		lastName.sendKeys(LastName);
	
	}
	
	public void enterAddress(String Address) 
	{
		address.sendKeys(Address);

	}

	public void enterPinCode(String Pincode) 
	{
		pincode.sendKeys(Pincode);
	
	}
	
	public void enterContactNumber(String Contact) throws InterruptedException 
	{
		
		Thread.sleep(2000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
//		wait.until(ExpectedConditions.visibilityOf(MobileNo));
		MobileNo.sendKeys(Contact);
	}

	public void selectState(String State) {
		Select select=new Select(state);
		select.selectByVisibleText(State);
	}
	public void selectCity(String City) {
		Select select=new Select(city);
		select.selectByVisibleText(City);
	}
	
	public void clickOnAddAdress()
	{
		addAddress.click();
	}
	
	public void clickOnshipToThisAdd(int index)
	{
		shipToThisAdd.get(index).click();
	}
	
	public void clickOnPaymentOption(int index)
	{
		paymentOption.get(index).click();
	}

	
	public void clickOnPlaceOrder()
	{
		placeOrderButton.click();
	}
	
	public void clickOnTrackOrder()
	{
		trackorder.click();
	}

	public void clickOnCancel(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOf(cancelOrder));
		cancelOrder.click();
		
		Alert a=driver.switchTo().alert();
		a.accept();
				}

}