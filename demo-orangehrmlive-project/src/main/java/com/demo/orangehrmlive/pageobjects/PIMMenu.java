package com.demo.orangehrmlive.pageobjects;

import com.demo.orangehrmlive.utility.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PIMMenu extends Util {

    @FindBy(xpath = "//b[contains(text(),'PIM')]")
    WebElement _pimMenu;

    @FindBy(id = "menu_pim_addEmployee")
    WebElement _addEmployeeLink;

    @FindBy(id = "menu_pim_viewEmployeeList")
    WebElement _employeeListLink;

    private static final Logger log = LogManager.getLogger(PIMMenu.class.getName());

    //mouse over PIM
    public void mouseOverPIM() {
        log.info("Mouse Over PIM");
        mouseOver(_pimMenu);
    }

    //click on add employee link
    public void clickOnAddEmployee() {
        log.info("Click on Add Employee");
        clickOnElement(_addEmployeeLink);
    }

    //click on employee list link
    public void clickOnEmployeeList() {
        log.info("Click on Employee List");
        clickOnElement(_employeeListLink);
    }

}
