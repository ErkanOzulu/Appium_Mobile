package com.erk.test;

import com.erk.pages.CalculatorPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TC03CalculatorPOMTest {

    CalculatorPage calculatorPage=new CalculatorPage();

    @Test
    public void multiplyTest() {


        calculatorPage.clickSingleDigit(5);
        calculatorPage.multiply.click();
        calculatorPage.clickSingleDigit(8);
        calculatorPage.equals.click();

        String actualResult=calculatorPage.result.getText();
        System.out.println("actualResult = " + actualResult);

        assertEquals(40,Integer.parseInt(actualResult));

/*
to solve unknown server error
    adb uninstall io.appium.uiautomator2.server
    adb uninstall io.appium.uiautomator2.server.test
 */


    }
}
