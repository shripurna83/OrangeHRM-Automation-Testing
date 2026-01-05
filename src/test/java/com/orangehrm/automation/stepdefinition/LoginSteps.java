package com.orangehrm.automation.stepdefinition;

import com.orangehrm.automation.base.DriverFactory;
import com.orangehrm.automation.pages.DashboardPage;
import com.orangehrm.automation.pages.LoginPage;
import com.orangehrm.automation.utils.ConfigReader;
import com.orangehrm.automation.utils.ScreenshotUtil;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;

public class LoginSteps {

    // ✅ Single driver reference for this class
    private WebDriver driver;

    LoginPage loginPage;
    DashboardPage dashboardPage;
    Properties prop;

    @Given("user opens OrangeHRM application")
    public void user_opens_orange_hrm_application() {

        // ✅ Always fetch fresh driver from DriverFactory
        driver = DriverFactory.getDriver();

        prop = new ConfigReader().initProperties();
        driver.get(prop.getProperty("url"));

        loginPage = new LoginPage(driver);
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        loginPage.enterUsername(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("password"));
    }

    @And("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.clickLoginButton();
        dashboardPage = new DashboardPage(driver);
    }

    @Then("user should see dashboard")
    public void user_should_see_dashboard() {
        Assert.assertTrue(
                loginPage.isDashboardDisplayed(),
                "Dashboard is NOT displayed after Login"
        );
    }

    @Then("user should see all left side menu options")
    public void validate_left_menu_options() {
        if (!dashboardPage.areAllMenuItemsVisible()) {
            ScreenshotUtil.takeScreenshot(driver, "Missing_Menu");
            Assert.fail("One or more left side menus are missing. Screenshot captured.");
        }
    }

    @Then("user clicks each left menu and validates page header")
    public void user_clicks_each_left_menu_and_validates_page_header() {
        dashboardPage.clickMenuAndValidateHeader("Admin", "Admin");
        dashboardPage.clickMenuAndValidateHeader("PIM", "PIM");
        dashboardPage.clickMenuAndValidateHeader("Leave", "Leave");
        dashboardPage.clickMenuAndValidateHeader("Time", "Time");
        dashboardPage.clickMenuAndValidateHeader("Recruitment", "Recruitment");
        dashboardPage.clickMenuAndValidateHeader("My Info", "PIM");
        dashboardPage.clickMenuAndValidateHeader("Performance", "Performance");
        dashboardPage.clickMenuAndValidateHeader("Directory", "Directory");
    }
}
