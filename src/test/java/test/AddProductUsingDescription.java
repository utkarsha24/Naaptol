package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.LaunchBrowser;
import pom.AddProductfromDescriptionPage;
import pom.BasePage;
import pom.CartPage;
import pom.NaptolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;
import utility.Reports;
@Listeners(test.Listners.class)

public class AddProductUsingDescription extends BasePage  {

		ExtentReports extentreports;
		ExtentTest test;
		WebDriver driver;
		ProductResultPage productResultPage;
		AddProductfromDescriptionPage productDescriptionPage;
		@BeforeTest
		public void configureReport()
		{
			extentreports=Reports.generateReport();
		}
		
		@BeforeMethod
		public void openApp() {
			driver=LaunchBrowser.chrome();
			
		}
	@Test
	public void verifyIfUserIsAbleToAddProductToCartUsingDescription()
	{
		NaptolHomePage naptolhomepage=new NaptolHomePage(driver);
		naptolhomepage.enterInSearchTab("Mobiles");
		naptolhomepage.clickOnSearch();
		
		ProductResultPage productResultPage=new ProductResultPage(driver);
		
		String productTitle=productResultPage.getProductTitle(0);
		productResultPage.clickOnProduct(0);
		productResultPage.switchToPage(driver,productTitle);
		
		productDescriptionPage=new AddProductfromDescriptionPage(driver);
		productDescriptionPage.clikOnBuyButton();
		
		

	}
	}
