package org.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.actions.AndroidActions;

public class FormPage extends AndroidActions {
    AndroidDriver driver;
    //constructor
    public FormPage(AndroidDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    //AppiumBy.xpath("//android.widget.RadioButton[@text='Female']")
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
    private WebElement femaleOption;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
    private WebElement maleOption;

    @AndroidFindBy(id="android:id/text1")
    private WebElement selectCountrydropdown;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));")
    private WebElement scrollCounterydropdown;

    private String countryNameString = "//android.widget.TextView[@text='{}']";
    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private WebElement submittn;

    public void submit(){
        submittn.click();
    }

    public void setNameField(String text){
        nameField.sendKeys(text);
        driver.hideKeyboard();
    }

    public void setGenderOption(String gender){
        if (gender.contains("female")){
            femaleOption.click();
        }else if(gender.contains("male")){
            maleOption.click();
        }
    }

    public void setCountry(String countryName){
        selectCountrydropdown.click();
        scrollToText(countryName);
        setDynamicXPATH(countryNameString, countryName).click();

    }

    public WebElement setDynamicXPATH(String objectName, String text){
            return driver.findElement(By.xpath(objectName.replaceAll("\\{\\}", text)));
    }

    public void setActivity(){

    }
}