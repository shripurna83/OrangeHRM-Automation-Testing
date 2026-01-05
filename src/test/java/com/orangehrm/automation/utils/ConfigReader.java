package com.orangehrm.automation.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    Properties prop;

    public Properties initProperties() {
        prop = new Properties();
        try {
            FileInputStream ip =
                    new FileInputStream("src/test/resources/config/config.properties");
            prop.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }
}
