package com.test.automation.practice.addToCartOrderProccesing;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.automation.practice.testBase.TestBase;
import com.test.automation.practice.uiActions.HomePage;
import com.test.automation.practice.uiActions.Login;
import com.test.automation.practice.uiActions.OrderProccessing;
import com.test.automation.practice.uiActions.ProductDetailsPage;
/**
 * 
 * @Ahmed Ali
 *
 */
public class TC002_OrderProccessing extends TestBase{
	Login login;
	OrderProccessing order;
	String Email = "hf_challenge_123456@hf12345.com";
	String password = "12345678";
	
	@BeforeClass
	public void setUp() throws IOException {
      init(); 
	}

	@Test
	public void VerifyOrderProccesing() {
		try {
			log.info("=======Starting OrderProccessing test========");
			login = new  Login(driver);
			login.LoginToUserAccount(Email, password);
			Thread.sleep(5000);
			order = new  OrderProccessing();
			order.womenCategory();
			order.WaitforSumbitButton();
			order.ProccedToCheckout();
			order.VerifyUserDataForOrder();
			log.info("=======Finished OrderProccessing test========");
			getScreenShot("OrderProccessing");
		} catch (Exception e) {
			System.out.println(e);
           getScreenShot("OrderProccessing");
		}
	}

//	@AfterClass
//	public void endTest() {
//      closeBrowser();
	}



