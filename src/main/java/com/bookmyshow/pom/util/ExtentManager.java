package com.bookmyshow.pom.util;

//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html


import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
            String date1= dateFormat.format(date);
            //String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".html";
            String fileName="index"+".html";

            String reportPath = Constants.REPORTS_PATH + fileName;

            extent = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);
            extent.loadConfig(new File(System.getProperty("user.dir") + "/config/ReportsConfig.xml"));
            // optional
            extent.addSystemInfo("Selenium Version", "2.53.0").addSystemInfo(
                    "Environment", Constants.ENV).addSystemInfo("Qa","Shiva");
        }
        return extent;
    }
}
