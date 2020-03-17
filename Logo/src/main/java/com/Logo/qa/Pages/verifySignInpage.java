package com.Logo.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Logo.qa.Base.TestBase;

public class verifySignInpage  extends TestBase{

	@FindBy(id = "SubmitCreate")
	WebElement createAccount;
	@FindBy(id = "email_create")
	WebElement emailTextFiled;
	@FindBy(xpath="//div[@id='create_account_error']/ol/li")
	WebElement errormsg;

	public verifySignInpage()

	{
		PageFactory.initElements(driver, this);
	}
	
	public String  getTitle()
	{
		 return driver.getTitle();
	}
	
	public String validationMessage()
	{
		createAccount.click();
		wait= new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='create_account_error']/ol/li")));
		return errormsg.getText();
	}
	
	public verifyCreateAccountPage createAccount(String emailid)
	{
		emailTextFiled.sendKeys(emailid);
		createAccount.click();
		return new verifyCreateAccountPage();
	}
	
	
}


