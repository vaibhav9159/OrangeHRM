package com.hrm.qa.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.BeforeClass;

import com.hrm.qa.utilties.Utils;
import com.hrm.qa.Listeners.WebEventListener;
import 	org.apache.logging.log4j.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener eventListener ;
	public static EventFiringWebDriver eventFire ;
	public static EventFiringDecorator eventFireDecorator;
	
	public static org.apache.logging.log4j.Logger log ;
	
	@BeforeClass(alwaysRun = true)
	public void logclassname() {
		String classname = getClass().getName();
		log = LogManager.getLogger(classname);
	} 
	
	public BaseTest()
	{
		try 
		{ 
			prop = new Properties();
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/con/hrm/qa/config/config.properties");
			prop.load(file);	
		}
		catch(Exception e)
		{ 
			 
		}
	}
	
	public static void launchBrowser() 
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info(browserName + " Broswer is successfully launched");
		}
		
		else if(browserName.equals("firefox"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			log.info(browserName + " Broswer is successfully launched");
		}
		
		eventFire = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		eventFire.register(eventListener);
		driver = eventFire;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.PAGE_LOAD_WAIT));
		driver.get(prop.getProperty("url"));	
		
	}

	

}
