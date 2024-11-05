package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class, groups="Datadriven")
	public void verify_loginDDT(String email, String pwd, String exp ) {
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPwd(pwd);
		lp.clickLogin();
		
		MyAccountPage ma=new MyAccountPage(driver);
		boolean targetpage=ma.isMyAccountPageDisplayed();
		
		/* data is valid - login success - test pass - logout
		 * 				   login fail - test fail
		 * 
		 * data is invalid - login success - test fail- logout
		 * 					 login fail - test pass
		 */
		
		
		if(exp.equalsIgnoreCase("valid")) {
			if(targetpage==true)
			{
				ma.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid")) {
			if(targetpage==true)
			{
				ma.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		
		}catch(Exception e) {
			Assert.fail();
		}
	}
	
}
