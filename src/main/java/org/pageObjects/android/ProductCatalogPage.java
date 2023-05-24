package org.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.actions.AndroidActions;

import java.util.List;

public class ProductCatalogPage extends AndroidActions {
    AndroidDriver driver;
    //constructor
    public ProductCatalogPage(AndroidDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
    private List<WebElement> addToCart;

    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement CartICon;
    public void addItemByIndex(int index){
        addToCart.get(index).click();
    }

    public CartPage goToCart() throws InterruptedException {
        CartICon.click();
        Thread.sleep(2000);
        return new CartPage(driver);
    }
}
