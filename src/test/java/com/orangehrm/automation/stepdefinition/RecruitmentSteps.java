package com.orangehrm.automation.stepdefinition;

import com.orangehrm.automation.base.DriverFactory;
import com.orangehrm.automation.pages.RecruitmentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RecruitmentSteps {

    WebDriver driver = DriverFactory.getDriver();
    RecruitmentPage recruitmentPage = new RecruitmentPage(driver);

    // ================= CANDIDATE STEPS =================

    @And("user navigates to Recruitment module")
    public void user_navigates_to_recruitment_module() {
        recruitmentPage.openRecruitmentModule();
    }

    @And("user adds a new candidate without document upload")
    public void user_adds_candidate_without_document() {
        recruitmentPage.clickAddCandidate();
        recruitmentPage.addCandidateDetails();
    }

    @Then("candidate should be added successfully")
    public void candidate_should_be_added_successfully() {
        Assert.assertTrue(recruitmentPage.isCandidateAdded(),
                "Candidate was NOT added successfully");
    }

    // ================= VACANCY STEPS (NEW) =================

    @And("user navigates to Vacancies section")
    public void user_navigates_to_vacancies_section() {
        recruitmentPage.openVacanciesTab();
    }

    @And("user adds a new vacancy using existing job title")
    public void user_adds_new_vacancy_using_existing_job_title() {

        recruitmentPage.clickAddVacancy();

        String selectedJobTitle = recruitmentPage.selectExistingJobTitle();

        recruitmentPage.enterVacancyName(selectedJobTitle);
        recruitmentPage.selectHiringManager("Eric Barnes");
        recruitmentPage.enterNumberOfPositions("2");
        recruitmentPage.saveVacancy();
    }

    @Then("vacancy should be created successfully")
    public void vacancy_should_be_created_successfully() {
        Assert.assertTrue(recruitmentPage.isVacancyCreated(),
                "Vacancy was NOT created successfully");
    }
}
