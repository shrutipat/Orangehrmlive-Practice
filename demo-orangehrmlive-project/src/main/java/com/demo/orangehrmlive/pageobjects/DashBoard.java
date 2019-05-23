package com.demo.orangehrmlive.pageobjects;

import com.demo.orangehrmlive.utility.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DashBoard extends Util {

    private static final Logger log = LogManager.getLogger(DashBoard.class.getName());

    //verify that user is on dashboard page
    public boolean verifyThatUserIsOnDashBoardPage() {
        log.info("verify that user is on dashboard page");
        if (driver.getCurrentUrl().contains("dashboard")) {
            return true;
        } else {
            return false;
        }
    }
}
