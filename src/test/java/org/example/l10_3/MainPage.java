package org.example.l10_3;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class MainPage {

    @AndroidFindBy (id = "android:id/content")
    private WebElement content;

    public boolean contentCheck(){
       return content.isEnabled();
    }

    public MainPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
