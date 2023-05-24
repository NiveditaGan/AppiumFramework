package org.utils.actions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class AppiumActions {
    AppiumDriver driver;

    public void waitForElementToAppear(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains((ele), "text", "Cart"));
    }

    public static List<HashMap<String,String>> getJSONData(String jsonFilePath) throws IOException {
        List<HashMap<String,String>> data;
        // convert json content into string
        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath));

        //convert content from the string into hash map
        ObjectMapper mapper = new ObjectMapper();
        data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }

}
