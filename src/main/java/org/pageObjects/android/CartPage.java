package org.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.actions.AndroidActions;

public class CartPage extends AndroidActions {
    AndroidDriver driver;
    //constructor
    public CartPage(AndroidDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
    WebElement TermsCond;

    @AndroidFindBy(id="android:id/button1")
    WebElement closeTermsCond;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
    WebElement clickPurchase;

    public void checkTermsCond(){
        longPressAction(TermsCond);
        closeTermsCond.click();
    }

    public void purchase(){
        clickPurchase.click();
    }

}
