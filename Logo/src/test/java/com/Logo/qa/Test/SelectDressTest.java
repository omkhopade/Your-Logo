package com.Logo.qa.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Logo.qa.Base.TestBase;
import com.Logo.qa.Pages.verifyWomenPage;

public class SelectDressTest  extends TestBase{

	verifyWomenPage women;
	
	public SelectDressTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		Installation();
		women = new verifyWomenPage();
	}
	
	@Test
	public void selecteDressTest()
	{
		women.selectDress();
		women.addToCart("4", pro.getProperty("email"), pro.getProperty("pass"));
	}
		
	@AfterMethod
	public void tearOff() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
}
