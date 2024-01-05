package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaptolHomePage {

	
		@FindBy (xpath = "//a[@id='login-panel-link']")private WebElement register;
		@FindBy (xpath = "//a[text()='Track Order']")private WebElement trackOrder;
		@FindBy (xpath = "//span[@class='arrowNav']")private WebElement shoppingCategories;
		@FindBy (xpath = "//ul[@id='mainMenu_UL']//li")private List<WebElement> categories;
		@FindBy (xpath = "(//a[text()='Mobile Handsets'])[1]")private WebElement subcategories;
		@FindBy (xpath = "//input[@class='srchInput header_search_text ui-autocomplete-input']")private WebElement searchtab;
		@FindBy (xpath = "//li[@class='head']//h1") private WebElement categoryHeading;
		@FindBy (xpath = "(//a[@href='javascript:autoSuggestion.headerSearch()'])[2]")private WebElement search;
		@FindBy (xpath = "//span[@id='header_search_shopping_cart_count']")private WebElement addtocart;

		@FindBy (xpath = "(//li[@class='head'])[1]//h1")private WebElement mobileheading;
		
		public NaptolHomePage(WebDriver driver) {
			PageFactory.initElements(driver,this );
		}
		
		public void clickOnRegister() {
			register.click(); ;
		}
		
		public void clickOnTrackOrder() {
			trackOrder.click(); ;
		}
		
		public void clickOnShoppingCategories() {
			shoppingCategories.click();
		}
		
		public void selectShoppingCategories(WebDriver driver, int index) {
			Actions actions =new Actions(driver);
			actions.moveToElement(categories.get(index));
			actions.perform();
			subcategories.click();
		}
		
		public String getCategoryHeading() {
			return categoryHeading.getText();
		}
		
		public void enterInSearchTab(String value) {
			
			searchtab.sendKeys(value);
			
		}
		
		public String getMobileHeading()
		{
			return mobileheading.getText();
		}
		
		public void clickOnSearch() {
			search.click();
		}
		
		public void clickOnAddToCart() {
			addtocart.click();
		}
	}