package com.orangehrm.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DashboardPage {

    WebDriver driver;
    WebDriverWait wait;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Dynamic menu locator
    private By menuItem(String menuName) {
        return By.xpath("//span[text()='" + menuName + "']");
    }

    // Page header locator
    private By pageHeader = By.xpath("//h6");

    public void clickMenuAndValidateHeader(String menuName, String expectedHeader) {

        WebElement menu = wait.until(
                ExpectedConditions.elementToBeClickable(menuItem(menuName))
        );
        menu.click();

        WebElement header = wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageHeader)
        );

        String actualHeader = header.getText();

        Assert.assertEquals(
                actualHeader,
                expectedHeader,
                "Header mismatch for menu: " + menuName
        );
    }
    public boolean areAllMenuItemsVisible() {

        String[] menuItems = {
                "Admin",
                "PIM",
                "Leave",
                "Time",
                "Recruitment",
                "My Info",
                "Performance",
                "Directory"
        };

        boolean allVisible = true;

        for (String menu : menuItems) {
            By menuLocator = By.xpath("//span[text()='" + menu + "']");
            try {
                if (!driver.findElement(menuLocator).isDisplayed()) {
                    System.out.println("Missing menu: " + menu);
                    allVisible = false;
                }
            } catch (Exception e) {
                System.out.println(" Missing menu: " + menu);
                allVisible = false;
            }
        }

        return allVisible;
    }

}
