package com.bookmyshow.pom.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.bookmyshow.pom.base.BasePage;
import com.bookmyshow.pom.testcases.base.BaseTest;
import com.bookmyshow.pom.testcases.base.ThreadLocalDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MovieTicketBooking extends BaseTest  {
	

	
	public static void SelectEngLang(ExtentTest test) throws Exception{
		//test.log(LogStatus.INFO, "click on Letsgo");
		BasePage.click("Letsgo",test, (ThreadLocalDriver.getTLDriver()));
		
		/*test.log(LogStatus.INFO, "click on Letsgo");
		BasePage.click("Letsgo",test);*/
		
		test.log(LogStatus.INFO, "click on Skip");
		BasePage.click("Skip",test, (ThreadLocalDriver.getTLDriver()));
		
		/*test.log(LogStatus.INFO, "click on Allow");
		BasePage.click("Allow",test, driver);*/
		Thread.sleep(5000);
		
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
		
	}
	
	public static void Movies(ExtentTest test,WebDriver driver) throws Exception {		
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "click on Movies");
		BasePage.click("Movies",test, driver);
		
	    test.log(LogStatus.INFO, "Click on search url");
	    BasePage.click("searchurl",test, driver);
	   
	}
	
	public static void EnterMovieName(ExtentTest test,WebDriver driver) throws Exception {

	    test.log(LogStatus.INFO, "Enter the URL");
	    BasePage.enterText("searchurl1", "Enterurl1",test,driver);
	    
	    Thread.sleep(2500);
	    test.log(LogStatus.INFO, "Click on clickOnMovie");
	    BasePage.click("clickOnMovie",test,driver);
		}
	
	public static void EnterSecondMovieName(ExtentTest test,WebDriver driver) throws Exception {
		
	    test.log(LogStatus.INFO, "Enter the URL");
	    BasePage.enterText("searchurl1", "Enterurl",test,driver);
	    
	    Thread.sleep(2500);
	    test.log(LogStatus.INFO, "Click on clickOnMovie");
	    BasePage.click("clickOnMovie",test,driver);
		}
	
	public static void Book(ExtentTest test,WebDriver driver) throws Exception {
		Thread.sleep(2500); 
		 test.log(LogStatus.INFO, "click on book the ticket");
		 BasePage.click("Book",test,driver);
		 Thread.sleep(2500);
		}

	public static void DateTime(ExtentTest test,WebDriver driver) throws Exception {
		  
		  test.log(LogStatus.INFO, "click on the date");
		  BasePage.click("Date",test,driver);
		  
		  Thread.sleep(1500);
		  test.log(LogStatus.INFO, "Select the Time as 10:00 PM");
		  BasePage.click("Time",test,driver);
		}

	public static void Tc(ExtentTest test,WebDriver driver) throws Exception {
		  
		  test.log(LogStatus.INFO, "Click on Accept");
		  BasePage.click("Accept",test,driver);
		}

	public static void Selecttheseats(ExtentTest test,WebDriver driver) throws Exception {
	
		  test.log(LogStatus.INFO, "Select the number of seats as 2 and click to select the seats");
		  BasePage.click("SelectSeats",test,driver);
		  
		  test.log(LogStatus.INFO, "Select the seats");
		  BasePage.click("seats",test,driver);
		  
		  test.log(LogStatus.INFO, "click on pay");
		  BasePage.click("pay2",test,driver);
		}
	
	public static void Selecttheseats1(ExtentTest test,WebDriver driver) throws Exception {
		
		  test.log(LogStatus.INFO, "Select the number of seats as 2 and click to select the seats");
		  BasePage.click("SelectSeats",test,driver);
		  
		  test.log(LogStatus.INFO, "Select the seats");
		  BasePage.click("seats1",test,driver);
		  
		  test.log(LogStatus.INFO, "click on pay");
		  BasePage.click("pay2",test,driver);
		}

	public static void Details(ExtentTest test,WebDriver driver) throws Exception {	  
		 		  
	  
		 test.log(LogStatus.INFO, "Enter your email id ");
		 BasePage.enterText("Epath", "Email",test,driver);
		 
		 test.log(LogStatus.INFO, "Enter the mobile number");
		 BasePage.enterText("Npath", "number",test,driver);
		 
		 /*test.log(LogStatus.INFO, "click on pay");
		  BasePage.click("DoneM",test,driver);	*/
		 
		 Robot robot = new Robot();
		 robot.keyPress(KeyEvent.VK_ENTER);		 
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		 test.log(LogStatus.INFO, "click on pay");
		  BasePage.click("Done",test,driver);
		 
	}
	
	public static void Details1(ExtentTest test,WebDriver driver) throws Exception {	  
		  
		  
		 test.log(LogStatus.INFO, "Enter your email id ");
		 BasePage.enterText("Epath", "Email",test,driver);
		 
		 test.log(LogStatus.INFO, "Enter the mobile number");
		 BasePage.enterText("Npath", "number",test,driver);		 
		 
		/* test.log(LogStatus.INFO, "click on pay");
		  BasePage.click("DoneM1",test,driver);	*/
		 
		 Robot robot = new Robot();
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		 test.log(LogStatus.INFO, "click on pay");
		  BasePage.click("Done",test,driver);
		 
	}
	

	
}
