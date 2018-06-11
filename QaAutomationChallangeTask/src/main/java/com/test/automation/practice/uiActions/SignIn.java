package com.test.automation.practice.uiActions;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.test.automation.practice.testBase.TestBase;
/**
 * 
 * @Ahmed Ali
 *
 */
public class SignIn extends TestBase{
	
	public static final Logger log = Logger.getLogger(SignIn.class.getName());
	
	WebDriver driver;
	
	@FindBy(className="login")
	WebElement Login;
	
	@FindBy(id="email_create")
	WebElement email;
	
	@FindBy(id="SubmitCreate")
	WebElement Submit;
	
	@FindBy(id="customer_firstname")
	WebElement FirstName;
	
	@FindBy(id="customer_lastname")
	WebElement LastName;
	
	@FindBy(id="passwd")
	WebElement CreatePassword;
	
	@FindBy(id="days")
	WebElement Days;
	
	@FindBy(id="months")
	WebElement Months;
	
	@FindBy(id="years")
	WebElement Years;
	
	@FindBy(id="company")
	WebElement Company;

	@FindBy(id="address1")
	WebElement Address1;
	
	@FindBy(id="address2")
	WebElement Address2;
	
	@FindBy(id="city")
	WebElement City;
	
	@FindBy(id="id_state")
	WebElement State;
	
	@FindBy(id="postcode")
	WebElement Postcode;
	
	@FindBy(id="other")
	WebElement Other;
	
	@FindBy(id="phone")
	WebElement Phone;
	
	@FindBy(id="phone_mobile")
	WebElement Mobilenumber;
	
	@FindBy(id="alias")
	WebElement Alias;
	
	@FindBy(id="submitAccount")
	WebElement Submitaccount;

	@FindBy(className="account")
	WebElement Account;
	
	@FindBy(className="	info-account")
	WebElement 	Infoaccount;
	
	@FindBy(className="logout")
	WebElement 	Logout;
	
	@FindBy(xpath="//*[@id='create_account_error']/ol/li")
	WebElement AuthenticationFailed; 
	

	public SignIn(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void CreateAccount(String Email){
		Login.click();
		log("cliked on sign in and object is:-"+Login.toString());
		email.sendKeys(Email);
		log("entered email address:-"+email+" and object is "+email.toString());
		Submit.click();
		log("Click on submit:-"+Submit);
		
	}
	
   public String getInvalidLoginText(){
	   email.sendKeys("*&$#test.com");
	   log("entered email address:-"+email+" and object is "+email.toString());
	   Submit.click();
		log("erorr message is:-"+AuthenticationFailed.getText());
		return AuthenticationFailed.getText();
	}

   public void UserData(String firstName, String lastName, String password, String company,String address1,String address2,
		   String city,String postcode,String other,String phone, String phone_mobile,String alias){
	    SelectGender();
		this.FirstName.sendKeys(firstName);
		log("entered data to first name field and object is:-"+FirstName.toString());
		this.LastName.sendKeys(lastName);
		log("entered data to last name field and object is:-"+LastName.toString());
		CreatePassword.sendKeys(password);
		log("entered data to password field and object is:-"+CreatePassword.toString());
		ChoseDateMonthYear();
		this.Company.sendKeys(company);
		log("entered data to email field and object is:-"+Company.toString());
		this.Address1.sendKeys(address1);
		log("entered data to Address1 field and object is:-"+Address1.toString());
		this.Address2.sendKeys(address2);
		log("entered data to Address2 field and object is:-"+Address2.toString());
		this.City.sendKeys(city);
		log("entered data to City field and object is:-"+City.toString());
		ChoseSatate(State);
		this.Postcode.sendKeys(postcode);
		log("entered data to Postcode field and object is:-"+Postcode.toString());
		this.Other.sendKeys(other);
		log("entered data to Other field and object is:-"+Other.toString());
		this.Phone.sendKeys(phone);
		log("entered data to Phone field and object is:-"+Phone.toString());
		this.Mobilenumber.sendKeys(phone_mobile);
		log("entered data to Mobilenumber field and object is:-"+Mobilenumber.toString());
		this.Alias.sendKeys(alias);
		log("entered data to Alias field and object is:-"+Alias.toString());
		this.Submitaccount.click();
		log("Click on the Submitaccount Button :-"+Submitaccount.toString());
		VerifyUserData();
		
	}
   
   public boolean getRegistrationSuccess(){
		try {
			driver.findElement(By.xpath("//*[@id='center_column']/h1")).isDisplayed();
			return true;
		} catch (Exception e) {
		   return false;
		}
	}
   
   public String CreateEmail(){
		 String timestamp = String.valueOf(new Date().getTime());
	        String UserEmail = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
			return UserEmail;
	}
	
   public void SelectGender(){
	   wait = new WebDriverWait(driver, 10, 30);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2"))).click();
	   
	
	}

   public void ChoseDateMonthYear(){
	   Select select = new Select(driver.findElement(By.id("days")));
       select.selectByValue("1");
       log("Select Day :-"+select.toString());
       select = new Select(driver.findElement(By.id("months")));
       select.selectByValue("1");
       log("Select Month :-"+select.toString());
       select = new Select(driver.findElement(By.id("years")));
       select.selectByValue("2000");
       log("Select Year :-"+select.toString());
    
	}

   public void ChoseSatate(WebElement state){
	Select State = new Select(state);
	State.selectByVisibleText("Colorado");
    
	}
   public void VerifyUserData(){
	   String name = "Firstname";
       String surname = "Lastname";
	   WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
       assertEquals(heading.getText(), "MY ACCOUNT");
       assertEquals((Account).getText(), name + " " + surname);
       assertTrue((Infoaccount).getText().contains("Welcome to your account."));
       assertTrue(driver.findElement(By.className("logout")).isDisplayed());
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