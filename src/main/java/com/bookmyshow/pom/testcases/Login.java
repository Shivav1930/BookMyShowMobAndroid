/*package com.bookmyshow.pom.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.bookmyshow.pom.pages.Mughal;
import com.bookmyshow.pom.testcases.base.BaseTest;
import com.bookmyshow.pom.util.Log;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


public class Login extends BaseTest {
    String testCaseName = "BookMyshow";
    public String actualResult = "";

    @Test()
    public void Loging() throws Exception {startExtent=extent.startTest("End To End Scenario normal");
    Log.startLog("inventorySearch");
     Mughal.English(startExtent);
    Mughal.eventbook(startExtent);
    Log.endLog("inventorySearch");
    }
    
    @AfterMethod
    public void quit() {
        if (extent != null) {
            extent.endTest(startExtent);
            extent.flush();
        }
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                driver.quit();
            }
        }
    }
}


*/