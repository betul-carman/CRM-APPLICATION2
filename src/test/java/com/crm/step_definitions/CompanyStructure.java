package com.crm.step_definitions;

import com.crm.pages.EmployeePage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utilities.BrowserUtils;
import com.crm.utilities.ConfigurationReader;
import com.crm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CompanyStructure {
    LoginPage loginPage=new LoginPage();
    HomePage homePage=new HomePage();
    EmployeePage employeePage=new EmployeePage();
    @Given("user is on login page")
    public void userIsOnLoginPage() {
        loginPage.getLoginUrl();
    }

    @When("User enter username{string} and password {string}")
    public void hrUserEnterUsernameAndPassword(String arg0, String arg1) {
        loginPage.inputUsername.sendKeys(arg0);
        loginPage.inputPassword.sendKeys(arg1);
        loginPage.inputLoginButton.click();
    }

    @And("User is on home page and clicks employee button")
    public void UserShouldBeOnHomePage() {
        BrowserUtils.verifyURLContains("stream");
    }

    @Then("User should see company structure")
    public void UserShouldSeeCompanyStructure() {
        homePage.clickEmployeeButton();
        employeePage.companyStructureVerification();
    }
    @Given("Hr user is on the employees page")
    public void hrUserIsOnTheEmployeesPage() {
        loginPage.getLoginUrl();
        loginPage.hrLogin();
        HomePage.clickEmployeeButton();
    }
    @When("Hr user click department add button")
    public void hrUserClickAddButton() {
        employeePage.addButton.click();
    }
    @And("Hr user type a department name")
    public void hrUserTypeADepartmentName(){

        employeePage.departmentInput.sendKeys("SDET2");

    }
    @Then("Hr user should add that department")
    public void hrUserShouldAddThatDepartment() {
        employeePage.secondAddButton.click();
        employeePage.addingDepartmentVerification();
    }
    @And("Hr user doesn't type a department name")
    public void hrUserDoesnTTypeADepartmentName() {
        employeePage.departmentInput.click();
        employeePage.secondAddButton.click();
    }
    @Then("Hr user should see warning message")
    public void hrUserShouldSeeWarningMessage() {
        employeePage.warningMessageVerification();
    }

    @And("Hr user select a parent department from dropdown")
    public void hrUserSelectAParentDepartmentFromDropdown(){
        employeePage.selectDropdownButton("222");
        String actualSelectedDropdown=employeePage.firstSelectedOption("222");
        String expectedSelectedDropdown=" .  . QA Dept.";
        Assert.assertEquals(expectedSelectedDropdown, actualSelectedDropdown);

    }

//CHECK THIS!!!!!!!!!!!!!!
    @Then("Hr user should  add that department as it's parent department")
    public void hrUserShouldAddThatDepartmentAsItSParentDepartment() {
        employeePage.secondAddButton.click();
        //DONT FORGET TO VERIFY
        
    }

String name="";
    @And("Hr user select a supervisor {string} from recent")
    public void hrUserSelectASupervisorFromRecent(String arg0) {
        name=arg0;
        employeePage.supervisorSelectionButton.click();
        employeePage.returnRecentSupervisor(name).click();

    }
    @Then("Hr user should see {string} as supervisor from recent")
    public void hrUserShouldSeeAsSupervisorFromRecent(String arg0) {
        String actualSelectedRecentSupervisor=employeePage.verifyReturnRecentSupervisor(name).getText();
        String expectedSelectedRecentSupervisor="Kadir Testa";
        Assert.assertEquals(expectedSelectedRecentSupervisor, actualSelectedRecentSupervisor);
    }

    @And("Hr user select a supervisor from company")
    public void hrUserSelectASupervisorFromCompany() {
        employeePage.supervisorSelectionButton.click();
        employeePage.companyButton.click();
        employeePage.companyDropdownButton.click();
        employeePage.personIsSelected.click();

    }
    @Then("Hr user should see that name as supervisor from company")
    public void hrUserShouldSeeThatNameAsSupervisorFromCompany() {
        employeePage.supervisorVerification();
    }
String name2="";
    @And("Hr user select a supervisor {string} from search")
    public void hrUserSelectASupervisorFromSearch(String arg0) throws InterruptedException {
        name2=arg0;
        employeePage.supervisorSelectionButton.click();
        Thread.sleep(3000);
        employeePage.searchButton.click();
        employeePage.searchInputButton.sendKeys(name2);
        //employeePage.searchInputButtonSendKey(name2);
        employeePage.typingNameInSearchInput(name2).click();
    }
    @Then("Hr user should see {string} as supervisor from search")
    public void hrUserShouldSeeAsSupervisorFromSearch(String arg0) {
        String actualTypingName=employeePage.afterTypingNameInSearchInput(name2).getText();
        String expectedTypingName=name2;
        Assert.assertEquals(expectedTypingName,actualTypingName);
    }

    @And("Hr user click the closing sign")
    public void hrUserClickTheClosingSign() {
        employeePage.closingButton.click();
    }

    @Then("Hr user should closed the pop-up")
    public void hrUserShouldClosedThePopUp() {
        employeePage.closingPopup();
    }

    @When("Hr user click a department {string} from company structure")
    public void hrUserClickADepartmentFromCompanyStructure(String arg0) {
        employeePage.clickDepartment(arg0).click();
    }

    @And("Hr user click edit department button")
    public void hrUserClickEditDepartmentButton() {
        employeePage.editDepartmentButton.click();
    }

    @Then("Hr user should edit department")
    public void hrUserShouldEditDepartment() {
        //employeePage.supervisorSelectionButton.click();
        employeePage.selectFromStructureButton.click();
        employeePage.companyButton.click();
        employeePage.companyDropdownButton.click();
        employeePage.personIsSelected.click();
        employeePage.saveButton.click();
        employeePage.isSavedSelectedSupervisor();
    }

    @And("Hr user click add department button")
    public void hrUserClickAddDepartmentButton() {
        employeePage.addButtonUnderActions.click();
    }
    @Then("Hr user should add a child department")
    public void hrUserShouldAddAChildDepartment() {
        employeePage.addChildDepartmentInputBox.sendKeys("sdet8");
        employeePage.addCgildButton.click();
        employeePage.isDisplayedWarningMessage();
    }
    @And("Hr user click a department under QA department")
    public void hrUserClickADepartmentUnderQADepartment() {
        employeePage.sdet8.click();
    }

    @And("Hr user click delete department button")
    public void hrUserClickDeleteDepartmentButton() {
        employeePage.deleteButton.click();
        Alert alert=Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    @Then("Hr user should not see  the deleted department in company structure")
    public void hrUserDoesnTSeeTheDeletedDepartmentInCompanyStructure() throws Exception {
    Thread.sleep(5000);
        //employeePage.isDisplayedSdet8();
        Assert.assertTrue(BrowserUtils.assertWebElementNotPresent(employeePage.sdet8));
    }
    @When("Hr user drag and drop a department under another department")
    public void hrUserDragAndDropADepartmentUnderAnotherDepartment() {
        employeePage.dragAndDrop();
        employeePage.childDepartment.click();
    }
    @Then("Hr user should see this department as subdepartment of that department")
    public void hrUserShouldSeeThisDepartmentAsSubdepartmentOfThatDepartment() {
        employeePage.verifyParentOfChild();
        //employeePage.verifyDragedAndDropped();
    }

    @Given("Helpdesk and marketing users are on login page")
    public void helpdeskAndMarketingUsersAreOnLoginPage() {
        loginPage.getLoginUrl();
    }

    @When("Helpdesk and marketing users enter username{string} and password {string}")
    public void helpdeskAndMarketingUsersEnterUsernameAndPassword(String arg0, String arg1) {
        loginPage.inputUsername.sendKeys(arg0);
        loginPage.inputPassword.sendKeys(arg1);
        loginPage.inputLoginButton.click();
    }

    @And("Helpdesk and marketing users are on home page and click employees button")
    public void helpdeskAndMarketingUsersAreOnHomePageAndClickEmployeesButton() {
        homePage.employeeButton.click();

    }

    @Then("Helpdesk and marketing users should not be able to see add department button")
    public void helpdeskAndMarketingUsersShouldNotChangeCompanyStructure() throws Exception {

        Assert.assertTrue(BrowserUtils.assertWebElementNotPresent(employeePage.addButton));



    }
}
