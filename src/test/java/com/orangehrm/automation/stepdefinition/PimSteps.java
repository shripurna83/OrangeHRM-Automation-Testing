package com.orangehrm.automation.stepdefinition;

import com.orangehrm.automation.base.DriverFactory;
import com.orangehrm.automation.pages.PimPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PimSteps {

    private WebDriver driver;
    private PimPage pimPage;

    @When("user navigates to PIM")
    public void user_navigates_to_pim() {
        driver = DriverFactory.getDriver();   //  correct
        pimPage = new PimPage(driver);
        pimPage.openPimModule();
    }

    @And("user adds a new employee")
    public void user_adds_a_new_employee() {
        pimPage.addEmployee("Swastik", "Mishra");
    }

    @Then("employee should be created successfully")
    public void employee_should_be_created_successfully() {
        Assert.assertTrue(
                pimPage.isEmployeeCreated(),
                "Employee was NOT created successfully"
        );
    }
}
