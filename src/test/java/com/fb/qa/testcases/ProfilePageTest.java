package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.ProfilePage;
import com.fb.qa.util.TestUtil;

public class ProfilePageTest extends TestBase{
	 LoginPage loginPage;
	    HomePage homePage;
	    TestUtil testUtil;
	    ProfilePage profile;

	    public ProfilePageTest() {
	        super();
	    }

	    @BeforeMethod
	    public void setUp() throws InterruptedException {
	        initialization();
	        testUtil = new TestUtil();
	        loginPage = new LoginPage();
	        profile = new ProfilePage();
	        homePage = loginPage.login(props.getProperty("emailname"), props.getProperty("password"));
	        Thread.sleep(2000);
	        homePage.clickOnProfile();
	        Thread.sleep(2000);
	        profile.clickonEditProfile();
	        Thread.sleep(2000);
	    }

	    @Test(priority = 1)
	    public void verifyFindFriendsTitleTest() {
	        String editProfileTitle = profile.verifyProfileTitle();
	        Assert.assertEquals(editProfileTitle   , "John Smith | Facebook", "Home Page is Incorrect");
	    }

	    @Test(priority = 2)
	    public void verifyEditProfilePic()  {
	        profile.clickonChangeProfilePic();
	    }

	    @Test(priority = 3)
	    public void verifyAddCoverPhoto(){
	        profile.clickonAddCoverPhoto();
	    }

	    @Test(priority = 4)
	    public void verifyEditBio(){
	        profile.clickonAddBio();
	    }

	    @AfterMethod
	    public void tearDown()  {
	        driver.quit();
	    }
}
