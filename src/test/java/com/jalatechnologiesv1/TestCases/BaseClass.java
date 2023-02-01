package com.jalatechnologiesv1.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.jalatechnologiesv1.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig=new ReadConfig();

	public String baseURL=readconfig.getApplicationURL(); // Reading Data From config.properties file
    public String UserName=readconfig.getUserName(); // Reading Data From config.properties file
    public String Password=readconfig.getPassword(); // Reading Data From config.properties file
    public static WebDriver driver;  // Created Driver object

    public static Logger logger;   // Created logger object

	   @Parameters("browser")
		@BeforeClass
		public void setup(String br)
		{
			logger = Logger.getLogger("JalaTechnologiesV1");
			PropertyConfigurator.configure("Log4j.properties");

			if(br.equals("chrome"))
			{
				//System.setProperty("webdriver.gecko.driver",readconfig.getChromePath());
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
				driver=new ChromeDriver();
				driver.manage().window().maximize();
			}
			else if(br.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxpath());
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}
			else if(br.equals("ie"))
			{
				System.setProperty("webdriver.ie.driver",readconfig.getIEpath());
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
			}

			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get(baseURL);
		}

	@AfterClass
	public void Teardown()
	{
		driver.quit();
	}

    public void captureScreen(WebDriver driver, String tname) throws IOException
    {
    	TakesScreenshot ts = (TakesScreenshot) driver;
    	File Source = ts.getScreenshotAs(OutputType.FILE);
    	File target = new File(System.getProperty("user.dir") + "/ScreenShoots/" + tname +".png");
    	FileUtils.copyFile(Source, target);
    	System.out.println("Screenshoot Taken");

    }


}
