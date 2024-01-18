package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser1;
import pom.CartPage;
import pom.ChecksearchDeatilsPage;
import pom.NaptolHomePage;
import pom.ProcessOfPaymentPage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;
import utility.Reports;

@Listeners(test.Listners.class)

public class ProcessOfPaymentTest extends BaseTest {
	
	
	ProcessOfPaymentPage processOfPaymentPage;
		NaptolHomePage naptolhomepage;
		CartPage cartPage;
		ExtentReports extentreports;
		ExtentTest test;
		ProductQuickViewPage productQuickViewPage;
		ProductResultPage productResultPage;
		ChecksearchDeatilsPage checkSearchDetailsPage;
		@BeforeTest
		public void configureReport()
		{
			extentreports=Reports.generateReport();
		}
		//@Parameters({"browser"})
		@BeforeMethod
		public void openApp() {
			driver=LaunchBrowser1.chrome();
			
		}
		
		@Test
		
		public void verifyThePaymentProcess() throws InterruptedException
		{
			test=extentreports.createTest("verifyThePaymentProcess");
			NaptolHomePage naptolhomepage=new NaptolHomePage(driver);
			naptolhomepage.enterInSearchTab("mobile");
			naptolhomepage.clickOnSearch();
			
			productResultPage =new ProductResultPage(driver);
			productResultPage.clickOnQuickView(driver, 0);
			
			productQuickViewPage = new ProductQuickViewPage(driver);
			productQuickViewPage.clickOnBuyButton();
			
			cartPage=new CartPage(driver);
			//cartPage.getCartPrice(0);
			//cartPage.getCartshipingCharges(0);
			double orderAmount=cartPage.getCartAmount(driver,0);
			Assert.assertTrue(cartPage.getCartPrice(0)+cartPage.getCartshipingCharges(0)==orderAmount);
			
			processOfPaymentPage=new ProcessOfPaymentPage(driver);
			processOfPaymentPage.clickOnCheckOut();
		
			processOfPaymentPage.enterMobileNumber("7218552342");
			processOfPaymentPage.clickOnContinue();
			processOfPaymentPage.clickOnSubmit();
			
			
			processOfPaymentPage.selectTitle("Miss.");
			processOfPaymentPage.enterFirstName("uttu");
			processOfPaymentPage.enterLastName("kedari");
			processOfPaymentPage.enterAddress("kanhe");
			processOfPaymentPage.enterPinCode("412106");
			//processOfPaymentPage.selectState("MAHARASHTRA");
			//processOfPaymentPage.selectCity("MAVAL");
			processOfPaymentPage.enterContactNumber("7218552342");
			
			processOfPaymentPage.clickOnAddAdress();
			
			processOfPaymentPage.clickOnshipToThisAdd(0);
			processOfPaymentPage.clickOnPaymentOption(0);
			processOfPaymentPage.clickOnPlaceOrder();
			
			 System.out.println(processOfPaymentPage.getProductPrice());
			 Assert.assertEquals(processOfPaymentPage.getProductPrice(),800);
			 //Assert.assertTrue(cartPage.getCartAmount(driver, 0)==processOfPaymentPage.getProductPrice());
			
			processOfPaymentPage.clickOnTrackOrder();
			processOfPaymentPage.clickOnCancel(driver);
			
			
			
			
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


