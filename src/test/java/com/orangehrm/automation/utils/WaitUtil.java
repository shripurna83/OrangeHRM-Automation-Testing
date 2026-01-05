package com.orangehrm.automation.utils;

public class WaitUtil {

    public static void hardWait(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
