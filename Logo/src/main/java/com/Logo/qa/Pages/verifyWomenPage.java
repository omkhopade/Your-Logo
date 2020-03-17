package com.Logo.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Logo.qa.Base.TestBase;

public class verifyWomenPage extends TestBase {

	
	@FindBy(xpath="//div[@id='block_top_menu']//a[contains(text(),'Women')]")
	WebElement Women;
	@FindBy(xpath="//ul[@class='submenu-container clearfix first-in-line-xs']/li/ul/li[2]/a[@title='Blouses']")
	WebElement blouses;
	@FindBy(xpath="//div[@class='product-image-container']/a[@class='quick-view']/parent :: div/a/img")
	WebElement image;
	@FindBy(xpath="//div[@class='product-image-container']/a[@class='quick-view']")
	WebElement BlQuikView;
	@FindBy(xpath="//iframe[starts-with(@id,'fancybox-frame1584')]")
	WebElement frame;
	@FindBy(xpath="//input[@type='text' and @id='quantity_wanted']")
	WebElement quantity;
	@FindBy(xpath="//button[@type='submit' and  @name='Submit']")
	WebElement addtoCart;
	@FindBy(xpath="//div[@class='button-container']/a[@title='Proceed to checkout']")
	WebElement checkout;
	@FindBy(xpath="//p[@class='cart_navigation clearfix']/a[1]")
	WebElement summeryprocess;
	@FindBy(xpath="//input[@id='email']")
	WebElement Email;
	@FindBy(xpath="//input[@id='passwd']")
	WebElement password;
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement signin;
	@FindBy(xpath="//button[@type='submit' and @name='processAddress']")
	WebElement addressProcess;
	@FindBy(xpath="//input[@id='cgv']")
	WebElement terms;
	@FindBy(xpath="//button[@name='processCarrier']")
	WebElement process1;
	@FindBy(xpath="//a[@class='bankwire']")
	WebElement paymentmode;
	@FindBy(xpath="//p[@id='cart_navigation']/button")
	WebElement confirmorder;
	
	
	
	
	
	
	public verifyWomenPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void selectDress()
	{
		Actions action= new Actions(driver);
		action.moveToElement(Women).build().perform();
		blouses.click();
		action.moveToElement(image).build().perform();
		BlQuikView.click();
	}
	
	public void addToCart(String quan, String email, String pass)
	{
		wait = new WebDriverWait(driver, 40);
		
		driver.switchTo().frame(frame);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		quantity.clear();
		quantity.sendKeys(quan);
		addtoCart.click();
		driver.switchTo().defaultContent();
		checkout.click();
		summeryprocess.click();
		Email.sendKeys(email);
		password.sendKeys(pass);
		signin.click();
		addressProcess.click();
		terms.click();
		process1.click();
		paymentmode.click();
		confirmorder.click();
		
		
		
	}
	
}
