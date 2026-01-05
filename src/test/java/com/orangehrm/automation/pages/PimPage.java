package com.orangehrm.automation.pages;

import com.orangehrm.automation.utils.TestUtils;
import com.orangehrm.automation.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PimPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PimPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By pimMenu = By.xpath("//span[text()='PIM']");
    private By addButton = By.xpath("//button[normalize-space()='Add']");
    private By firstName = By.name("firstName");
    private By lastName = By.name("lastName");

    private By employeeId =
            By.xpath("//label[text()='Employee Id']/../following-sibling::div/input");

    private By saveButton = By.xpath("//button[@type='submit']");

    // ✅ STABLE HEADER
    private By personalDetailsHeader =
            By.xpath("//h6[contains(@class,'orangehrm-main-title')]");

    public void openPimModule() {
        wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click();
    }

    public void addEmployee(String fName, String lName) {

        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
        WaitUtil.hardWait(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName))
                .sendKeys(fName);

        driver.findElement(lastName).sendKeys(lName);

        WebElement empId = wait.until(
                ExpectedConditions.visibilityOfElementLocated(employeeId)
        );
        empId.clear();
        empId.sendKeys(TestUtils.generateEmployeeId());

        driver.findElement(saveButton).click();
    }

    public boolean isEmployeeCreated() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(personalDetailsHeader)
        ).isDisplayed();
    }
}
