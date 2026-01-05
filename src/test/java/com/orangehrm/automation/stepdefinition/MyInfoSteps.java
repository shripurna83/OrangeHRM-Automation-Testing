package com.orangehrm.automation.stepdefinition;

import com.orangehrm.automation.base.DriverFactory;
import com.orangehrm.automation.pages.MyInfoPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyInfoSteps {

    WebDriver driver = DriverFactory.getDriver();
    MyInfoPage myInfoPage = new MyInfoPage(driver);

    @When("user navigates to My Info module")
    public void user_navigates_to_my_info_module() {
        myInfoPage.openMyInfoModule();
    }

    @Then("user should be able to view all My Info sections")
    public void user_should_be_able_to_view_all_my_info_sections() {
        myInfoPage.validateAllMyInfoSections();
    }

}
