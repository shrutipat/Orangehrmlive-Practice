package com.demo.orangehrmlive.webpages;

import com.demo.orangehrmlive.pageobjects.*;
import com.demo.orangehrmlive.testbase.TestBase;
import com.demo.orangehrmlive.utility.Util;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    String random = Integer.toString(new Util().generateRandomNumber());

    // runs fine
    @Test(priority = 0)
    public void user_Should_Get_Error_Message_If_User_Name_Field_Is_Empty() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.enterPassword("admin123");
        homePage.clickOnLoginButton();
        Assert.assertTrue(homePage.verifyThatUserNameCanNotBeEmpty());
    }

    // runs fine
    @Test(priority = 1)
    public void user_Should_Get_Error_Message_If_Password_Field_Is_Empty() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.enterUserName("Admin");
        homePage.clickOnLoginButton();
        Assert.assertTrue(homePage.verifyThatPasswordCanNotBeEmpty());
    }

    // runs fine
    @Test(priority = 2)
    public void login_Should_Fail_With_Invalid_User_Name_And_Invalid_Password() throws InterruptedException {
        new HomePage().login_Using("Fiona", "English");
        Assert.assertTrue(new HomePage().verifyThatLoginFailsWithInvalidCredentials());
    }

    // runs fine
    @Test(priority = 3)
    public void login_Should_Fail_With_Valid_User_Name_And_Invalid_Password() throws InterruptedException {
        new HomePage().login_Using("Admin", "English");
        Assert.assertTrue(new HomePage().verifyThatLoginFailsWithInvalidCredentials());
    }

    // runs fine
    @Test(priority = 4)
    public void login_Should_Fail_With_Invalid_User_Name_And_Valid_Password() throws InterruptedException {
        new HomePage().login_Using("Fiona", "admin123");
        Assert.assertTrue(new HomePage().verifyThatLoginFailsWithInvalidCredentials());
    }

    // runs fine
    @Test(priority = 5)
    public void user_Should_Login_Successfully_With_Credentials_On_Website() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.login_Using("Admin", "admin123");

        if (new HomePage().verifyThatLoginFailsWithInvalidCredentials()) {
            homePage.login_Using("Admin", "admin123");
        }
        Thread.sleep(1000);
        Assert.assertTrue(new DashBoard().verifyThatUserIsOnDashBoardPage());
    }

    // runs fine
    @Test(priority = 6)
    public void user_Should_Navigate_To_Add_Employee_Page_Successfully() throws InterruptedException {

        HomePage homePage = new HomePage();
        homePage.login_Using("Admin", "admin123");

        if (new HomePage().verifyThatLoginFailsWithInvalidCredentials()) {
            homePage.login_Using("Admin", "admin123");
        }
        // user should login successfully and arrive on add employee page
        PIMMenu pimMenu = new PIMMenu();
        pimMenu.mouseOverPIM();
        pimMenu.clickOnAddEmployee();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("addEmployee"));
    }

    //runs fine
    @Test(priority = 7)
    public void user_Should_Be_Navigated_To_Employee_List_Page_Successfully() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.login_Using("Admin", "admin123");
        if (new HomePage().verifyThatLoginFailsWithInvalidCredentials()) {
            homePage.login_Using("Admin", "admin123");
        }
        PIMMenu pimMenu = new PIMMenu();
        pimMenu.mouseOverPIM();
        pimMenu.clickOnEmployeeList();
        Thread.sleep(500);
        Assert.assertTrue(driver.getCurrentUrl().contains("viewEmployeeList"));
    }

    //runs fine
    @Test(priority = 8)
    public void user_Should_Be_Able_To_Add_Employee_Details_And_Reach_Personal_Details_Page() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.login_Using("Admin", "admin123");

        if (new HomePage().verifyThatLoginFailsWithInvalidCredentials()) {
            homePage.login_Using("Admin", "admin123");
        }
        // user should login successfully and navigate to add employee page
        PIMMenu pimMenu = new PIMMenu();
        pimMenu.mouseOverPIM();
        pimMenu.clickOnAddEmployee();
        Thread.sleep(1000);
        //start adding employee details
        String firstName = "Fiona";
        AddEmployeeForm addEmployeeForm = new AddEmployeeForm();
        addEmployeeForm.enterFirstName(firstName);
        addEmployeeForm.enterMiddleName("M");
        addEmployeeForm.enterLastName("English");
        addEmployeeForm.clearEmployeeIdText();
        addEmployeeForm.enterEmployeeID("0" + random);
        addEmployeeForm.clickOnCreateLoginDetails();
        Thread.sleep(1000);
        addEmployeeForm.enterUserName("Fiona_English");
        String password = "Unknown.123";
        addEmployeeForm.enterPassword(password);
        addEmployeeForm.reEnterPassword(password);
        addEmployeeForm.clickOnSaveButton();
        //Verify that Clicking On Save Button Adds Employee And User Is Navigated To 'Personal Details' part of Form
        Assert.assertTrue(new AddEmployee_PersonalDetailsForm().verifyThatUserIsOnPersonalDetailsPage());
    }

    //runs fine
    @Test(priority = 9)
    public void user_Should_Be_Able_To_Save_Personal_Details_Successfully() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.login_Using("Admin", "admin123");

        if (new HomePage().verifyThatLoginFailsWithInvalidCredentials()) {
            homePage.login_Using("Admin", "admin123");
        }
        // user should login successfully and navigate to add employee page
        PIMMenu pimMenu = new PIMMenu();
        pimMenu.mouseOverPIM();
        pimMenu.clickOnAddEmployee();
        Thread.sleep(1000);

        //start entering employee details
        String firstName = "Fionaaa";
        AddEmployeeForm addEmployeeForm = new AddEmployeeForm();
        addEmployeeForm.enterFirstName(firstName);
        addEmployeeForm.enterMiddleName("MM");
        addEmployeeForm.enterLastName("Englishhh");
        addEmployeeForm.clearEmployeeIdText();
        addEmployeeForm.enterEmployeeID(random);
        addEmployeeForm.clickOnCreateLoginDetails();
        Thread.sleep(1000);
        addEmployeeForm.enterUserName("Fionaaa_Englishhh");
        String password = "Unknown.123";
        addEmployeeForm.enterPassword(password);
        addEmployeeForm.reEnterPassword(password);
        addEmployeeForm.clickOnSaveButton();
        //Verify that Clicking On Save Button Adds Employee And User Is Navigated To 'Personal Details' part of Form
        Assert.assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails"));
        AddEmployee_PersonalDetailsForm addEmployee_personalDetailsForm = new AddEmployee_PersonalDetailsForm();
        addEmployee_personalDetailsForm.clickOnEditButton();
        Thread.sleep(1000);
        addEmployee_personalDetailsForm.enterDrivingLicenseNumber("License12345");
        addEmployee_personalDetailsForm.enterPassportNumberInOtherId("Passport12345");
        addEmployee_personalDetailsForm.selectDateFromCalender('L', "2020", "Aug", "15");
        addEmployee_personalDetailsForm.clickFemale();
        addEmployee_personalDetailsForm.selectMaritalStatus("Single");
        addEmployee_personalDetailsForm.selectNationality("British");
        addEmployee_personalDetailsForm.selectDateFromCalender('B', "1983", "Feb", "18");
        addEmployee_personalDetailsForm.clickOnSaveButton();
        Thread.sleep(2000);
        Assert.assertTrue(addEmployee_personalDetailsForm.verifyThatPopUpAppears());
    }

    //runs fine
    @Test(priority = 10)
    public void user_Should_Be_Able_To_Delete_Correct_Details_Successfully() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.login_Using("Admin", "admin123");

        if (new HomePage().verifyThatLoginFailsWithInvalidCredentials()) {
            homePage.login_Using("Admin", "admin123");
        }
        // user should login successfully and navigate to add employee page
        PIMMenu pimMenu = new PIMMenu();
        pimMenu.mouseOverPIM();
        pimMenu.clickOnEmployeeList();
        EmployeeListOrInformationPage employeeListOrInformationPage = new EmployeeListOrInformationPage();
        employeeListOrInformationPage.clickOnCheckBox(random);
        employeeListOrInformationPage.clickDeleteButton();
        employeeListOrInformationPage.confirmDelete();
        Assert.assertTrue(employeeListOrInformationPage.verifyThatRecordIsDeletedSuccessfully());
    }
}
