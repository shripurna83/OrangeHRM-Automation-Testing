package com.orangehrm.automation.stepdefinition;

import com.orangehrm.automation.base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void launchBrowser() {
        DriverFactory.initDriver();   //  creates driver
    }

    @After
    public void closeBrowser() {
        DriverFactory.quitDriver();   //  quits driver
    }
}
