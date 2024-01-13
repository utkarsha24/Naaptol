package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductQuickViewPage {

	
	@FindBy (xpath = "//div[@id='square_Details']//h1")private List<WebElement> productname;
	@FindBy (xpath = "//span[@class='offer-price']")private WebElement price;
	@FindBy (xpath = "//span[@class='ship-price']")private WebElement Shippingcharges;
	@FindBy (xpath = "//a[@id='cart-panel-button-0']")private WebElement buyButton;
	
	public ProductQuickViewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public String getQuicViewTitle(int index) {
		
		 return productname.get(index).getText();
		
	}
	public double getPrice()
	{
		return Double.parseDouble(price.getText());
	}
	
	public void clickOnBuyButton() throws InterruptedException
	{
		Thread.sleep(1000);
		buyButton.click();
	}
	
	public double getShipingCharges()
	{
		String charges=Shippingcharges.getText();
		String [] charge=charges.split(" ");
		return Double.parseDouble(charge[1]);
	}
}
