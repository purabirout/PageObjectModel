package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.SignUpPage;

public class SignUpPageTest extends TestBase{
	LoginPage loginPage;
    HomePage homePage;
    SignUpPage signupPage;

    public SignUpPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        signupPage = new SignUpPage();
    }

    @Test(priority = 1)
    public void signupPageTitleTest() throws InterruptedException{
    String title = signupPage.validateSignUpPageTitle();
    Thread.sleep(3000);
    Assert.assertEquals(title, "Facebook – log in or sign up");
    }

    
    @Test(priority = 2)
    public void loginTest(){
        homePage = loginPage.login(props.getProperty("emailname"), props.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
