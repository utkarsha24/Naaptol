package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.LaunchBrowser;
import pom.AddProductfromDescriptionPage;
import pom.CartPage;
import pom.NaptolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;
import utility.Reports;
@Listeners(test.Listners.class)

public class AddProductUsingDescription extends BaseTest{

		ExtentReports extentreports;
		ExtentTest test;
		
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
	public void verifyIfUserIsAbleToAddProductToCartUsingDescription() throws InterruptedException 
	{
		NaptolHomePage naptolhomepage=new NaptolHomePage(driver);
		naptolhomepage.enterInSearchTab("Mobiles");
		naptolhomepage.clickOnSearch();
		
		AddProductfromDescriptionPage addToCartDescription=new AddProductfromDescriptionPage(driver);
		
		addToCartDescription.ClikOnProduct(driver, 0);
		
		
		addToCartDescription.clikOnBuyButton(driver);
		String currentTitle =driver.getCurrentUrl();
		Assert.assertTrue(currentTitle.contains("https://www.naaptol.com/smart-watches/bluetooth-calling-smart-watch-with-neckband-and-mobile-stand-sc6/p/12612081.html"));
		
		

	}
	}
