package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//*[@class = \"btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left\"]")
	WebElement logintoapp;
	
	@FindBy(xpath="//input[contains(@name, \"email\")]")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@class = \"ui fluid large blue submit button\"]")
	WebElement loginBtn;
	
//	@FindBy(xpath="//*[contains(@title,'register on freecrm.com')]")
	@FindBy(xpath= "//*[@title=\"register on freecrm.com\"]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//*[@title=\"free crm home\"]")
	WebElement crmLogo;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		logintoapp.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new HomePage();
	}
	
}
