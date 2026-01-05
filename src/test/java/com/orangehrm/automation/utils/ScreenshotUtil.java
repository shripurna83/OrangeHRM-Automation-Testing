package com.orangehrm.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String screenshotName) {

        if (driver == null) {
            System.out.println("Driver is null. Screenshot not taken.");
            return;
        }

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        File dest = new File(
                "target/screenshots/" + screenshotName + "_" + timestamp + ".png"
        );

        try {
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot saved: " + dest.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
