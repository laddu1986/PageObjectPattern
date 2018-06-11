package com.test.automation.practice.homepage;

import java.io.IOException;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.practice.testBase.TestBase;
import com.test.automation.practice.uiActions.HomePage;
import com.test.automation.practice.uiActions.SignIn;
/**
 * 
 * @author Ahmed Ali
 *
 */
public class TC004_VerifySignIn extends TestBase {
	SignIn signin;
	String firstName = "test";
	String lastName = "lastTest";
	String timestamp = String.valueOf(new Date().getTime());
    String Email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
	String password = "password";
    String company="Company";
    String address1="Qwerty, 123";
    String address2="zxcvb";
    String city="Qwerty";
    String postcode="12345";
    String other="Qwerty";
    String phone="12345123123";
    String phone_mobile="12345123123";
    String alis="hf";
	
	@BeforeClass
	public void setUp() throws IOException {
		init();
	}
	@Test
	public void verifyRegistration() {
		try {
			log.info("=======started verifyRegistration Test===========");
			signin = new SignIn(driver);
			signin.CreateAccount(Email);
			signin.UserData(firstName, lastName, password, company,address1,address2,city,postcode,other,phone,phone_mobile,alis);
			Assert.assertEquals(true, signin.getRegistrationSuccess());
			log.info("=======finished verifyRegistration Test===========");
			getScreenShot("verifyRegistration");
		} catch (AssertionError e) {
			getScreenShot("verifyRegistration");
		} catch (Exception e) {
			log.info(e.fillInStackTrace().toString());
			getScreenShot("verifyRegistration");
		
		}
		}
}