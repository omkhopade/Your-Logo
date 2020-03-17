package com.Logo.qa.Test;

import org.apache.http.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Logo.qa.Base.TestBase;
import com.Logo.qa.Pages.VerifyHomePage;
import com.Logo.qa.Pages.verifyCreateAccountPage;
import com.Logo.qa.Pages.verifySignInpage;
import com.Logo.qa.TestUtils.testUtils;

public class createAccountTest extends TestBase{
	VerifyHomePage homepage;
	verifySignInpage signin;
	verifyCreateAccountPage createaccount;
	public String  sheetname ="TestData";
	
	
	public createAccountTest() 
	{
		super();	
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		Installation();
		homepage= new VerifyHomePage();
		signin = new verifySignInpage();
		createaccount = new verifyCreateAccountPage();
		
		signin=homepage.signInPage();
		createaccount=signin.createAccount(pro.getProperty("emailid"));
	}
	
	@Test(priority = 1)
	public void geterrorMessege()
	{
		SoftAssert sa= new SoftAssert();
		String error=createaccount.checkError();
		sa.assertEquals(error, "There are 8 errors", "Wrong error messege is displayed");
	}
	
	@Test(priority = 2)
	public void passField()
	{	SoftAssert sa = new SoftAssert();
		String text=createaccount.passfieldreq();
		sa.assertEquals(text, "(Five characters minimum)");
	}
	
	@DataProvider
	public Object[][] getTestDataAccount()
	{
		Object data[][]=testUtils.getTestData(sheetname);
		return data;
	}
	@Test(priority = 3, dataProvider = "getTestDataAccount")
	public void createAccountTestData(String gen, String fname, String lname, String pass, String comp, String add, String ct, String st, String zip, String additional, String hph, String mph, String myadd )
	{
		
		//createaccount.RegisterAccount("1", "abhinav","Bindra", "omkaraa@7545", "15", "2", "1980", "amdocs", "Khandoba Mandir Vastu kaash apartments", "ahmadabaad", "Iowa","425748", "No information i want to give you sorry!!!!", "020-524741258", "9874125364", "WadgaonSheri, Bavdhan Dhankwadi 142524");
		createaccount.RegisterAccount(gen, fname, lname, pass, "15", "2", "1980", comp, add, ct, st, zip, additional, hph, mph, myadd);
		String title=createaccount.BirthDate();
		System.out.println(title);
		Assert.assertEquals(title, "My");
	
	}
					/////////Wann find some solution on integer and decimal point/////////
	
	@AfterMethod
	public void tearoff() throws InterruptedException
	{
		
		Thread.sleep(10000);
		driver.quit();
	}

}
