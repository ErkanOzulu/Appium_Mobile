package com.erk.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class First_Test {

    @Test
    public void test1() throws MalformedURLException {

        AndroidDriver driver;
        //The default URL in appium 1 is http:/127.0.0.1:4723/wd/hub
        URL url;

        UiAutomator2Options options=new UiAutomator2Options();
        options.setApp("https://cybertek-appium.s3.amazonaws.com/calculator.apk");

        url=new URL("http://localhost:4723/");
        driver=new AndroidDriver(url,options);
        System.out.println(driver.getDeviceTime());
        driver.quit();

    }
}
