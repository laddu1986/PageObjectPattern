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
public class OrderProccessing extends TestBase{

	public static final Logger log = Logger.getLogger(OrderProccessing.class.getName());
	
	
	WebDriver driver;
	
	@FindBy(linkText="Women")
	WebElement WomenCategory;
	
	@FindBy(xpath="//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")
	WebElement Product;
	
	@FindBy(xpath="//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")
	WebElement GetProduct;
	
	@FindBy(xpath="//*[@id='passwd']")
	WebElement loginPassword;
	
	@FindBy(name="processCarrier")
	WebElement ProcessCarrier;
	
	@FindBy(xpath="//li[@class='step_done step_done_last four']")
	WebElement Step1;
	
	@FindBy(xpath="//li[@id='step_end' and @class='step_current last']")
	WebElement Step2;
	
	@FindBy(xpath="//*[@class='cheque-indent']/strong")
	WebElement VerfiyOrderTextComplete;
	
	public void HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void womenCategory(){
		 wait = new WebDriverWait(driver, 10, 30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Women"))).click();
		 this.Product.click();
		 this.GetProduct.click();
	}
	
	public void WaitforSumbitButton(){
		 wait = new WebDriverWait(driver, 10, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Submit"))).click();
	}
	
	public void ProccedToCheckout(){
		 wait = new WebDriverWait(driver, 10, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("processAddress"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-cgv"))).click();
        this.ProcessCarrier.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bankwire"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart_navigation']/button"))).click();
		
	}
	
	public void VerifyUserDataForOrder(){
		 wait = new WebDriverWait(driver, 10, 30);
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        assertEquals("ORDER CONFIRMATION", heading.getText());
        assertTrue(((Step1)).isDisplayed());
        assertTrue(((Step2)).isDisplayed());
        assertTrue(((VerfiyOrderTextComplete)).getText().contains("Your order on My Store is complete."));
        assertTrue(driver.getCurrentUrl().contains("controller=order-confirmation"));
        
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
