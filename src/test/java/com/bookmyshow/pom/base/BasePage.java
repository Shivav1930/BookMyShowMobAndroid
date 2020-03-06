package com.bookmyshow.pom.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.bookmyshow.pom.testcases.base.BaseTest;
import com.bookmyshow.pom.util.Constants;
import com.bookmyshow.pom.util.Log;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ExtentTest;

public class BasePage extends BaseTest {
	public static WebDriver driver;
	    static com.bookmyshow.pom.util.Log Log = new Log();

	    public static String readobjectRepo(String key) throws IOException {
	        String filename = "objectRepo";
	        String path = System.getProperty("user.dir") + "/data/objectRepo.properties";
	        if (path == null || path.length() == 0) {
	            path = System.getProperty("user.dir") + "/data/" + filename + ".properties";
	        }
	        Properties p = new Properties();
	        FileInputStream fs = new FileInputStream(path);
	        p.load(fs);
	        return (String) p.get(key);
	    }

	    public static String readTestData(String key) throws IOException {
	        String filename = "testData";
	        String path = System.getProperty("user.dir") + "/data/testData.properties";
	        if (path == null || path.length() == 0) {
	            path = System.getProperty("user.dir") + "/data/" + filename + ".properties";
	        }
	        Properties p = new Properties();
	        FileInputStream fs = new FileInputStream(path);
	        p.load(fs);
	        return (String) p.get(key);
	    }  
	    
	   /* public static String readTestData(String key) throws Exception
	    {
	    FileReader fr=new FileReader("D:\\Selenium\\Eclips\\BookMySHow\\data\\testData.txt");
	    BufferedReader br= new BufferedReader(fr);
	    String x=””;
	    while ((x=br.readLine()) != null)
	    {
	    System.out.println(x +”\n”);
	    }
	    br.close();
	    }
*/
	    
	    /*public static Map<String,  Map<String, String>> setMapData() throws IOException {
	        //String path = System.getProperty("user.dir") + "/data/testData.xlsx";
	          String path = "data/testData.xlsx";
	          FileInputStream fis = new FileInputStream(path);
	          Workbook workbook = new XSSFWorkbook(fis);
	          Sheet sheet = workbook.getSheet("Sheet1");
	          int lastRow = sheet.getLastRowNum();
	          Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String,String>>();
	          Map<String, String> dataMap = new HashMap<String, String>();
	          //Looping over entire row
	          for(int i=0; i<=lastRow; i++){
	          Row row = sheet.getRow(i);
	          //1st Cell as Value
	          Cell valueCell = row.getCell(1);
	          //0th Cell as Key
	          Cell keyCell = row.getCell(0);
	          String key = keyCell.getStringCellValue().trim();
	         // String value = valueCell.getNumericCellValue().trim();
	         
	          if(valueCell.getCellType() == CellType.STRING) {
	          String value = valueCell.getStringCellValue().trim();
	          dataMap.put(key, value);        
	          }else {      
	          Integer value1 = (int) valueCell.getNumericCellValue();
	          String value = Integer.toString(value1);
	          dataMap.put(key, value);
	          }
	         
	         
	          if(valueCell.getCellType() == CellType.STRING) {
	          String value = valueCell.getStringCellValue().trim();
	          dataMap.put(key, value);        
	          }else {
	          Double intValue = valueCell.getNumericCellValue();
	          String value = Double.toString(intValue);
	          dataMap.put(key, value);
	          }
	          
	        //Putting key & value in dataMap
	         
	          //Putting dataMap to excelFileMap
	          excelFileMap.put("DataSheet", dataMap);
	          }
	        //Returning excelFileMap
	        return excelFileMap;
	        }
	       
	        //Method to retrieve value
	        public static String readTestData(String key) throws IOException{
	        Map<String, String> m = setMapData().get("DataSheet");
	        String value = m.get(key);
	       
	        return value;
	       
	        }*/


	    /* This Method verifies whether an element is present on the respective page of an application
	     * by providing locator directly,
	     * if yes it will return true,
	     * otherwise it will return false.
	     */

	    public static void reportFailure(String failureMessage) {
	        startExtent.log(LogStatus.FAIL, failureMessage);
	        takeScreenShot();
	        Assert.fail(failureMessage);
	    }    
	    
	    // Cucumber click
	    public static void click(String xpath, ExtentTest test, WebDriver driver) throws IOException, InterruptedException {
	        try {
	            waitForPresenceAndVisibilityOfElementry(readobjectRepo(xpath),driver);
	           WebElement ele = driver.findElement(By.xpath(readobjectRepo(xpath)));
	            
	           test.log(LogStatus.PASS, "Click on  '" + ele.getText() + "' is successful");
	            ele.click();
	            Thread.sleep(1000);
	        } catch (Exception e) {
	            e.printStackTrace();
	            reportFailure("Click on element is unsucessful");
	        }
	    }

