package com.orangehrm.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyInfoPage {

    WebDriver driver;
    WebDriverWait wait;

    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===== LEFT MENU =====
    private By myInfoMenu = By.xpath("//span[text()='My Info']");

    // ===== SUB MENU ITEMS =====
    private By personalDetails = By.xpath("//a[text()='Personal Details']");
    private By contactDetails = By.xpath("//a[text()='Contact Details']");
    private By emergencyContacts = By.xpath("//a[text()='Emergency Contacts']");
    private By dependents = By.xpath("//a[text()='Dependents']");
    private By immigration = By.xpath("//a[text()='Immigration']");
    private By job = By.xpath("//a[text()='Job']");
    private By salary = By.xpath("//a[text()='Salary']");
    private By taxExemptions = By.xpath("//a[text()='Tax Exemptions']");
    private By qualifications = By.xpath("//a[text()='Qualifications']");
    private By memberships = By.xpath("//a[text()='Memberships']");

    // ===== COMMON HEADER (VERY STABLE) =====
    private By pageHeader =
            By.xpath("//h6[contains(@class,'orangehrm-main-title')]");

    // ===== ACTION METHODS =====

    public void openMyInfoModule() {
        wait.until(ExpectedConditions.elementToBeClickable(myInfoMenu)).click();
    }

    public void clickIfPresent(By menuItem, String sectionName) {
        try {
            if (driver.findElements(menuItem).size() > 0) {
                wait.until(ExpectedConditions.elementToBeClickable(menuItem)).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader));
                System.out.println("✔ " + sectionName + " section loaded");
            } else {
                System.out.println("⚠ " + sectionName + " section not available for this user");
            }
        } catch (Exception e) {
            System.out.println(" Issue loading section: " + sectionName);
            throw e;
        }
    }

    public void validateAllMyInfoSections() {

    clickIfPresent(personalDetails, "Personal Details");
    clickIfPresent(contactDetails, "Contact Details");
    clickIfPresent(emergencyContacts, "Emergency Contacts");
    clickIfPresent(dependents, "Dependents");
    clickIfPresent(immigration, "Immigration");
    clickIfPresent(job, "Job");
    clickIfPresent(salary, "Salary");
    clickIfPresent(taxExemptions, "Tax Exemptions");
    clickIfPresent(qualifications, "Qualifications");
    clickIfPresent(memberships, "Memberships");
}

}
