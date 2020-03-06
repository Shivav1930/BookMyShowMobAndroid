package com.bookmyshow.pom.testcases.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import cucumber.api.junit.Cucumber;
import com.bookmyshow.pom.base.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.CucumberOptions;
import io.appium.java_client.android.AndroidDriver;

import com.bookmyshow.pom.util.Constants;
import com.bookmyshow.pom.util.ExtentManager;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    public ExtentReports extent = ExtentManager.getInstance();
    public static ExtentTest startExtent;
    public DesiredCapabilities cap = null;
    //public  LoginPage loginTest;
    public  BasePage utility;
   // public BuyerDashboards buyerDashboard;

   public static WebDriver driver;
   
   
   
   
   
   
    @BeforeSuite() 
    
    public void startTest()
    {
    	 //Set up desired capabilities and pass the Android app-activity and app-package to Appium
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	capabilities.setCapability("BROWSER_NAME", "Android");
    	capabilities.setCapability("udid", "4200cc386a65847f");
    	capabilities.setCapability("deviceName","Galaxy J7 Max");
    	capabilities.setCapability("platformName","Android"); 
    	capabilities.setCapability("platformversion", "7.0"); 
    	// config the app 
    	capabilities.setCapability("appPackage","com.bt.bms");
    	capabilities.setCapability("appActivity","com.movie.bms.splashscreen.SplashScreenActivity"); 
    	
    	capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("platformversion", "7.0"); 
		capabilities.setCapability("udid", "0123456789ABCDEF");
		capabilities.setCapability("deviceName","Micromax Q4311");
		capabilities.setCapability("platformName","Android");

		capabilities.setCapability("appPackage", "com.android.chrome");
		capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
    		
    	
    	try {
    		 driver = new AndroidDriver<WebElement>(new URL ("http://0.0.0.0:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	/*loginTest =new LoginPage();
    	utility=new BasePage();*/
    }

    public WebDriver init(String bType) {
        if (Constants.LOCAL_SINGLE_BROWSER_RUN) {
            if (bType.equals("Mozilla")) {
                try {
                    //System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER_EXE);
                    System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER_EXE);
                    FirefoxProfile profile = new FirefoxProfile();
                    // i commented profile
                 //WebDriver driver = new FirefoxDriver(profile);
                 WebDriver driver = new FirefoxDriver();
                } catch (Exception e) {
                    reportFailure(bType + " Browser NOT Launched");
                }
            } else if (bType.equals("Chrome")) {
                try {
                   // System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_EXE_Linux);
                	System.setProperty("webdriver.chrome.driver",  "D:\\Eclips\\AutomationDimensionData\\AutomationDimensionData\\drivers\\chromedriver.exe");
                	ChromeOptions coptions = new ChromeOptions();
                    coptions.addArguments("--disable-extensions");
                     driver = new ChromeDriver(coptions);
                    return driver;
                } catch (Exception e) {
                    reportFailure(bType + " Browser NOT Launched");
                }
            } else if (bType.equals("IE")) {

                try {
					System.setProperty("webdriver.ie.driver",Constants.IE_DRIVER_EXE);
					driver=new  InternetExplorerDriver();

                    System.setProperty("webdriver.ie.driver", Constants.IE_DRIVER_EXE);
                    DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                    capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                    capabilities.setCapability("requireWindowFocus", true);

                    driver = new InternetExplorerDriver(capabilities);
                } catch (Exception e) {
                    reportFailure(bType + " Browser NOT Launched");
                }
            }

        } else if (!Constants.GRID_RUN) {
            if (bType.equals("Mozilla")) {
                cap = DesiredCapabilities.firefox();
                cap.setBrowserName("firefox");
                cap.setJavascriptEnabled(true);
                cap.setPlatform(org.openqa.selenium.Platform.ANY);
            } else if (bType.equals("Chrome")) {
                cap = DesiredCapabilities.chrome();
                cap.setBrowserName("chrome");
                cap.setJavascriptEnabled(true);
                cap.setPlatform(org.openqa.selenium.Platform.ANY);
            } else if (bType.equals("IE")) {
                cap = DesiredCapabilities.internetExplorer();
                cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                cap.setCapability("requireWindowFocus", true);
                cap.setCapability("enablePersistentHover", true);
                cap.setCapability("nativeEvents", false);
                cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
                cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
                cap.setPlatform(org.openqa.selenium.Platform.ANY);
            }
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
            } catch (Exception e) {
                reportFailure(bType + " Browser NOT Launched");
                e.printStackTrace();
            }
        } else {//(Constants.GRID_RUN)
            // grid
            DesiredCapabilities cap = null;
            if (bType.equals("Mozilla")) {

                //System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER_EXE_Linux);
            	System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER_EXE);
            	cap = DesiredCapabilities.firefox();
                cap.setBrowserName("firefox");
                cap.setJavascriptEnabled(true);
                cap.setPlatform(org.openqa.selenium.Platform.ANY);

            } else if (bType.equals("Chrome")) {
                //System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_EXE_Linux);
            	System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_EXE);
            	cap = DesiredCapabilities.chrome();
                cap.setBrowserName("chrome");
                cap.setPlatform(org.openqa.selenium.Platform.ANY);

            }
            try {
                driver = new RemoteWebDriver(new URL("http://hub:4444/wd/hub"), cap);

            } catch (Exception e) {
                reportFailure(bType + " Browser NOT Launched");
                e.printStackTrace();
            }
        }
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return null;
    }

	private void reportFailure(String string) {
		// TODO Auto-generated method stub
		
	}

/*    public static void reportFailure(String failureMessage) {
        startExtent.log(LogStatus.FAIL, failureMessage);
        takeScreenShot();
        Assert.fail(failureMessage);
    }

    public void reportPass(String successMessage) {
        startExtent.log(LogStatus.PASS, successMessage);
        takeScreenShot();

   } */
	
	/*public static void takeScreenShot(){
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		String filePath=Constants.REPORTS_PATH+"screenshots/"+screenshotFile;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(filePath));
			System.out.println("*********"+"../"+"test"+"******************");
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.INFO,test.addScreenCapture(filePath));
	}

    public static void takeScreenShot() {
        Date d = new Date();
        String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
        String filePath = "./screenshots/" + screenshotFile;
        // store screenshot in that file
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File targetFile = new File(Constants.REPORTS_PATH + "/screenshots", screenshotFile);

        try {
            //FileUtils.copyFile(scrFile, new File(filePath));
            FileUtils.copyFile(scrFile, targetFile);
        } catch (IOException e) {

            e.printStackTrace();
        }
        startExtent.log(LogStatus.INFO, startExtent.addScreenCapture(filePath));
    }*/
}
