package com.Logo.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Logo.qa.Base.TestBase;

public class VerifyHomePage extends TestBase {

	
	@FindBy(xpath="//a/img[@class='logo img-responsive']")
	WebElement logo;
	@FindBy(xpath="//span/i[@class='icon-phone']")
	WebElement phone;
	@FindBy(xpath="//a/span[contains(text(),'0')]")
	WebElement emptycart;
	@FindBy(xpath="//div[@id='block_top_menu']/ul/li/a[contains(text(),'Women')]")
	WebElement Women;
	@FindBy(xpath="//div[@id='block_top_menu']/ul/li/a[contains(text(),'Women')]/parent :: li/ul[1]/li/ul/li[2]/a[contains(text(),'Blouses')]")
	WebElement blouses;
	@FindBy(xpath="//a[@class='login']")
	WebElement SignIn;
	
	
	public VerifyHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public Boolean  testlogo()
	{
		return logo.isDisplayed();
	} 
	
	public verifyWomenPage selectBlouse()
	{
		Actions  action= new Actions(driver);
		action.moveToElement(Women).build().perform();
		blouses.click();
		return new verifyWomenPage(); 
	}
	public String  verifyPhoneNumber()
	{
		return phone.getText();
	}
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	public String  emptyCart()
	{
		 return emptycart.getText();
	}

	public verifySignInpage signInPage()

	{
		SignIn.click();
		return new verifySignInpage();
	}
}
