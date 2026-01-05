package com.orangehrm.automation.pages;

import com.orangehrm.automation.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecruitmentPage {

    WebDriver driver;
    WebDriverWait wait;

    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By recruitmentMenu = By.xpath("//span[text()='Recruitment']");
    private By addButton = By.xpath("//button[normalize-space()='Add']");

    private By firstName = By.name("firstName");
    private By lastName = By.name("lastName");
    private By email = By.xpath("//label[text()='Email']/following::input[1]");
    private By contactNo = By.xpath("//label[text()='Contact Number']/following::input[1]");

    private By vacancyDropdown = By.xpath("//label[text()='Vacancy']/following::div[1]");
    private By vacancyOption = By.xpath("//span[contains(text(),'Software Engineer')]");

    private By saveButton = By.xpath("//button[@type='submit']");

    //  STABLE HEADER AFTER SAVE
    private By candidateHeader =
            By.xpath("//h6[contains(@class,'orangehrm-main-title')]");

    // ================= VACANCIES LOCATORS =================
    private By vacanciesTab = By.xpath("//a[text()='Vacancies']");
    private By addVacancyButton = By.xpath("//button[normalize-space()='Add']");

    private By vacancyNameInput =
            By.xpath("//label[text()='Vacancy Name']/../following-sibling::div/input");

    private By jobTitleDropdown =
            By.xpath("//label[text()='Job Title']/../following-sibling::div//div[contains(@class,'select-text')]");

    private By jobTitleOptions =
            By.xpath("//div[@role='listbox']//span");


    private By numberOfPositionsInput =
            By.xpath("//label[text()='Number of Positions']/../following-sibling::div/input");

    private By vacancySaveButton =
            By.xpath("//button[@type='submit']");

    private By vacancyHeader =
            By.xpath("//h6[contains(@class,'orangehrm-main-title')]");

    // Hiring Manager autocomplete
    private By hiringManagerInput =
            By.xpath("//label[text()='Hiring Manager']/following::input[1]");

    private By hiringManagerOptions =
            By.xpath("//div[@role='listbox']//span");



    public void openRecruitmentModule() {
        wait.until(ExpectedConditions.elementToBeClickable(recruitmentMenu)).click();
    }

    public void clickAddCandidate() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    public void addCandidateDetails() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName))
                .sendKeys("Rahul");

        driver.findElement(lastName).sendKeys("Sharma");
        driver.findElement(email).sendKeys("rahul.sharma@testmail.com");
        driver.findElement(contactNo).sendKeys("9876543210");

        wait.until(ExpectedConditions.elementToBeClickable(vacancyDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(vacancyOption)).click();

        WaitUtil.hardWait(1000);
        driver.findElement(saveButton).click();
    }

    public boolean isCandidateAdded() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(candidateHeader)
        ).isDisplayed();
    }
    // ================= VACANCIES METHODS =================

    public void openVacanciesTab() {
        wait.until(ExpectedConditions.elementToBeClickable(recruitmentMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(vacanciesTab)).click();
    }

    public void clickAddVacancy() {
        wait.until(ExpectedConditions.elementToBeClickable(addVacancyButton)).click();
    }

    /**
     * Selects an existing Job Title and returns its name
     */
    public String selectExistingJobTitle() {
        wait.until(ExpectedConditions.elementToBeClickable(jobTitleDropdown)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitleOptions));

        String jobTitle =
                driver.findElements(jobTitleOptions).get(1).getText();

        driver.findElements(jobTitleOptions).get(1).click();
        return jobTitle;
    }

    public void enterVacancyName(String jobTitle) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(vacancyNameInput))
                .sendKeys(jobTitle + " Vacancy");
    }

    public void selectHiringManager(String managerName) {

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(hiringManagerInput)
        );

        input.clear();
        input.sendKeys(managerName);

        WaitUtil.hardWait(1000); // allow suggestions to load

        input.sendKeys(Keys.ARROW_DOWN);
        input.sendKeys(Keys.ENTER);
    }


    public void enterNumberOfPositions(String count) {
        driver.findElement(numberOfPositionsInput).sendKeys(count);
    }

    public void saveVacancy() {
        driver.findElement(vacancySaveButton).click();
    }

    public boolean isVacancyCreated() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(vacancyHeader)
        ).isDisplayed();
    }
    // ================= MAIN VACANCY FLOW =================
    public void addVacancy() {

        clickAddVacancy();

        String jobTitle = selectExistingJobTitle();

        enterVacancyName(jobTitle);

        selectHiringManager("Eric");   // partial name is safer

        enterNumberOfPositions("2");

        saveVacancy();
    }

}
