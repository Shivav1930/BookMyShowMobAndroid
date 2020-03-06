/*package com.bookmyshow.pom.pages;



import org.openqa.selenium.WebDriver;
import com.bookmyshow.pom.testcases.base.BaseTest;
import com.bookmyshow.pom.util.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class LoginPage extends BaseTest {
	
    public void launchApplication(ExtentTest test, WebDriver driver) throws InterruptedException {
        test.log(LogStatus.INFO, "Launch the Application");
        driver.manage().window().maximize();
        driver.get(Constants.UAT_HOMEPAGE_URL);
        Thread.sleep(1500);
        String URL = driver.getCurrentUrl();
        test.log(LogStatus.PASS, "URL opened succesfully=" + URL);
        driver.manage().deleteAllCookies();
        test.log(LogStatus.PASS, "all cookies deleted");
    }
    
   

    public void doLogin(ExtentTest test) throws IOException, InterruptedException {
        test.log(LogStatus.INFO, "Enter Valid Email Id ...");
        BasePage.enterText("Login_emailId", "loginUserName");

    }
    
    public void confirmation(ExtentTest test) throws Exception{
    		String data = driver.findElement (By.xpath("//b[contains(text(),'Confirmation Number:')]/..")).getText();
    		System.out.println(""+data);
    		FileInputStream fis = new FileInputStream("D:\\Eclips\\AutomationDimensionData\\AutomationDimensionData\\data\\ExportExcel.xlsx");
    		XSSFWorkbook workbook = new XSSFWorkbook(fis);
    		XSSFSheet sheet = workbook.getSheet("Sheet1");
    		Row row = sheet.createRow(1);
    		Cell cell = row.createCell(1);
		
    	// cell.setCellType(cell.CELL_TYPE_STRING);
		 cell.setCellValue("\n"+data);
		 FileOutputStream fos = new FileOutputStream("D:\\Eclips\\Automation6891\\data\\ExportExcel.xlsx");
		 workbook.write(fos);
		 fos.close();
		 System.out.println("END OF WRITING DATA IN EXCEL");
    }


	
	}*/