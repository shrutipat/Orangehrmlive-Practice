package com.demo.orangehrmlive.pageobjects;

import com.demo.orangehrmlive.utility.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeListOrInformationPage extends Util {


    private static final Logger log = LogManager.getLogger(EmployeeListOrInformationPage.class.getName());

    //delete button
    @FindBy(id = "btnDelete")
    WebElement _deleteBtn;

    //Ok button to confirm delete
    @FindBy(xpath = "//input[@id='dialogDeleteBtn']")
    WebElement _confirmDelete;

    //pop up message about successful deletion
    @FindBy(xpath = "//div[@class='message success fadable']")
    WebElement _deleteMessagePopUp;

    //customized path to tick checkbox for given employee id. In below example, it would locate checkbox of id '0011'
   /* @FindBy (xpath = "//a[text()='0011']//parent::td[@class='left']//preceding-sibling::td/descendant::input[@type='checkbox']")
    WebElement _checkBox;*/

    //tick checkbox for given id number
    public void clickOnCheckBox(String idNumber) {
        log.info("click on checkbox for given id number");
        WebElement path = driver.findElement(By.xpath("//a[text()='" + idNumber + "']//parent::td[@class='left']//preceding-sibling::td/descendant::input[@type='checkbox']"));
        clickOnElement(path);
    }

    //click delete button
    public void clickDeleteButton() {
        log.info("click delete button");
        clickOnElement(_deleteBtn);
    }

    //confirm delete
    public void confirmDelete() {
        log.info("click confirm delete");
        clickOnElement(_confirmDelete);
    }

    //verify that record is deleted successfully
    public boolean verifyThatRecordIsDeletedSuccessfully() {
        log.info("verify that record is deleted successfully");
        if (verifyThatElementIsDisplayed(_deleteMessagePopUp) == true) {
            return true;
        } else return false;
    }

}
