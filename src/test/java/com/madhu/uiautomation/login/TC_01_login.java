package com.madhu.uiautomation.login;
import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.madhu.uiautomation.testbase.TestBase;
import com.madhu.uiautomation.uiactions.Homepage;
import com.madhu.uiautomation.uiactions.Loginpage;


public class TC_01_login extends TestBase{


	Loginpage login= new Loginpage(driver);
	Homepage home=new Homepage(driver);


	@DataProvider(name="invaliddata")
	public String[][] getInvalidData(){


		String[][] data =getData("TestData.xlsx","logininvalid");
		return data;


	}

	@DataProvider(name="validdata")
	public String[][] getValidData(){


		String[][] data =getData("TestData.xlsx","loginivalid");
		return data;


	}

	@BeforeTest
	public void setUp(){
		init();
	}


	@Test(dataProvider="validdata")
	public void login_Validcredential(String username,String password,String expname){
		login.enterLoginCrendentials(username, password);
		home=new Homepage(driver);
		String user= home.getLoggedUsername();	
		Assert.assertEquals(expname, user);
		home.clickLogout();
		
		}



	@Test(dataProvider="invaliddata")
	public void login_InvalidCredentials(String username,String password){
		String experrormsg="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		login.enterLoginCrendentials(username, password);
		String errormsg=login.getInvalidloginText();
		Assert.assertEquals(errormsg.trim(),experrormsg );
	}


	@Test
	public void login_Withoutpassword(){
	String expmsg="";	
	login.enterLoginCrendentials("madhu@profess.com","password");	
	login.clearPassword();
	String actmsg=login.getInvalidloginText();
	Assert.assertEquals(actmsg, expmsg);
		
		
 }
	
	
	
	@AfterClass
	public void tearDown(){
		driver.close();
	}
}
