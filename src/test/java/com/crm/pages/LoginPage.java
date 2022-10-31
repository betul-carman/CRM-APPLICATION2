package com.crm.pages;

import com.crm.utilities.ConfigurationReader;
import com.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public LoginPage(){
    PageFactory.initElements(Driver.getDriver(), this);
}
@FindBy(xpath = "//input[@name='USER_LOGIN']")
    public WebElement inputUsername;
@FindBy(xpath = "//input[@name='USER_PASSWORD']")
    public WebElement inputPassword;
@FindBy(xpath = "//input[@class='login-btn']")
    public WebElement inputLoginButton;
public void getLoginUrl(){
    String url= ConfigurationReader.getProperty("web.url");
    Driver.getDriver().get(url);

}

public void hrLogin(){

    inputUsername.sendKeys("hr2@cybertekschool.com");
    inputPassword.sendKeys("UserUser");
    inputLoginButton.click();
}
public void helpDeskLogin(){
     inputUsername.sendKeys("helpDesk2@cybertekschool.com");
    inputPassword.sendKeys("UserUser");
    inputLoginButton.click();
}
public void marketingLogin(){
    inputUsername.sendKeys("marketing2@cybertekschool.com");
    inputPassword.sendKeys("UserUser");
    inputLoginButton.click();
    }

}
