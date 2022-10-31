package com.crm.pages;

import com.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a[@title='Employees']")
    public WebElement employeeButton;
    public static void clickEmployeeButton(){
        HomePage homePage=new HomePage();
        homePage.employeeButton.click();
    }
}
