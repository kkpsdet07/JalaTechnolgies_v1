package com.jalatechnologiesv1.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver ldriver;

	public SearchPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="(//span[@class='pull-right-container'])[1]")
	@CacheLookup
	WebElement clickMenu;

	@FindBy(linkText="Search")
	@CacheLookup
	WebElement clickonSearch;

	@FindBy(id="Name")
	@CacheLookup
	WebElement s_Name;

	@FindBy(id="btnClear")
	@CacheLookup
	WebElement s_ClearButton;

	@FindBy(id="btnSearch")
	@CacheLookup
	WebElement s_SearchButton;

	@FindBy(xpath="//a[@class='btn btn-success btn-xs']")
	@CacheLookup
	WebElement s_EditButton;

	@FindBy(xpath="//a[@class='btn btn-danger btn-xs']")
	@CacheLookup
	WebElement s_DeleteButton;


	@FindBy(xpath="//*[text()='Update']")
	@CacheLookup
	WebElement s_UpdateButton;


	public void Clickmenu()
	{
		clickMenu.click();
	}

	public void Clicksearch()
	{
		clickonSearch.click();
	}

	public void enterSerachName(String Name)
	{
		s_Name.sendKeys(Name);
	}

	public void clickSerachbutton()
	{
		s_SearchButton.click();
	}
	public void clickEditbutton()
	{
		s_EditButton.click();
	}
	public void clickDeletebutton()
	{
		s_DeleteButton.click();
	}
	public void clickUpdatebutton()
	{
		s_UpdateButton.click();
	}

}
