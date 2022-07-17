package com.fb.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class SignUpPage extends TestBase {
	
	 @FindBy(xpath = "//input[@name='firstname']")
	    WebElement Firstname;
	 
	 @FindBy(xpath = "//input[@name='lastname']")
	    WebElement Lastname;
	 
	@FindBy(xpath = "//input[@name='reg_email__']")
    WebElement emailname;
	
	@FindBy(xpath = "//input[@name='reg_email_confirmation__']")
    WebElement verifyEmailname;

    @FindBy(xpath = "//input[@id='pass']")
    WebElement password;
    
    @FindBy(xpath = "//select[@name='birthday_day']")
    WebElement day;
    
    @FindBy(xpath = "//select[@id='month']")
    WebElement month;
    
    @FindBy(xpath = "//select[@name='birthday_year']")
    WebElement year;
    
    @FindBy(xpath = "//input[@value='1']")
    WebElement sex;
    
    @FindBy(xpath = "//button[@name='websubmit']")
    WebElement signupButton;

    // Initializing the Page Objects
    public  SignUpPage() {
        PageFactory.initElements(driver, this);
    }

    // Actions
    public String validateSignUpPageTitle () {
        return driver.getTitle();
    }


public HomePage signup(String firstname,String lastname,String email,String verifyemail, String pwd,int day,String month,int year,String gender){
	Firstname.sendKeys(firstname);
	Lastname.sendKeys(lastname);
	emailname.sendKeys(email);
	verifyEmailname.sendKeys(verifyemail);
    password.sendKeys(pwd);
    sex.sendKeys(gender);
    signupButton.click();

    return new HomePage();

}

}
