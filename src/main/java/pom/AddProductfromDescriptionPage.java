package pom;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddProductfromDescriptionPage {
	
	
	@FindBy (xpath = "//span[text()='Click here to Buy']")private WebElement buybutton;

	
	public AddProductfromDescriptionPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	
	
	}
	public void clikOnBuyButton()	{
	
		buybutton.click();
	
	}
	
}

