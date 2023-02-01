package com.jalatechnologiesv1.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jalatechnologiesv1.pageobjects.EmployeeCreate;
import com.jalatechnologiesv1.pageobjects.LoginPage;
import com.jalatechnologiesv1.pageobjects.SearchPage;

public class TC_SearchTest_004 extends BaseClass {

	@Test
	public void searchData() throws InterruptedException, IOException
	{
		LoginPage lp= new LoginPage(driver);

        lp.setUserName(UserName);
        logger.info("Entered User name");
        lp.setPassword(Password);
        logger.info("Entered Password ");
        lp.clickSumbit();
        logger.info("clicked submit button");

        SearchPage sp=new SearchPage(driver);
        sp.Clickmenu();
        logger.info("Employee Clicked on  Menu");
        sp.Clicksearch();
        logger.info("Employee Selected Search tab");
        sp.enterSerachName("Sowmya");
        logger.info("Employee searched Name");
        sp.clickSerachbutton();
        logger.info("Employee Clicked on Searchbutton");
        Thread.sleep(300);
        sp.clickEditbutton();
        logger.info("Employee clicked eidt Button");
        Thread.sleep(300);

        EmployeeCreate updateE=new EmployeeCreate(driver);
        updateE.lastName("Kim");
        logger.info("Employee Uodated Lastname");
        updateE.address("door No :49,Madanapalli,AP,India");
        logger.info("Employee Updated Address");
        updateE.gender_Female();
        logger.info("Employee Updated Gender");
        updateE.skill_AWS();
        logger.info("Employee Updated Skills");
        updateE.skill_QA_Automation();
        logger.info("Employee Updated Skills");
        sp.clickUpdatebutton();
        logger.info("Employee Cliked on updated button");
        Thread.sleep(300);


        Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[text()='Employee details updated successfully']"))).perform();
		String sm = driver.findElement(By.xpath("//*[text()='Employee details updated successfully']")).getText();

		if(sm.equals("Employee details updated successfully"))
		{
			Assert.assertTrue(true);
			logger.info("Employee details updated");
		}
		else
		{
			captureScreen(driver,"EmployeeCreate Test");
			Assert.assertTrue(false);
			logger.info("Employee details not updated");
		}



	}

}
