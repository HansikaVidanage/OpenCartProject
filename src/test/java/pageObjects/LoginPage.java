package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="password")
	WebElement txtpwd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	////h2[text()='My Account']
	
	public void setEmail(String email) {
		
		txtEmail.sendKeys(email);
	}
	
	public void setPwd(String pw) {
		txtpwd.sendKeys(pw);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
}
