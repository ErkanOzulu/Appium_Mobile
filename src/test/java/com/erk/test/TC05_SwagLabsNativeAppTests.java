package com.erk.test;

import com.erk.pages.SwagLabAppPage;
import com.erk.utilities.ConfigurationReader;
import com.erk.utilities.Driver;
import com.erk.utilities.MobileUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class TC05_SwagLabsNativeAppTests {

    String username= ConfigurationReader.getProperty("sauce.lab.userName=standard_user");
    String password=ConfigurationReader.getProperty("password.sauce.lab");


    @Test
    public void SıgnInTest(){

        AppiumDriver driver= Driver.getDriver("local-swagPlatform");
        driver.findElement(new AppiumBy.ByAccessibilityId("test-Username")).sendKeys(username);
        driver.findElement(new AppiumBy.ByAccessibilityId("test-Password")).sendKeys(password);
        driver.findElement(new AppiumBy.ByAccessibilityId("test-LOGIN")).click();

        MobileUtils.wait(3);


        WebElement aSampleUnit=driver.findElement(By.xpath("(//android.widget.TextView[@content-desc='test-Item title'])[1]"));


        Assertions.assertTrue(aSampleUnit.getText().contains("Sauce"));

        System.out.println(((AndroidDriver) driver).getDeviceTime());
        Driver.closeDriver();
    }

    @Test
    public void SıgnInTestWithPOM(){

        SwagLabAppPage page =new SwagLabAppPage();
        page.username.sendKeys(username);
        page.password.sendKeys(password);
        page.loginButton.click();

        MobileUtils.wait(3);

        Assertions.assertTrue(page.sampleItem.getText().contains("Sauce"));

        Driver.closeDriver();
    }

}
