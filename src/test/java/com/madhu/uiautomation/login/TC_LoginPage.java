package com.madhu.uiautomation.login;
import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.madhu.uiautomation.testbase.TestBase;
import com.madhu.uiautomation.uiactions.Homepage;
import com.madhu.uiautomation.uiactions.Loginpage;


public class TC_LoginPage extends TestBase{


	Loginpage login; 
	Homepage home;


	@DataProvider(name="invaliddata")
	public String[][] getInvalidData(){


		String[][] data =getData("TestData.xlsx","logininvalid");
		return data;


	}

	@DataProvider(name="validdata")
	public String[][] getValidData(){


		String[][] data =getData("TestData.xlsx","loginvalid");
		return data;


	}

	@BeforeTest
	public void setUp(){
		init();
	}
	
	@Test(dataProvider="validdata")
	public void tc01_login_ValidCredential(String username,String password,String expname)
{

		login=new Loginpage(driver);
		log.info("LoginPage initialized");
		login.enterLoginCrendentials(username, password);
		log.info("entering credential");
		home=new Homepage(driver);
		log.info("initializing HomePage object");
		String user= home.getLoggedUsername();	
		log.info("Logged in User is "+user );
		Assert.assertEquals(expname, user);
		home.clickUserdropdownOptions("logout");
		log.info("Clicking on logout ");
	}



	@Test(dataProvider="invaliddata")
	public void tc02_login_InvalidCredentials(String username,String password){
		try{
			login =new Loginpage(driver);
			String experrormsg="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
			login.enterLoginCrendentials(username, password);
			String errormsg=login.getInvalidloginText();
			Assert.assertEquals(errormsg.trim(),experrormsg );
		}
		catch(Exception e){
           getScreenShot("tc02_login_InvalidCredentials");
		}

	}


	@Test
	public void tc03_login_WithoutPassword(){
		String expmsg="Please enter your password.";	
		login.enterLoginCrendentials("madhu@profess.com","password");	
		login.clearPassword();
		String actmsg=login.getInvalidloginText();
		Assert.assertEquals(actmsg, expmsg);


	}

	public void tc04_ForgotPasswod(){
    

	}



}
