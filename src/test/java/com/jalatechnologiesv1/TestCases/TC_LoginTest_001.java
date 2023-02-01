package com.jalatechnologiesv1.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jalatechnologiesv1.pageobjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass
{

	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		logger.info("URL Opened");
		driver.get(baseURL);

		LoginPage lp=new LoginPage(driver);
		lp.setUserName(UserName);
		logger.info("Entered Username");
		lp.setPassword(Password);
		logger.info("Entered Password");
		lp.clickSumbit();
		logger.info("Clicked on login button");
		Thread.sleep(300);

		String displayMessage= driver.findElement(By.xpath("//h1[text()='Welcome to JALA Academy']")).getText();
        if(displayMessage.equals("Welcome to JALA Academy"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else
		{
			captureScreen(driver,"logintest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}

	}


	}

