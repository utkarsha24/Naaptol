package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	@FindBy (xpath = "//ul[@id='cartData']") private List<WebElement> product;
	@FindBy (xpath = "(//a[@onclick='cart.submitOrder()'])[1]") private WebElement proceedToCheckout;
	@FindBy (xpath = "//a[@class='link_Continue'][1]")private WebElement continueShopping;
	
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public int getNumberOfProductInCart(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOf(proceedToCheckout));
		return product.size();
}
	
	public void clickOnContinueShopping()
	{
		continueShopping.click();
	}
}