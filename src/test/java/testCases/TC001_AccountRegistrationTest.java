package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass{

	
	@Test(groups={"Regression", "Master"})
	public void verify_account_registration() {
		
		logger.info("***Started TC001***");
		
		try{
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("****Clicked on MyAccount link****");
		
		hp.clickRegister();
		
		AccountRegistration regpage=new AccountRegistration(driver);
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		
		
		String password=randomeAlphaNumeric();
		
		regpage.setPwd(password);
		regpage.setConfirmPw(password);
	
		
		regpage.clickChckedPolicy();
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			logger.error("Test failed..");
			logger.debug("Debug logs..");
			Assert.fail();
		}
	
		
	}
	
	
	
	
}

/**
 package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest {

	public WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		
	}
	
	@Test
	public void verify_account_registration() {
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistration regpage=new AccountRegistration(driver);
		regpage.setFirstName("abc");
		regpage.setLastName("def");
		regpage.setEmail("nuwanhansikahm@gmail.com");
		regpage.setTelephone("0762855064");
		regpage.setPwd("abc@123");
		regpage.setConfirmPw("abc@123");
		regpage.clickChckedPolicy();
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
	}
	
}

*/