	    public static void enterText(String key, String data,ExtentTest test, WebDriver driver) throws IOException, InterruptedException {
	        try {
	            waitForPresenceAndVisibilityOfElementry(readobjectRepo(key),driver );
	            WebElement ele = driver.findElement(By.xpath(readobjectRepo(key)));
	            ele.clear();
	            Thread.sleep(150);
	            ele.sendKeys(readTestData(data));
	            test.log(LogStatus.PASS, "Entering  data.. " + readTestData(data) + " is sucessful");
	            Thread.sleep(400);
	        } catch (Exception e) {
	            e.printStackTrace();
	            reportFailure("Click on element is unsucessful");
	        }
	    }
	    
	    
	    public static void click1(String xpath) throws IOException, InterruptedException {
	        try {
	            waitForPresenceAndVisibilityOfElementry1(readobjectRepo(xpath));
	           WebElement ele = driver.findElement(By.xpath(readobjectRepo(xpath)));
	            
	           startExtent.log(LogStatus.PASS, "Click on  '" + ele.getText() + "' is successful");
	            ele.click();
	            Thread.sleep(1000);
	        } catch (Exception e) {
	            e.printStackTrace();
	            reportFailure("Click on element is unsucessful");
	        }
	    }
	    
	    public static void enterText1(String key, String data) throws IOException, InterruptedException {
	        try {
	            waitForPresenceAndVisibilityOfElementry1(readobjectRepo(key));
	            WebElement ele = driver.findElement(By.xpath(readobjectRepo(key)));
	            //ele.click();
	            ele.clear();
	            Thread.sleep(1200);
	            ele.sendKeys(readTestData(data));
	            startExtent.log(LogStatus.PASS, "Entering  data.. " + readTestData(data) + " is sucessful");
	            Thread.sleep(1200);
	        } catch (Exception e) {
	            e.printStackTrace();
	            reportFailure("Click on element is unsucessful");
	        }
	    }
	    
	    public static boolean waitForPresenceAndVisibilityOfElementry1(String value) throws Exception {
	        boolean status = false;
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        List<WebElement> ele;
	        try {
	            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(value)));
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
	            ele = driver.findElements(By.xpath(value));
	            if (ele.size() == 1) {
	                status = true;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return status;
	    }

	    public static void waitForPageLoad() {
	        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    }

