package com.madhu.uiautomation.testbase;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.madhu.uiautomation.excelreader.Excel_Reader;

public class TestBase {

	public static final Logger log=Logger.getLogger(TestBase.class.getName());
	public WebDriver driver;
	String browser="firefox";
	String url="https://login.salesforce.com/";
	Excel_Reader excel;
	String excelName="TestData.xlsx";


	public void init()	{

		selectBrowser(browser);
		getUrl(url);
		String log4jpath="log4j.properties";
		PropertyConfigurator.configure(log4jpath);

	}

	public void selectBrowser(String browser){

		if(browser.equals("firefox")){
			driver=new FirefoxDriver();
			log.info("Creating firefox object");
		}

		else if (browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Selenium_POM/drivers/chromedriver");
			driver = new ChromeDriver();
		}

	}

	public String[][] getData(String excelName, String sheetName) {
		String path = System.getProperty("user.dir") + "/src/main/java/com/madhu/uiautomation/data/" + excelName;
		excel = new Excel_Reader(path);
		String[][] data = excel.getDataFromSheet(sheetName, excelName);
		return data;
	}

	public void getUrl(String url){
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}
	
	public void impWait(){
		
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
	}
	public Iterator<String> getAllWindows() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		return itr;
	}


	public void waitForElement(WebDriver driver, int timeOutInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
