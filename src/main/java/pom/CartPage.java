package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class CartPage {
	
	@FindBy (xpath = "//ul[@id='cartData']") private List<WebElement> product;
	@FindBy (xpath = "(//a[@onclick='cart.submitOrder()'])[1]") private WebElement proceedToCheckout;
	@FindBy (xpath = "//a[@class='link_Continue'][1]")private WebElement continueShopping;
	
	@FindBy (xpath = "//div[@id='cartItems']//h2//a")private List<WebElement> CartTitle;
	@FindBy (xpath = "//ul[@id='cartData']//li[3]")private List<WebElement>CartPrice;
	@FindBy (xpath = "//ul[@id='cartData']//li[4]")private List<WebElement>CartShiping;
	@FindBy (xpath = "//ul[@id='cartData']//li[5]")private List<WebElement>CartAmount;
	@FindBy (xpath = "(//ul[@id='cartTotal']//label)[1]")private WebElement CartTotal;
	
	
	
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
	
	
	public double getCartPrice(int index)
	{
		return Double.parseDouble(CartPrice.get(index).getText().substring(3));
	}
	
	public String getProductTitle(int index, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOf(proceedToCheckout));
		return CartTitle.get(index).getText();
	}
	
	public double getCartshipingCharges(int index)
	{
		return Double.parseDouble(CartShiping.get(index).getText().substring(3));
	}
	
	public double getCartAmount(WebDriver driver,int index) throws InterruptedException
	{
		Thread.sleep(5000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		//wait.until(ExpectedConditions.visibilityOf(CartAmount));
		return Double.parseDouble(CartAmount.get(index).getText());
	}
	
	public double getCartTotal()

	{
	
		return Double.parseDouble(CartTotal.getText().substring(3).replace(",",""));
	}
	
	
}
