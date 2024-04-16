package com.erk.pages;


import com.erk.utilities.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class CalculatorPage {

    public CalculatorPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver("calculatorPlatform")), this);
        // new AppiumFieldDecorator allow as tu use  @AndroidFindBy annotation
    }

    @AndroidFindBy(accessibility = "multiply")
    public WebElement multiply;

    @AndroidFindBy(accessibility = "divide")
    public WebElement divide;
    @AndroidFindBy(accessibility = "plus")
    public WebElement plus;

    @AndroidFindBy(accessibility = "equals")
    public WebElement equals;

    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    public WebElement result;


    public void Multiply(){
        multiply.click();
    }


    public void clickSingleDigit(int digit) {

        String id = "com.google.android.calculator:id/digit_" + digit;
        WebElement number =Driver.getDriver("calculatorPlatform"). findElement(By.id(id));
        number.click();
    }


}
