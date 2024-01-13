package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChecksearchDeatilsPage {

	
	
	@FindBy (xpath = "//div[@class='item_title']//a")private List<WebElement> ProductTitle;
	
	
	@FindBy (xpath = "//span[@class='offer-price']")private WebElement price;

	public ChecksearchDeatilsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	
	public String getSearchProductTitle(int index) throws InterruptedException {
		Thread.sleep(2000);
		 return ProductTitle.get(index).getText();
		
	}
	
	public double getSearchProductPrice()
	{
		return Double.parseDouble(price.getText());
	}
}