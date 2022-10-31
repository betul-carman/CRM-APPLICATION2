package com.crm.pages;

import com.crm.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EmployeePage {
    public EmployeePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "pagetitle")
    public WebElement companyStructureTitle;

    @FindBy(xpath = "//a[@class='webform-small-button webform-small-button-blue webform-small-button-add']")
    public WebElement addButton;

    @FindBy(xpath = "//input[@id='NAME']")
    public WebElement departmentInput;

    @FindBy(xpath = "//span[@class='popup-window-button popup-window-button-accept']")
    public WebElement secondAddButton;
    @FindBy(xpath = "//a[@title='SDET2']")
    public WebElement sdet2;
    @FindBy(xpath = "//li[.='Section name is not specified.']")
    public WebElement warningMessage;
    @FindBy(id = "IBLOCK_SECTION_ID")
    public WebElement parentDepartmentDropdown;

    public void selectDropdownButton(String optionValue){
        Select select1=new Select(parentDepartmentDropdown);
        select1.selectByValue(optionValue);
    }
    public String firstSelectedOption(String optionValue){
        Select select1=new Select(parentDepartmentDropdown);
        select1.selectByValue(optionValue);
        String firstSelecetedOption=select1.getFirstSelectedOption().getText();
        return firstSelecetedOption;
    }
    @FindBy(xpath = "//a[.='Select from structure']")
    public WebElement supervisorSelectionButton;

    //@FindBy(xpath = "//div[.='Ali Jesta']")
    //public WebElement selectionSupervisorAsRecent;

    public WebElement returnRecentSupervisor(String name){
    return Driver.getDriver().findElement(By.xpath("//div[.=\""+name+"\"]"));
    }
    public WebElement verifyReturnRecentSupervisor(String name){
        return Driver.getDriver().findElement(By.xpath("//span[.=\""+name+"\"]"));
    }
    @FindBy(xpath = "//span[.='Company']")
    public WebElement companyButton;
    @FindBy(xpath = "(//div[@class='company-department-text'])[1]")
    public WebElement companyDropdownButton;
    @FindBy(xpath = "(//div[.='Arben Istrefi'])[2]")
    public WebElement personIsSelected;
    @FindBy(xpath = "//span[.='Arben Istrefi']")
    public WebElement selectedPerson;
    @FindBy(xpath = "//span[.='Search']")
    public WebElement searchButton;
    @FindBy(xpath = "//input[@class='finder-box-search-textbox']")
    public WebElement searchInputButton;
    public void searchInputButtonSendKey(String name){
        searchInputButton.sendKeys(name);
    }
    public WebElement typingNameInSearchInput(String name){
        return Driver.getDriver().findElement(By.xpath("(//div[.=\""+name+"\"])[2]"));
    }
    public WebElement afterTypingNameInSearchInput(String name){
        return Driver.getDriver().findElement(By.xpath("//span[.=\""+name+"\"]"));
    }
    @FindBy(xpath = "(//span[@class='popup-window-close-icon popup-window-titlebar-close-icon'])[2]")
    public WebElement closingButton;
    @FindBy(xpath = "//div[@class='popup-window popup-window-with-titlebar']")
    public WebElement popupAddDepartment;
    public void closingPopup(){
        Assert.assertFalse(popupAddDepartment.isDisplayed());
    }
    public WebElement clickDepartment(String name){
        return Driver.getDriver().findElement(By.xpath("//a[.=\""+name+"\"]"));
    }
    @FindBy(xpath = "//a[@class='department-profile-events-item department-profile-edit']")
    public WebElement editDepartmentButton;
    @FindBy(xpath = "//a[@id='single-user-choice']")
    public WebElement selectFromStructureButton;
    @FindBy(xpath = "//span[.='Save']")
    public WebElement saveButton;
    @FindBy(xpath = "(//a[.='Arben Istrefi'])[1]")
    public WebElement savedSupervisor;
    public void isSavedSelectedSupervisor(){
        Assert.assertTrue(savedSupervisor.isDisplayed());
    }
    @FindBy(xpath = "//a[@class='department-profile-events-item department-profile-subsection']")
    public WebElement addButtonUnderActions;
    @FindBy(xpath = "//input[@id='NAME']")
    public WebElement addChildDepartmentInputBox;
    @FindBy(xpath = "//span[@class='popup-window-button popup-window-button-accept']")
    public WebElement addCgildButton;
    @FindBy(xpath = "//p[.='Department has been added.']")
    public WebElement warningMessageAboutAddingDept;
    public void isDisplayedWarningMessage(){
        Assert.assertTrue(warningMessageAboutAddingDept.isDisplayed());
    }
    @FindBy(xpath = "//a[.='sdet8']")
    public WebElement sdet8;
    @FindBy(xpath = "//a[@class='department-profile-events-item department-profile-remove']")
    public WebElement deleteButton;
    public void isDisplayedSdet8(){//WEB ELEMENT IS DELETED!!!!!!!!!!
        Assert.assertFalse(sdet8.isDisplayed());
    }
    @FindBy(xpath = "//a[.='sdet']")
    public WebElement childDepartment;
    @FindBy(xpath = "(//div[@class='structure-dept-title-text'])[2]")
    public WebElement parentDepartment;
    @FindBy(xpath = "//a[.='sdet']")
    public WebElement dragAndDroppedChildDepartment;
    public void verifyDragedAndDropped(){
        String actual=dragAndDroppedChildDepartment.getText();
        String expected=childDepartment.getText();
        Assert.assertEquals(expected, actual);
    }
    public void dragAndDrop(){
        Actions action=new Actions(Driver.getDriver());
        action.dragAndDrop(childDepartment,parentDepartment).perform();
    }
    @FindBy(xpath = "(//a[.='Support'])[2]")
    public WebElement parentOfChild;
    public void verifyParentOfChild(){
        String expectedParent="Support";
        String actualParent=Driver.getDriver().findElement(By.xpath("(//a[.='Support'])[2]")).getText();
        Assert.assertEquals(expectedParent, actualParent);
    }
    public void companyStructureVerification(){
        String actualTitle=companyStructureTitle.getText();
        String expectedTitle="Company Structure";
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    public  void addingDepartmentVerification(){
        String expectedSdet2="SDET2";
        String actualSdet2=sdet2.getText();
        Assert.assertEquals(expectedSdet2, actualSdet2);
    }
    public void warningMessageVerification(){
        String actualWarningMessage=warningMessage.getText();
        String expectedWarningMessage="Section name is not specified.";
        Assert.assertEquals(expectedWarningMessage, actualWarningMessage);
    }
    public void supervisorVerification(){
        String actualSelectedPerson=selectedPerson.getText();
        String expectedSelectedPerson="Arben Istrefi";
        Assert.assertEquals(expectedSelectedPerson, actualSelectedPerson);
    }



}
