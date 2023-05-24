package testScripts;

import org.pageObjects.android.CartPage;
import org.pageObjects.android.FormPage;
import org.pageObjects.android.ProductCatalogPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.utils.actions.AppiumActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class testFillForm extends BaseTest{
    CartPage objCart;
    @Test(dataProvider = "getData")
    public void testFillForm(HashMap <String, String> input) throws InterruptedException {
        FormPage formPage =new FormPage(driver);
        formPage.setNameField(input.get("name"));
        formPage.setGenderOption(input.get("gender"));
        formPage.setCountry(input.get("country"));
        formPage.submit();
        ProductCatalogPage productPage = new ProductCatalogPage(driver);
        productPage.addItemByIndex(0);
        productPage.addItemByIndex(0);
        objCart = productPage.goToCart();
        objCart.checkTermsCond();
        objCart.purchase();
    }
    @DataProvider
    public Object[][] getData() throws IOException {
        List< HashMap<String, String>> data = AppiumActions.getJSONData("//Users//niveditagan//IdeaProjects//MobileAutomationFramework//src//test//java//testData//TestData.json");
        return new Object[] []{{data.get(0)}};
    }
}
