package com.madhu.uiautomation.uiactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class ForgotPassword {
	
	public static final Logger log =Logger.getLogger(ForgotPassword.class.getName());

	WebDriver driver;

	@FindBy(id="un")
	WebElement usrname;

	@FindBy(xpath=".//*[@id='continue']")
	WebElement sendbtn;

	@FindBy(xpath=".//*[@id='header']")
	WebElement confirmmsg;


	public ForgotPassword(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void resetPassword(String usr){
		usrname.sendKeys(usr);
		sendbtn.click();
	}

	public String  getConfirmation(){
		String msg=confirmmsg.getText();
		return msg;
	}




public void log(String data){
	log.info(data);
	Reporter.log(data);
	
}
}
