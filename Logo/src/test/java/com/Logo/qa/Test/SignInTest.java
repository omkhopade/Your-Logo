package com.Logo.qa.Test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Logo.qa.Base.TestBase;
import com.Logo.qa.Pages.VerifyHomePage;
import com.Logo.qa.Pages.verifySignInpage;
import com.Logo.qa.TestUtils.testUtils;

public class SignInTest  extends TestBase{
	
	VerifyHomePage verifyhomepage;
	verifySignInpage verifysign;

	
	public SignInTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		
		Installation();
		verifyhomepage = new VerifyHomePage();
		verifysign = new verifySignInpage();
		verifysign=verifyhomepage.signInPage();
		
	}
	
	@Test(priority = 1)
	public void getTitleTest() throws IOException
	{
		SoftAssert sa= new SoftAssert();
		String title=verifysign.getTitle();
		sa.assertEquals(title, "Login - My Store", "Title of login page is missing");
	}
	
	@Test(priority = 2)
	public void errorValidation()
	{
		SoftAssert sa= new SoftAssert();
		String messege=verifysign.validationMessage();
		sa.assertEquals(messege, "Invalid email address.","Wrong Error messege display");
	}
	
	@Test(priority = 3)
	public void createAccountTest()
	{
		verifysign.createAccount(pro.getProperty("emailid"));
		
	}
	
	@AfterMethod
	public void tearOff() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
}
