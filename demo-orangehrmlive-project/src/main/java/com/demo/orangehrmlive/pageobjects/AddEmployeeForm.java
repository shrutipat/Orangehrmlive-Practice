package com.demo.orangehrmlive.pageobjects;

import com.demo.orangehrmlive.utility.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployeeForm extends Util {

    @FindBy(id = "firstName")
    WebElement _firstName;

    @FindBy(id = "middleName")
    WebElement _middleName;

    @FindBy(id = "lastName")
    WebElement _lastName;

    @FindBy(id = "employeeId")
    WebElement _employeeID;

    @FindBy(id = "chkLogin")
    WebElement _chkCreateLogin;

    @FindBy(id = "btnSave")
    WebElement _saveButton;

    @FindBy (id="user_name")
    WebElement _userName;

    @FindBy (id="user_password")
    WebElement _userPassword;

    @FindBy (id="re_password")
    WebElement _reEnterPassword;


    private static final Logger log = LogManager.getLogger(AddEmployeeForm.class.getName());

    //enter first name
    public void enterFirstName(String str) {
        log.info("Enter First Name");
        sendTextToElement(_firstName, str);
    }

    //enter middle name
    public void enterMiddleName(String str) {
        log.info("Enter Middle Name");
        sendTextToElement(_middleName, str);
    }

    //enter last name
    public void enterLastName(String str) {
        log.info("Enter Last Name");
        sendTextToElement(_lastName, str);
    }

    //enter employee id
    public void enterEmployeeID(String str) {
        log.info("Enter Employee ID");
        sendTextToElement(_employeeID, str);
    }

    //click on create login details
    public void clickOnCreateLoginDetails() {
        log.info("Create Login Details");
        clickOnElement(_chkCreateLogin);
    }

    //enter user name
    public void enterUserName(String str){
        log.info("Enter User Name");
        sendTextToElement(_userName, str);
    }

    //enter password
    public void enterPassword(String str){
        log.info("Enter Password");
        sendTextToElement(_userPassword, str);
    }

    //re-enter password
    public void reEnterPassword(String str){
        log.info("Re-enter Password");
        sendTextToElement(_reEnterPassword, str);
    }

    //click on save button
    public void clickOnSaveButton() {
        log.info("click on save Button");
        clickOnElement(_saveButton);
    }



    public void clearEmployeeIdText(){
        log.info("Clear Employee ID Text");
        clearText(_employeeID);
    }


    /*

    public boolean verifyThatClickingSaveButtonAddsEmployee(){
        if (getTextFromElement(_empFirstName).compareTo("Personal Details")==1){
            return true;
        }
        else return false;
    }
*/
}