package com.erk.pages;

import com.erk.utilities.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SwagLabAppPage {
    public SwagLabAppPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver("local_swagPlatform")), this);
    }

    @AndroidFindBy(accessibility ="test-Username" )
    public WebElement username;

    @AndroidFindBy(accessibility ="test-Password" )
    public WebElement password;

    @AndroidFindBy(accessibility ="test-LOGIN" )
    public WebElement loginButton;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc='test-Item title'])[1]")
    public WebElement sampleItem;


}
