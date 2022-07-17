package com.fb.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fb.qa.util.TestUtil;

public class TestBase{
	public static WebDriver driver;
	  public static Properties props;
	  
	public TestBase() {
		 props = new Properties();
	        FileInputStream ip = null;
	        try {
	            ip = new FileInputStream("C:\\Users\\avije\\eclipse-workspace\\PageObjectModel"
	            		+ "\\src\\main\\java\\com\\fb\\qa\\config\\config.properties");
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        try {
	            props.load(ip);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}
	
	public static void initialization() {
        String browserName = props.getProperty("browser");
        if (browserName.equals("chrome")) {
        	System.setProperty("webdriver.chrome.driver","C:\\Users\\avije\\eclipse-workspace\\SeleniumAutomation\\Driver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\avije\\eclipse-workspace\\SeleniumAutomation\\Driver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(props.getProperty("url"));

    }
}

