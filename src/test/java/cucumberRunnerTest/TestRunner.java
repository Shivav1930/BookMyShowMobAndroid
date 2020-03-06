package cucumberRunnerTest;


import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.bookmyshow.pom.testcases.base.ThreadLocalDriver;
import com.cucumber.listener.ExtentProperties;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

//@RunWith(Cucumber.class) 

@CucumberOptions(
		features = "Feature",
		glue={"stepDefinition"},
		/*tags= {"@firstMovie"},*/
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"},
		monochrome = false
		)

public class TestRunner extends AbstractTestNGCucumberTests {
	public WebDriverWait wait;
	
	@BeforeClass 
	public static void report() {
		Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
        String date1= dateFormat.format(date);
        String fileName="Cucumber"+ "_" + date1;
	ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	extentProperties.setReportPath("Report/"+fileName+".html");
	}
	
	AppiumDriver<WebElement> driver;
	
	@BeforeMethod
    @Parameters({"udid", "port", "deviceName", "platformVersion"})
    public void setup (String udid, String port, String deviceName, String platformVersion) throws IOException {
        System.out.println("TestNG Before");

        //Unlock the device if it is locked.
        final Runtime rt = Runtime.getRuntime();
        rt.exec("adb shell input keyevent 224");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("udid", udid);
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.bt.bms");
        caps.setCapability("appActivity","com.movie.bms.splashscreen.SplashScreenActivity");
        
        ThreadLocalDriver.setTLDriver(new AndroidDriver(new URL("http://0.0.0.0:" + port + "/wd/hub"),caps));
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);
        
}
}