	    /*This method used to capture the screenshots whenever it is necessary while automating an application
	     * By using class Date-->a specific instant in time, with millisecond precision.
	     * After taking the screenshot store it in source file and create the target file,
	     * copy the file from source to target file.
	     */
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
	    }

	    public static boolean waitForPresenceAndVisibilityOfElementry(String value, WebDriver driver) throws Exception {
	        boolean status = false;
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        List<WebElement> ele;
	        try {
	            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(value)));
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
	            ele = driver.findElements(By.xpath(value));
	            if (ele.size() == 1) {
	                status = true;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return status;
	    }


	    /*This method used to reporting the failure message
	     * when the testCase fails and take the screenshot
	     * by using Assert.fail() to fail the test case with failure message.
	     */

	    public static void selectElementByVisibleText(String xpath, String testData,WebDriver driver ) throws Exception {
	        boolean status = false;
	        try {
	            waitForPresenceAndVisibilityOfElementry(readobjectRepo(xpath),driver);
	            WebElement element = driver.findElement(By.xpath(readobjectRepo(xpath)));
	            List<WebElement> List = element.findElements(By.tagName("option"));
	            for (WebElement option : List) {
	                if (readTestData(testData).equals(option.getText())) {
	                    Thread.sleep(1500);
	                    option.click();
	                    status = true;
	                    Thread.sleep(1500);
	                    startExtent.log(LogStatus.PASS, "Selection of Item in Drop down is successful");
	                    Log.info("Selection of Item in Drop down is successful");
	                    break;
	                }
	            }
	            startExtent.log(LogStatus.PASS, "Selected '" + readTestData(testData) + "' from DropDown");
	        } catch (Exception e) {
	            startExtent.log(LogStatus.FAIL, "Selection of Item in Drop down is unsuccessful");
	            Log.error("Selection of Item in Drop down is unsuccessful");
	            e.printStackTrace();
	            reportFailure("Item is not selected ");
	        }
	    }

	    public boolean isElementPresent(String locator) {
	        startExtent.log(LogStatus.INFO, "Trying to find an element -> " + locator);
	        try {
	            int s = driver.findElements(By.xpath(locator)).size();
	            if (s == 0) {
	                reportFailure("Element NOT found");
	                return false;
	            } else {
	                startExtent.log(LogStatus.INFO, "Element found");
	                return true;
	            }
	        } catch (NoSuchElementException e) {
	            e.printStackTrace();
	            reportFailure("Element NOT found");
	            return false;
	        } catch (Exception e) {
	            e.printStackTrace();
	            reportFailure("Element NOT found");
	            return false;
	        }

	    }

	    /* This Method verifies whether a WebElement is present on the respective page of an application
	     * if yes it will return true,
	     * otherwise it will return false.
	     */
	    public boolean isElementPresentWeb(WebElement ele) {
	        startExtent.log(LogStatus.INFO, "Trying to find an element -> " + ele);
	        try {
	            boolean s;
	            s = ele.isDisplayed();
	            if (s) {

	                startExtent.log(LogStatus.INFO, "Element found");
	                return true;
	            } else {
	                reportFailure("Element NOT found");
	                return false;
	            }
	        } catch (NoSuchElementException e) {
	            e.printStackTrace();
	            reportFailure("Element NOT found");
	            return false;
	        } catch (Exception e) {
	            e.printStackTrace();
	            reportFailure("Element NOT found");
	            return false;
	        }


	    }

	    /*This method used to select the value from the dropDown
	     * by using Select class and creating object.
	     * By using selectByVisibleText(value) selecting the value from the particular category.
	     */

	    /* This Method returns the Date format,
	     * upCasting is done here
	     * by using DateFormat abstract class
	     *  subclass SimpleDateFormat object
	     *  SimpleDateFormat(allows for formatting (i.e., date → text), parsing (text → date), and normalization.)
	     */
	    public String getCurrentSystemDate() {
	        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	        Date date = new Date();
	        //System.out.println(dateFormat.format(date));
	        return dateFormat.format(date);
	    }

	    public int randomGenerator() {
	        Random randomObj = new Random();
	        int randomNum = randomObj.nextInt();
	        return randomNum;
	    }

	    /* This Method verifies whether an element is present on the respective page of an application
	     * by providing locator directly,
	     * if yes it will return true,
	     * otherwise it will return false.
	     */
	    public boolean isElementPresent1(String locator) {
	        startExtent.log(LogStatus.INFO, "Trying to find an element -> " + locator);
	        int s = driver.findElements(By.xpath(locator)).size();
	        if (s == 0) {
	            reportFailure("Element not found");
	            return false;
	        } else {
	            startExtent.log(LogStatus.INFO, "Element found");
	            return true;
	        }

	    }

	    /*This method used to reporting the success message
	     * when the testCase pass and take the screenshot
	     *  if screenshot is captured successfully.
	     */
	    public void reportPass(String successMessage) {
	        startExtent.log(LogStatus.PASS, successMessage);
	        takeScreenShot();

	    }

	    /*This method used to wait until an element found
	     * and verifies whether an element is present or not
	     * if yes it will not execute the further statements
	     * otherwise it increment the second by 1 and second should be less than the time mentioned.
	     */
	    public void WaitForElementPresent(String objname)
	            throws Exception {
	        int time = 50;
	        int second = 0;

	        try {
	            do {
	                Thread.sleep(1000);
	                if (isElementPresent(objname)) {
	                    break;
	                } else {
	                    second = second + 1;
	                    Thread.sleep(1000);
	                }
	            } while (second < time);
	        } catch (Exception e) {
	        }
	    }

	    public void selectElementByValue(WebElement selectCategory, String value) {
	        WebElement mySelectElement = selectCategory;
	        Select dropdown = new Select(mySelectElement);
	        dropdown.selectByValue(value);
	        startExtent.log(LogStatus.INFO, "Selected " + value + " from DropDown");
	    }

	    /**
	     * navigateBack method navigates to the previous web page
	     *
	     * @author Ta3s
	     */
	    public void navigateBack() throws Exception {
	        boolean IsSuccess = false;
	        try {
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("window.history.go(-1)");
	            IsSuccess = true;
	            startExtent.log(LogStatus.PASS, " Navigating back to the previous screen is success");
	            Log.info(" Navigating back to the previous screen is success");
	        } catch (Exception e) {
	            startExtent.log(LogStatus.FAIL, " Navigating back to the previous screen is not successful");
	            com.bookmyshow.pom.util.Log.error(" Navigating back to the previous screen is not successful");
	        }
	        Assert.assertTrue(IsSuccess, "Navigating back to the previous screen is success");
	    }

	    public void switchWindow() throws Exception {
	        boolean status = false;
	        try {
	            String windowHandles = driver.getWindowHandle();
	            System.out.println(windowHandles);
	            driver.switchTo().window(windowHandles);
	            Thread.sleep(4000);
	            status = true;
	            startExtent.log(LogStatus.PASS, "Switching window is successful");
	            com.bookmyshow.pom.util.Log.info("Switching window is successful");
	        } catch (Exception e) {
	            startExtent.log(LogStatus.FAIL, "Switching window is not successful");
	            Log.error("Switching window is not successful");
	            e.printStackTrace();
	        }
	        Assert.assertTrue(status, "Switching window is successful");
	    }
	    
	}