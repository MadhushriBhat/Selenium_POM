package com.madhu.uiautomation.uiactions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.madhu.uiautomation.testbase.TestBase;

public class Homepage extends TestBase{

	WebDriver driver;
	@FindBy(id="userNavLabel")
	WebElement user;


	@FindBy(linkText="Logout")
	WebElement logOut;











	public Homepage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	public String getLoggedUsername(){

		return(user.getText());

	}


	public void clickLogout(){

		impWait();
		user.click();
		logOut.click();
		impWait();
	}

}
