package com.bookmyshow.pom.pages;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.bookmyshow.pom.base.BasePage;
import com.bookmyshow.pom.testcases.base.BaseTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Mughal  extends BaseTest {
	
	public static  void English(ExtentTest test) throws Exception{
		test.log(LogStatus.INFO, "click on Letsgo");
		BasePage.click1("Letsgo");
		
		/*test.log(LogStatus.INFO, "click on Letsgo");
		BasePage.click("Letsgo",test);*/
		
		test.log(LogStatus.INFO, "click on Skip");
		BasePage.click1("Skip");
		
		try {
			if(driver.findElement (By.xpath("//android.widget.Button[@text='ALLOW']")) != null){	
			 	test.log(LogStatus.INFO, "Enter the Password");
				BasePage.click("ALLOW",test, driver);
			}
		
		} catch (Exception e) {
			test.log(LogStatus.INFO, "Click on submit");
			BasePage.click("Allow",test, driver);
			//e.printStackTrace();
		}
		Thread.sleep(10000);
		
	}
	
	
	public static void eventbook(ExtentTest test) throws Exception {		
		
		test.log(LogStatus.INFO, "click on Movies");
		BasePage.click1("Movies");
		
	    test.log(LogStatus.INFO, "Click on search url");
	    BasePage.click1("searchurl");
	   
	    test.log(LogStatus.INFO, "Click on search and cler the url");
	    
	    test.log(LogStatus.INFO, "Enter the URL");
	    BasePage.enterText1("searchurl1", "Enterurl");
	    
	    test.log(LogStatus.INFO, "Click on clickOnMovie");
	    BasePage.click1("clickOnMovie");
		  
		  test.log(LogStatus.INFO, "click on book the ticket");
		  BasePage.click1("Book");
		  Thread.sleep(2500);
		  
		  test.log(LogStatus.INFO, "click on the date");
		  BasePage.click1("Date");
		
		  test.log(LogStatus.INFO, "Select the Time as 10:00 PM");
		  BasePage.click1("Time");
		  
		  test.log(LogStatus.INFO, "Click on Accept");
		  BasePage.click1("Accept");
	
		  test.log(LogStatus.INFO, "Select the number of seats as 2 and click to select the seats");
		  BasePage.click1("SelectSeats");
		  
		  test.log(LogStatus.INFO, "Select the seats");
		  BasePage.click1("seats");
		  
		  test.log(LogStatus.INFO, "click on pay");
		  BasePage.click1("pay");		  
	  
		 test.log(LogStatus.INFO, "Enter your email id ");
		 BasePage.enterText1("Epath", "Email");
		 
		 test.log(LogStatus.INFO, "Enter the mobile number");
		 BasePage.enterText1("Npath", "number");
		 
		 Robot robot = new Robot();
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		 test.log(LogStatus.INFO, "click on pay");
		  BasePage.click1("Done");
		 
	}
	
	
}
	