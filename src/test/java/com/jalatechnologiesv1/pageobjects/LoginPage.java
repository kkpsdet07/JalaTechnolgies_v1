package com.jalatechnologiesv1.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="UserName")
	@CacheLookup
	WebElement txtUserName;

	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(id="btnLogin")
	@CacheLookup
	WebElement btnLogin;



	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}

	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}

	public void clickSumbit()
	{
		btnLogin.click();
	}

	public void dclear()
	{
		txtUserName.clear();
		txtPassword.clear();
	}
}
