package com.madhu.uiautomation.uiactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.madhu.uiautomation.testbase.TestBase;

public class Loginpage extends TestBase {

     WebDriver driver;

	@FindBy(id="username")
	WebElement username;

	@FindBy(xpath=".//*[@id='password']")
	WebElement password;

	@FindBy(xpath=".//*[@id='Login']")
	WebElement login;

	@FindBy(xpath="rememberUn")
	WebElement rememberchkbox;


	@FindBy(xpath=".//*[@id='idcard-identity']")
	WebElement rememberUser;

	@FindBy(id="error")
	WebElement errormsg;


	@FindBy(id="forgot_password_link")
	WebElement  forgotpwdlink;


	public Loginpage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	public void enterLoginCrendentials(String usrname,String pwd){
		username.sendKeys(usrname);
		password.sendKeys(pwd);
		login.click();
	}

	public void clearPassword(){
		password.clear();
		login.click();
	}
	
	public String getInvalidloginText(){
		return(errormsg.getText());
	}

	public void checkRememberme(){
		rememberchkbox.click();

	}

	public String getRemeberUsername(){
		return(rememberUser.getText());
	}
	
	
	public void forgotPassword(){

		forgotpwdlink.click();
	}

public String getRemberUsername(){
	impWait();
	return(rememberUser.getText());
}

}
