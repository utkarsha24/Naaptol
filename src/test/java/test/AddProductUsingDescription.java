package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

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
		
		@Parameters({"browser"})
		@BeforeMethod
		public void openApp(String browser) {
			driver=LaunchBrowser.browser(browser);
			
		}
	@Test
	public void verifyIfUserIsAbleToAddProductToCartUsingDescription()
	{
		test=extentreports.createTest("verifyIfUserIsAbleToAddProductToCartUsingDescription");
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
	@AfterMethod
	public void addTestStatus(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, result.getName());
		}

	}

	@AfterTest
	public void publishReports() {

		 extentreports.flush();
	   }
	
}
