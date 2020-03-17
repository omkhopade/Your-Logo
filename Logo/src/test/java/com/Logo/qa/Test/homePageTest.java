package com.Logo.qa.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Logo.qa.Base.TestBase;
import com.Logo.qa.Pages.VerifyHomePage;

public class homePageTest  extends TestBase{

	VerifyHomePage verifyhomepage;
	public homePageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		Installation();
		verifyhomepage = new VerifyHomePage();
	}

	@Test(priority = 1)
	public void testLogo()
	{
		verifyhomepage.testlogo();
		Assert.assertTrue(true,"Logo is npot displyed");
	}

	@Test(priority = 2)
	public void selectTShirt()
	{
		verifyhomepage.selectBlouse();
	}

	@Test(priority = 3)
	public void titleTest()
	{
		String title=verifyhomepage.verifyTitle();
		Assert.assertEquals(title, "My Store");
	}

	@Test(priority = 4 )
	public void contactTest()
	{
		SoftAssert sa= new SoftAssert();
		String ph=verifyhomepage.verifyPhoneNumber();
		sa.assertEquals(ph, "0123-456-789","phone number doesn't match");
	}

	@Test(priority = 5)
	public void emptyCartTest()
	{
		SoftAssert sa= new SoftAssert();
		String cart=verifyhomepage.emptyCart();
		sa.assertEquals(cart, "0", "cart is not empty");
	}

	@Test(priority = 6)
	public void signInTest()
	{
		verifyhomepage.signInPage();
	}
	@AfterMethod
	public void tearOff() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();

	}
}
