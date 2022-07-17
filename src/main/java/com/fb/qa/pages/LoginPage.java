package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class LoginPage extends TestBase {
	 @FindBy(xpath = "//input[@placeholder='Email address or phone number']")
     WebElement emailname;

     @FindBy(xpath = "//input[@id='pass']")
     WebElement password;

     @FindBy(xpath = "//button[@name='login']")
     WebElement loginButton;

//     @FindBy(xpath = "//a[contains(text(),'Create New Account')]")
//     WebElement CreateNewAccountButton ;

     // Initializing the Page Objects
 public LoginPage() {
         PageFactory.initElements(driver, this);
     }

     // Actions
     public String validateLoginPageTitle () {
         return driver.getTitle();
     }


 public HomePage login(String email , String pwd){
	 emailname.sendKeys(email);
     password.sendKeys(pwd);
     loginButton.click();

     return new HomePage();

 }
}
