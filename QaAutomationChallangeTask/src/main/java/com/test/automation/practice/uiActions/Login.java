package com.test.automation.practice.uiActions;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.test.automation.practice.testBase.TestBase;
/**
 * 
 * @Ahmed Ali
 *
 */
public class Login extends TestBase{
	
	public static final Logger log = Logger.getLogger(Login.class.getName());
	
	WebDriver driver;
	
	@FindBy(className="login")
	WebElement Login;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="passwd")
	WebElement Password;
	
	@FindBy(id="SubmitLogin")
	WebElement Submit;
	
	@FindBy(className="account")
	WebElement Account;
	
	@FindBy(className="info-account")
	WebElement InfoAccount;
	
	@FindBy(className="logout")
	WebElement Logout;
	
	@FindBy(xpath="//*[@id='center_column']/div[1]/ol/li")
	WebElement AuthenticationFailed; 
	

	public Login(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void LoginToUserAccount(String Email, String password){
		WaitForLogin();
		Login.click();
		log("cliked on sign in and object is:-"+Login.toString());
		email.sendKeys(Email);
		log("entered email address:-"+email+" and object is "+email.toString());
		Password.sendKeys(password);
		log("entered password:-"+Password+" and object is "+Password.toString());
		Submit.click();
		log("Click on submit:-"+Submit);
		
	}
	
   public String getInvalidLoginText(String InavlidEmail,String InvalidPassword){
	   email.sendKeys(InavlidEmail);
	   log("entered email address:-"+email+" and object is "+email.toString());
	   Password.sendKeys(InvalidPassword);
	   log("entered password:-"+Password+" and object is "+Password.toString());
	   Submit.click();
		log("erorr message is:-"+AuthenticationFailed.getText());
		return AuthenticationFailed.getText();
	}

   public boolean getLoginSuccess(){
		try {
			driver.findElement(By.xpath("//*[@id='MainContent']/div/p")).isDisplayed();
			return true;
		} catch (Exception e) {
		   return false;
		}
	}
   
   public boolean verifyLogoutDisplay(){
		try {
			Logout.isDisplayed();
			log("logout is dispalyed and object is:-"+Logout.toString());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
   public void WaitForLogin(){
	   wait = new WebDriverWait(driver, 10, 30);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
	}
	
   public void VerifyUserData(String fullName){
	   WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
       assertEquals("MY ACCOUNT", heading.getText());
       assertEquals(fullName,((Account)).getText());
       assertTrue(((InfoAccount)).getText().contains("Welcome to your account."));
       assertTrue(((Logout)).isDisplayed());
       assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
		}
   
   public void switchToDefaultContent(){
		driver.switchTo().defaultContent();
		log("switched to the default Content");
	}
	
	public void log(String data){
		log.info(data);
		Reporter.log(data);
	}
	}