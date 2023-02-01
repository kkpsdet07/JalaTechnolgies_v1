package com.jalatechnologiesv1.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jalatechnologiesv1.pageobjects.EmployeeCreate;
import com.jalatechnologiesv1.pageobjects.LoginPage;

public class TC_EmployeeCreate_002 extends BaseClass
{
	@Test
	public void addNewEmployee() throws InterruptedException, IOException
	{
        LoginPage lp= new LoginPage(driver);

        lp.setUserName(UserName);
        logger.info("Entered User name");
        lp.setPassword(Password);
        logger.info("Entered Password ");
        lp.clickSumbit();
        logger.info("clicked submit button");

        Thread.sleep(300);

        EmployeeCreate ec=new EmployeeCreate(driver);
        ec.Clickmenu();
        logger.info("Clicked on Menu Button");
        Thread.sleep(300);
        ec.Clickoncreate();
        logger.info("Clicked on Create Employee URL");
        Thread.sleep(300);
        ec.firstName("Kiran");
        logger.info("Employee First Name Provided");
        ec.lastName("Abbavaram");
        logger.info("Employee Last Name Provided");
        ec.email_ID("kiran@gighradius.com");
        logger.info("Employee Email Provided");
        ec.mobile_No("9989786576");
        logger.info("Employee Mobile Number Provided");
        ec.date_of_birth("22", "10", "1991");
        logger.info("Employee Date of Birth Provided");
        ec.gender_Male();
        logger.info("Employee Selected Gender");
        ec.address("Door:42, Sanipaya, Rajampet, Annammaya(dt), Andhra Pradesh,India");
        logger.info("Employee Address Provided");
        ec.Country();
        logger.info("Employee Selcted Country");
        Thread.sleep(100);
        /*ec.City();
        logger.info("Employee Selcted City");*/
        ec.otherCityCheckbox();
        Thread.sleep(100);
        ec.otherCityName("Kadapa");
        logger.info("Employee Entered Other City");
        ec.skill_AWS();
        logger.info("Employee Selected Skill as AWS");
        ec.skill_QA_Automation();
        logger.info("Employee Selected Skill as QA_Automation");
        ec.skill_FullStackDeveloper();
        logger.info("Employee Selected Skill as FullStackDeveloper");
        Thread.sleep(100);
		ec.saveButton();

		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[@class='toast-title']"))).perform();
		String sm = driver.findElement(By.xpath("//div[@class='toast-title']")).getText();

		if(sm.equals("Employee details saved successfully"))
		{
			Assert.assertTrue(true);
			logger.info("Employee Crete Test Case is Passed");
		}
		else
		{
			captureScreen(driver,"EmployeeCreate Test");
			Assert.assertTrue(false);
			logger.info("Employee Create Test Case is Failed");
		}

	}


}
