package com.erk.utilities;


import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Driver {
    private static AppiumDriver driver;
    private static URL url;

    private static UiAutomator2Options caps=new UiAutomator2Options();

    private Driver() {
    };

    public static AppiumDriver getDriver(String platformType) {

        String platform = ConfigurationReader.getProperty(platformType);
        if (Objects.isNull(driver)) {
            switch (platform) {
                case "android-calculator":
                    caps.setApp("https://cybertek-appium.s3.amazonaws.com/calculator.apk");
                    try {
                        url = new URL("http://localhost:4723");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    driver = new AndroidDriver(url, caps);
                    break;
                case "local-android-swaglabs":
//                    caps.setApp("C:\\Users\\Data\\IdeaProjects\\Appium_Mobile\\swaglabsApp.apk");
//                    it might be give an error according to path, so we can use like below
                    String testDir=System.getProperty("user.dir");
                    caps.setApp(testDir+"/swaglabsApp.apk");
                    caps.setAppPackage("com.swaglabsmobileapp"); //we get this info from appium server error logs
                    caps.setAppActivity("com.swaglabsmobileapp.MainActivity"); //we get this info from appium server error logs
                    try {
                        url = new URL("http://localhost:4723");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    driver = new AndroidDriver(url, caps);
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (Objects.nonNull(driver)) {
            driver.quit();
            driver = null;
        }
    }
}