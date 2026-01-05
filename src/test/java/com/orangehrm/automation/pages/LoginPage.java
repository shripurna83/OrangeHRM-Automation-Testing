package com.orangehrm.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {



    private WebDriver driver;
    private WebDriverWait wait;

    // Locators (OrangeHRM real-time locators)
    private By username = By.name("username");
    private By password = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUsername(String user) {
        WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        userField.clear();
        slowDown();
        userField.sendKeys(user);
        slowDown();
    }

    public void enterPassword(String pass) {
        WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        passField.clear();
        slowDown();
        passField.sendKeys(pass);
        slowDown();
    }

    public void clickLoginButton() {
        slowDown();
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isDashboardDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader)).isDisplayed();
    }
    private void slowDown() {
        try {
            Thread.sleep(800); // 0.8 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
