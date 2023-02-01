package com.jalatechnologiesv1.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EmployeeCreate {

	WebDriver ldriver;

	public EmployeeCreate(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="(//span[@class='pull-right-container'])[1]")
	@CacheLookup
	WebElement clickMenu;

	@FindBy(linkText="Create")
	@CacheLookup
	WebElement clickonCreate;

	@FindBy(id="FirstName")
	@CacheLookup
	WebElement E_FirstName;

	@FindBy(id="LastName")
	@CacheLookup
	WebElement E_LastName;

	@FindBy(id="EmailId")
	@CacheLookup
	WebElement E_Email;

	@FindBy(id="MobileNo")
	@CacheLookup
	WebElement E_MobileNo;

	@FindBy(id="rdbMale")
	@CacheLookup
	WebElement E_Gender_Male;

	@FindBy(id="rdbFemale")
	@CacheLookup
	WebElement E_Gender_Female;

	@FindBy(id="Address")
	@CacheLookup
	WebElement E_Address;

	@FindBy(id="CountryId")
	@CacheLookup
	WebElement E_Country;

	@FindBy(name="CityId")
	@CacheLookup
	WebElement E_City;

	@FindBy(xpath="//span[@class='checkmark']")
	@CacheLookup
	WebElement E_OtherCityChekboox;

	@FindBy(id="OtherCity")
	@CacheLookup
	WebElement E_OtherCityName;

	@FindBy(id="chkSkill_5")
	@CacheLookup
	WebElement E_Skill_Aws;

	@FindBy(id="chkSkill_3")
	@CacheLookup
	WebElement E_Skill_DevOps;

	@FindBy(id="chkSkill_2")
	@CacheLookup
	WebElement E_Skill_FullStackDeveloper;

	@FindBy(id="chkSkill_4")
	@CacheLookup
	WebElement E_Skill_Middleware;

	@FindBy(id="chkSkill_1")
	@CacheLookup
	WebElement E_Skill_QA_Automation;

	@FindBy(id="chkSkill_6")
	@CacheLookup
	WebElement E_Skill_Webservice;

	@FindBy(xpath="//button[@class='btn btn-success m-r-xs']")
	@CacheLookup
	WebElement E_Savebutton;

	@FindBy(xpath="//a[@class='btn btn-danger']")
	@CacheLookup
	WebElement E_Cancelbutton;

	@FindBy(id="DOB")
	@CacheLookup
	WebElement E_DOB;

	public void Clickmenu()
	{
		clickMenu.click();
	}

	public void Clickoncreate()
	{
		clickonCreate.click();
	}

	public void firstName(String FirstName)
	{
	   E_FirstName.sendKeys(FirstName);
	}

	public void lastName(String LastName)
	{
		E_LastName.sendKeys(LastName);
	}

	public void email_ID(String email)
	{
		E_Email.sendKeys(email);
	}

	public void mobile_No(String Phoneno)
	{
		E_MobileNo.sendKeys(Phoneno);
	}

	public void gender_Male()
	{
		E_Gender_Male.click();
	}

	public void gender_Female()
	{
		E_Gender_Female.click();
	}

	public void address(String address)
	{
		E_Address.sendKeys(address);
	}

	public void date_of_birth(String dd,String mm,String yy)
	{
		E_DOB.sendKeys(dd);
		E_DOB.sendKeys(mm);
		E_DOB.sendKeys(yy);

	}

	public void Country()
	{
		Select selectCountry = new Select(E_Country);
		selectCountry.selectByVisibleText("France");
	}

	public void City()
	{
		Select selectCity = new Select(E_City);
		selectCity.selectByVisibleText("Lyon");
	}

	public void otherCityCheckbox()
	{
		E_OtherCityChekboox.click();
	}

	public void otherCityName(String othercityname)
	{
		E_OtherCityName.sendKeys(othercityname);
	}

	public void skill_AWS()
	{
		E_Skill_Aws.click();
	}

	public void skill_DevOps()
	{
		E_Skill_DevOps.click();
	}

	public void skill_FullStackDeveloper()
	{
		E_Skill_FullStackDeveloper.click();
	}

	public void skill_Middleware()
	{
		E_Skill_Middleware.click();
	}

	public void skill_QA_Automation()
	{
		E_Skill_QA_Automation.click();
	}

	public void skill_Webservice()
	{
		E_Skill_Webservice.click();
	}

	public void saveButton()
	{
		E_Savebutton.click();
	}

	public void cancelButton()
	{
		E_Cancelbutton.click();
	}
}
