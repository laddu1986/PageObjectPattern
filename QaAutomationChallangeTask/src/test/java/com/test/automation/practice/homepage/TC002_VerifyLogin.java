package com.test.automation.practice.homepage;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.practice.testBase.TestBase;
import com.test.automation.practice.uiActions.HomePage;
import com.test.automation.practice.uiActions.Login;
/**
 * 
 * @author Ahmed Ali
 *
 */
public class TC002_VerifyLogin extends TestBase {

	public static final Logger log = Logger.getLogger(TC002_VerifyLogin.class.getName());
	Login login;
	String fullName = "Joe Black";
	String Email = "hf_challenge_123456@hf12345.com";
	String password = "12345678";
		

	@BeforeClass
	public void setUp() throws IOException {
		init();
	}

	@Test
	public void VerifyLogin() {
		try {
			log.info("=======started VerifyLogin Test===========");
			login = new Login(driver);
			login.LoginToUserAccount(Email, password);
			login.VerifyUserData(fullName);
			Assert.assertEquals(true, login.getLoginSuccess());
			Assert.assertEquals(true, login.verifyLogoutDisplay());
			log.info("=======finished VerifyLogin Test===========");
			getScreenShot("VerifyLogin");
		} catch (AssertionError e) {
			login.switchToDefaultContent();
			getScreenShot("VerifyLogin");
		} catch (Exception e) {
			log.info(e.fillInStackTrace().toString());
			getScreenShot("VerifyLogin");
			
		}
	}

	
	
}
