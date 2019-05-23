package com.demo.orangehrmlive.pageobjects;

import com.demo.orangehrmlive.utility.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Util {

    @FindBy(id = "txtUsername")
    WebElement _userName;

    @FindBy(id = "txtPassword")
    WebElement _password;

    @FindBy(id = "btnLogin")
    WebElement _loginButton;

    @FindBy(xpath = "//span[@id=\"spanMessage\"]")
    WebElement _messageBox;

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    //enter user name
    public void enterUserName(String str) {
        log.info("enter user name to login");
        System.out.println("user name is " + str);
        sendTextToElement(_userName, str);
    }

    //enter password
    public void enterPassword(String str) {
        log.info("enter password to login");
        System.out.println("password is " + str);
        sendTextToElement(_password, str);
    }

    //click on login button
    public void clickOnLoginButton() {
        log.info("click on login button");
        _loginButton.submit();
//        clickOnElement(_loginButton);
    }

    //verify that password can not be empty
    public boolean verifyThatPasswordCanNotBeEmpty() {
        log.info("Verify that password can not be empty");
        if (getTextFromElement(_messageBox).equals("Password cannot be empty")) {
            return true;
        } else {
            return false;
        }
    }

    //verify that username can't be empty
    public boolean verifyThatUserNameCanNotBeEmpty() {
        log.info("Verify that user name can not be empty");
        if (getTextFromElement(_messageBox).equals("Username cannot be empty")) {
            return true;
        } else {
            return false;
        }
    }

    //verify that login fails with invalid credentials
    public boolean verifyThatLoginFailsWithInvalidCredentials() {
        log.info("verify that login fails with invalid credentials");
        if (getTextFromElement(_messageBox).contains("Invalid credentials") || getTextFromElement(_messageBox).contains("validation failed")) {
            return true;
        } else {
            return false;
        }
    }

    //login method
    public void login_Using(String username, String password) {
        log.info("enter user name, password and click on login button");
        clearText(_userName);
        enterUserName(username);
        _userName.sendKeys(Keys.TAB);
        enterPassword(password);
        clickOnLoginButton();
    }
}
