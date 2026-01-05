package com.orangehrm.automation.utils;

import java.util.Random;

public class TestUtils {

    public static String generateEmployeeId() {
        Random random = new Random();
        int empId = 100000 + random.nextInt(900000); // 6-digit ID
        return String.valueOf(empId);
    }
}
