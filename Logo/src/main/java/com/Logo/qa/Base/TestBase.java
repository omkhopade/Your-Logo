package com.Logo.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Logo.qa.TestUtils.testUtils;

public class TestBase {

	
	public static Properties pro;
	public static  WebDriver driver;
	public static WebDriverWait wait;
	
	public TestBase()
	{
		try {
			
	
		pro= new Properties();
		FileInputStream file= new FileInputStream("D:\\Selenium\\Automation Testing\\Logo\\src\\main\\java\\com\\Logo\\qa\\Configure\\config.properties");   
		try {
			pro.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}catch (FileNotFoundException e) {
			// TODO: handle exception
		}
		
	}
	
	public void Installation()
	{
		if(pro.getProperty("Browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();   // ChromeDriver class extends to RemoteWebDriver class which implements WebDriver and javaScriptsExecuter Interface
			
		}
		else if(pro.getProperty("Browser").equals("fireFox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\Drivers\\geckodriver.exe");
			driver =new FirefoxDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(testUtils.implicitlywait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(testUtils.pageload, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(pro.getProperty("url"));
	}
}
