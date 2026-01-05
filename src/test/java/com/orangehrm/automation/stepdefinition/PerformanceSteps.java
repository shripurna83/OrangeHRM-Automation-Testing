package com.orangehrm.automation.stepdefinition;

import com.orangehrm.automation.base.DriverFactory;
import com.orangehrm.automation.pages.PerformancePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PerformanceSteps {

    WebDriver driver = DriverFactory.getDriver();
    PerformancePage performancePage = new PerformancePage(driver);

    @When("user navigates to Performance module")
    public void user_navigates_to_performance_module() {
        performancePage.openPerformanceModule();
    }

    @Then("user should be able to view all Performance sections")
    public void user_should_be_able_to_view_all_performance_sections() {
        Assert.assertTrue(
                performancePage.validateAllPerformanceSections(),
                "One or more Performance sections are missing"
        );
    }
}
