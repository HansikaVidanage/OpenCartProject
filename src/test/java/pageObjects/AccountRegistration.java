package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage{
	
	public AccountRegistration(WebDriver driver) {
		
		super(driver);
		
	}
	
	@FindBy(name="firstname")
	WebElement txtFirstName;
	
	@FindBy(name="lastname")
	WebElement txtLastName;
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="telephone")
	WebElement txtTelephone;
	
	@FindBy(name="password")
	WebElement txtPwd;
	
	@FindBy(name="confirm")
	WebElement txtConfirmPwd;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chckdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement confirmationMsg;
	
	
	//actions
	//in here I passing values from testcases
	
	public void setFirstName(String fname) {

		txtFirstName.sendKeys(fname);
		
	}
	
	public void setLastName(String lname) {
		
		txtLastName.sendKeys(lname);
		
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tp) {
		txtTelephone.sendKeys(tp);
	}
	
	public void setPwd(String pw) {
		txtPwd.sendKeys(pw);
	}
	
	public void setConfirmPw(String pw) {
		txtConfirmPwd.sendKeys(pw);
	}
	
	public void clickChckedPolicy() {
		chckdPolicy.click();
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return(confirmationMsg.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
	}

}
