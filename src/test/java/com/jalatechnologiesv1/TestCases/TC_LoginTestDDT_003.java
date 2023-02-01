package com.jalatechnologiesv1.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jalatechnologiesv1.pageobjects.LoginPage;
import com.jalatechnologiesv1.utilities.XLUtils;


public class TC_LoginTestDDT_003 extends BaseClass
{

	@Test(dataProvider="EmpData")
	public void empDDT(String userName, String Password) throws InterruptedException, IOException
	{
		LoginPage lp= new LoginPage(driver);

        lp.setUserName(userName);
        logger.info("Entered User name");
        lp.setPassword(Password);
        logger.info("Entered Password ");
        lp.clickSumbit();
        logger.info("clicked submit button");
        lp.dclear();

   String actutalTitel="Login";
   String dispalyTtile=driver.getTitle();


        if(actutalTitel.equals(dispalyTtile))
        {
    		driver.findElement(By.xpath("//span[@class='hidden_xs']")).click();
		     logger.info("Login Test Passed");
        }
        else
        {
			captureScreen(driver,"logintest");
			logger.info("Login Test Failed");
        }


	}

	@DataProvider(name="EmpData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/jalatechnologiesv1/TestData/EmpData.xlsx";

		 int row=XLUtils.getRowCount(path, "New Employee Data");
		 int cell=XLUtils.getCellCount(path, "New Employee Data",1);

		 String empdata[][]=new String[row][cell];
		 for(int i=1; i<=row; i++)
		 {
			 for(int j=0; j<cell; j++)
			 {
				 empdata[i-1][j]=XLUtils.getCelldata(path,"New Employee Data",i,j);
			 }

		}
		return empdata;
	}
}
