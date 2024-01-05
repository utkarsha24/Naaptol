package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductQuickViewPage {

	
	@FindBy (xpath = "//div[@id='square_Details']//h1")private WebElement productname;
	@FindBy (xpath = "//span[@class='offer-price']")private WebElement price;
	@FindBy (xpath = "//span[@class='ship-price']")private WebElement Shippingcharges;
	@FindBy (xpath = "//a[@class='red_button icon chat']")private WebElement buyButton;
	
	public ProductQuickViewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public String getProductName()
	{
		return productname.getText();
	}
	
	public String getPrice()
	{
		return price.getText();
	}
	
	public void clickOnBuyButton()
	{
		buyButton.click();
	}
	
	public String getShipingCharges()
	{
		String charges=Shippingcharges.getText();
		String [] charge=charges.split(" ");
		return charge[1];
	}
}
