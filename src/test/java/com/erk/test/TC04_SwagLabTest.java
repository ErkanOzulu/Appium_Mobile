package com.erk.test;


import com.erk.utilities.ConfigurationReader;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;


public class TC04_SwagLabTest extends WebAppTestBase {


//appium --allow-insecure chromedriver_autodownload   to get chrome version without any issue
    @Test
    public void test() {

        driver.get("http://saucedemo.com/v1/");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("user-name")).sendKeys(ConfigurationReader.getProperty("sauce.lab.userName"));
        driver.findElement(By.id("password")).sendKeys(ConfigurationReader.getProperty("password.sauce.lab"));
        driver.findElement(By.id("login-button")).click();
        List<WebElement> productList = driver.findElements(By.cssSelector(".inventory_item.name"));

        for (WebElement eachProduct : productList) {
            System.out.println(eachProduct.getText());
            if (eachProduct.getText().contains("Test")){

                Assertions.assertTrue(eachProduct.getText().toLowerCase().contains("t-hirt"));
            }
        }

        //lets scroll down to last product
        Actions actions=new Actions(driver);

        WebElement lastProduct=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[6]"));
        actions.moveToElement(lastProduct).perform();


        // to scroll down we are using a method like in Selenium we had JSE
//        driver.findElement(AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Policy\"));"));




        driver.quit();
    }


}
