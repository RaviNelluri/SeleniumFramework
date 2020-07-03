package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;


public class LoginPage extends BasePage{
	
	@FindBy(xpath="//input[@name='username']")
	WebElement Login_username_txt;
	
	@FindBy(xpath="//input[@name='pw']")
	WebElement Login_pswd_txt;
	
	@FindBy(xpath="//input[@name='Login']")
	WebElement Login_bttn;

public LoginPage()
{
	PageFactory.initElements(driver, this);
		
}
	public void login(String username, String password)
	{
		sendkeys(Login_username_txt, username);
		sendkeys(Login_pswd_txt, password);
		click(Login_bttn);
	
	}
	

	
}
