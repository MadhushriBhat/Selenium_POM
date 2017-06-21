package com.madhu.uiautomation.uiactions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.madhu.uiautomation.testbase.TestBase;

public class Homepage extends TestBase{
	
	public static final Logger log = Logger.getLogger(Homepage.class.getName());

	WebDriver driver;
	@FindBy(id="userNavLabel")
	WebElement user;


	//@FindBy(linkText="Logout")
	//WebElement logOut;

	@FindBy(xpath=".//*[@id='userNav-menuItems']/a[1]")
	WebElement myProfilelink;		

	@FindBy(xpath=".//*[@id='userNav-menuItems']/a[2]")
	WebElement mySettingslink;

	@FindBy(xpath=".//*[@id='userNav-menuItems']/a[3]")
	WebElement developerConsolelink;

	@FindBy(xpath=".//*[@id='userNav-menuItems']/a[5]")
	WebElement logOut;




	public Homepage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	public String getLoggedUsername(){
        waitForElement(driver,25,user);
        log.info("waiting for Home Page load");
		log.info("Logged User Name is "+ user.getText());
		return(user.getText());

	}


	public void clickUserdropdownOptions(String choice){

		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		user.click();
		if(choice.equalsIgnoreCase("my profile")){
			myProfilelink.click();
		}
		else if(choice.equalsIgnoreCase("my settings")){
			mySettingslink.click();
		}
		else if (choice.equalsIgnoreCase("developer console")){
			developerConsolelink.click();
		}
		else if(choice.equalsIgnoreCase("logout")){
			logOut.click();

		}
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}
	
	
	
	public void log(String data){
		log.info(data);
		Reporter.log(data);
		
	}
}
