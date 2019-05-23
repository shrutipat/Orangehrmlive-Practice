package com.demo.orangehrmlive.testbase;

import com.demo.orangehrmlive.basepage.BasePage;
import com.demo.orangehrmlive.browserselector.BrowserSelector;
import com.demo.orangehrmlive.property.LoadProperty;
import com.demo.orangehrmlive.utility.Util;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase extends BasePage {
    BrowserSelector browserSelector = new BrowserSelector();
    LoadProperty loadProperty = new LoadProperty();
    String browser = loadProperty.getProperty("browser");
    String baseUrl = loadProperty.getProperty("baseUrl");
    String time = loadProperty.getProperty("time");

    @BeforeClass
    public static void setUpBeforeClass() {
        PropertyConfigurator.configure("C:\\Users\\Archita\\IdeaProjects\\demo-orangehrmlive-project\\src\\test\\java\\com\\demo\\orangehrmlive\\resources\\configfiles\\log4j.properties");
    }

    @BeforeMethod
    public void setUp() {
        browserSelector.selectBrowser(browser);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.valueOf(time), TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            new Util().takeScreenShot(testResult.getName());
        }
        driver.quit();
    }
}