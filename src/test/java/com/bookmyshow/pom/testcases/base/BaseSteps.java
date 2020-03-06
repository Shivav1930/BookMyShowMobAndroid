package com.bookmyshow.pom.testcases.base;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseSteps {

	protected AndroidDriver<MobileElement> driver;
    protected WebDriverWait wait;
    
    protected void setupCucumber () {
       
        //Get driver to use step files
        driver = ThreadLocalDriver.getTLDriver();
        wait = new WebDriverWait(driver, 10);
       
    }
 
    protected void teardown(){
        driver.quit();
    }
    
}
