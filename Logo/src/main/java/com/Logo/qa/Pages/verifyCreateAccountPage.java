package com.Logo.qa.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Logo.qa.Base.TestBase;

public class verifyCreateAccountPage extends TestBase {

	@FindBy(xpath="//div[@class='alert alert-danger']/p")
	WebElement errormsg;
	
	@FindBy(xpath="//input[@type='radio']")
	WebElement gender;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	WebElement lastname;
	
	@FindBy(xpath="//span[@class='form_info' and contains(text(),'(Five characters minimum)')]")
	WebElement passfieldreq;
	
	@FindBy(xpath="//input[@id='company']")
	WebElement company;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement address;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//select[@id='id_state']")
	WebElement state;
	
	@FindBy(xpath="//input[@id='postcode']")
	WebElement zipcode;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath="//select[@id='days']")
	WebElement days;
	
	@FindBy(xpath="//select[@id='months']")
	WebElement months;
	
	@FindBy(xpath="//select[@id='years']")
	WebElement years;
	
	@FindBy(xpath = "//textarea[@id='other']")
	WebElement addinfo;
	
	@FindBy(xpath = "//input[@id='phone']")
	WebElement homephone;
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	WebElement mobilephone;
	
	@FindBy(xpath="//input[@id='alias']")
	WebElement myaddress;
	
	@FindBy(xpath="//button[@id='submitAccount']")
	WebElement register;
	
	
	
	
	
	public verifyCreateAccountPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String checkError()
	{
		register.click();
		return errormsg.getText();
	}
	
	public String passfieldreq() 
	{
		return passfieldreq.getText();
	}
	
	public void RegisterAccount(String gen, String fname, String lname, String pass, String day,String month, String year, String comp, String add, String ct , String st, String zip, String additional, String hph, String mph, String myadd)              
	{
		List<WebElement> gender = driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println(gender.size());
		
		for(int i=0;i<gender.size();i++)
		{
			if(gender.get(i).getAttribute("value").equals("1"))
			{
				System.out.println("gender");
				gender.get(i).click();
				break;
			}
			
		}
		
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		password.sendKeys(pass);
	
		company.sendKeys(comp);
				
		address.sendKeys(add);
		
		city.sendKeys(ct);
		
		Select state1= new Select(state);
		state1.selectByVisibleText(st);
		
		zipcode.sendKeys(zip);
		
		addinfo.sendKeys(additional);
		
		homephone.sendKeys(hph);
		
		mobilephone.sendKeys(mph);
		
		myaddress.sendKeys(myadd);
		
		
		
	
	}
	
	
	public String BirthDate()
	{
		Select day1= new Select(days);
		day1.selectByValue("15");
		
		Select mo= new Select(months);
		mo.selectByValue("2");
		
		Select year1= new Select(years);
		year1.selectByValue("1980");
		
		register.click();
		
	return driver.getTitle();
	}
	
	
	
}
