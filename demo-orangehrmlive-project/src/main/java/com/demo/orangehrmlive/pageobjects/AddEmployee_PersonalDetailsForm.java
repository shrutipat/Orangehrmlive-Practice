package com.demo.orangehrmlive.pageobjects;

import com.demo.orangehrmlive.utility.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployee_PersonalDetailsForm extends Util {

    private static final Logger log = LogManager.getLogger(AddEmployee_PersonalDetailsForm.class.getName());

    @FindBy(xpath = "//h1[contains(text(),'Personal Details')]")
    WebElement _personalDetailsText;

    @FindBy(xpath = "//div[@class='message success fadable']")
    WebElement _savedMessagePopUp;

    @FindBy(xpath = "//input[@id=\'btnSave\']")
    WebElement _editOrSaveBtn;

    @FindBy(id = "personal_txtOtherID")
    WebElement _otherID;

    @FindBy(id = "personal_txtLicenNo")
    WebElement _drivingLicenseNumber;

    @FindBy(id = "personal_txtLicExpDate")
    WebElement _licenseExpDateBox;

    @FindBy(id = "personal_DOB")
    WebElement _dobBox;

    @FindBy(className = "ui-datepicker-year")
    WebElement _Year;

    @FindBy(className = "ui-datepicker-month")
    WebElement _Month;

    @FindBy(xpath = "//label[contains(text(),'Female')]")
    WebElement _female;

    @FindBy(id = "personal_cmbMarital")
    WebElement _maritalStatus;

    @FindBy(id = "personal_cmbNation")
    WebElement _nationality;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='1']")
    WebElement _date1;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='2']")
    WebElement _date2;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='3']")
    WebElement _date3;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='4']")
    WebElement _date4;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='5']")
    WebElement _date5;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='6']")
    WebElement _date6;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='7']")
    WebElement _date7;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='8']")
    WebElement _date8;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='9']")
    WebElement _date9;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='10']")
    WebElement _date10;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='11']")
    WebElement _date11;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='12']")
    WebElement _date12;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='13']")
    WebElement _date13;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='14']")
    WebElement _date14;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='15']")
    WebElement _date15;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='16']")
    WebElement _date16;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='17']")
    WebElement _date17;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='18']")
    WebElement _date18;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='19']")
    WebElement _date19;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='20']")
    WebElement _date20;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='21']")
    WebElement _date21;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='22']")
    WebElement _date22;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='23']")
    WebElement _date23;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='24']")
    WebElement _date24;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='25']")
    WebElement _date25;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='26']")
    WebElement _date26;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='27']")
    WebElement _date27;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='28']")
    WebElement _date28;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='29']")
    WebElement _date29;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='30']")
    WebElement _date30;

    @FindBy(xpath = "//a[@class ='ui-state-default' and text()='31']")
    WebElement _date31;

    //verify that user is on personal details page
    public boolean verifyThatUserIsOnPersonalDetailsPage() {
        log.info("verify that user is on personal details page");
        if (getTextFromElement(_personalDetailsText).equals("Personal Details")) {
            return true;
        } else return false;
    }

    //click on edit button
    public void clickOnEditButton() {
        log.info("click on edit button");
        clickOnElement(_editOrSaveBtn);
    }

    //click on save button
    public void clickOnSaveButton() {
        log.info("click on save button");
        clickOnElement(_editOrSaveBtn);
    }

    //verify that successfully saved message pops up after saving personal details
    public boolean verifyThatPopUpAppears() {
        log.info("verify that successfully saved pop up appears");
        if (verifyThatElementIsDisplayed(_savedMessagePopUp)) {
            return true;
        } else return false;
    }

    //enter driving license
    public void enterDrivingLicenseNumber(String license) {
        log.info("Enter driving license number");
        sendTextToElement(_drivingLicenseNumber, license);
    }

    //enter other Id
    public void enterPassportNumberInOtherId(String passport) {
        log.info("Send text to other id Passport");
        sendTextToElement(_otherID, passport);
    }

    //click on female
    public void clickFemale() {
        log.info("click on female");
        clickOnElement(_female);
    }

    //select marital status from drop down list
    public void selectMaritalStatus(String status) {
        log.info("Select marital status from drop down");
        clickOnElement(_maritalStatus);
        select_By_Visible_Text(_maritalStatus, status);
    }

    //select nationality
    public void selectNationality(String nationality) {
        log.info("select nationality from drop down");
        clickOnElement(_nationality);
        select_By_Visible_Text(_nationality, nationality);
    }

    //select year, month and date from calender
    public void selectDateFromCalender(char boxName, String year, String month, String date) throws InterruptedException {
        log.info("select year, month and date from calender");
        if (boxName == 'L') {
            clickOnElement(_licenseExpDateBox);
        } else if (boxName == 'B') {
            clickOnElement(_dobBox);
        }
        Thread.sleep(1000);
        clickOnElement(_Month);
        select_By_Visible_Text(_Month, month);
        Thread.sleep(2000);
        clickOnElement(_Year);
        select_By_Visible_Text(_Year, year);
        Thread.sleep(2000);
        selectDate(date);
        Thread.sleep(2000);
    }

    //click on date from calender
    public void selectDate(String date) {
        log.info("click on correct date in calender");
        switch (date) {
            case "1": {
                clickOnElement(_date1);
                break;
            }
            case "2": {
                clickOnElement(_date2);
                break;
            }
            case "3": {
                clickOnElement(_date3);
                break;
            }
            case "4": {
                clickOnElement(_date4);
                break;
            }
            case "5": {
                clickOnElement(_date5);
                break;
            }
            case "6": {
                clickOnElement(_date6);
                break;
            }
            case "7": {
                clickOnElement(_date7);
                break;
            }
            case "8": {
                clickOnElement(_date8);
                break;
            }
            case "9": {
                clickOnElement(_date9);
                break;
            }
            case "10": {
                clickOnElement(_date10);
                break;
            }
            case "11": {
                clickOnElement(_date11);
                break;
            }
            case "12": {
                clickOnElement(_date12);
                break;
            }
            case "13": {
                clickOnElement(_date13);
                break;
            }
            case "14": {
                clickOnElement(_date14);
                break;
            }
            case "15": {
                clickOnElement(_date15);
                break;
            }
            case "16": {
                clickOnElement(_date16);
                break;
            }
            case "17": {
                clickOnElement(_date17);
                break;
            }
            case "18": {
                clickOnElement(_date18);
                break;
            }
            case "19": {
                clickOnElement(_date19);
                break;
            }
            case "20": {
                clickOnElement(_date20);
                break;
            }
            case "21": {
                clickOnElement(_date21);
                break;
            }
            case "22": {
                clickOnElement(_date22);
                break;
            }
            case "23": {
                clickOnElement(_date23);
                break;
            }
            case "24": {
                clickOnElement(_date24);
                break;
            }
            case "25": {
                clickOnElement(_date25);
                break;
            }
            case "26": {
                clickOnElement(_date26);
                break;
            }
            case "27": {
                clickOnElement(_date27);
                break;
            }
            case "28": {
                clickOnElement(_date28);
                break;
            }
            case "29": {
                clickOnElement(_date29);
                break;
            }
            case "30": {
                clickOnElement(_date30);
                break;
            }
            case "31": {
                clickOnElement(_date31);
                break;
            }
        }
    }
}

