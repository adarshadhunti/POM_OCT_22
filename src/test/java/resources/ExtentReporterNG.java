package resources;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
    static ExtentReports extent;

    public static ExtentReports getReportObject()
    {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String path =System.getProperty("user.dir")+"\\reports\\"+ timeStamp +"\\index.html";
        String path1 =System.getProperty("user.dir")+"\\Maven-reports\\"+ "\\Extent.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        ExtentSparkReporter reporter1 = new ExtentSparkReporter(path1);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        reporter1.config().setReportName("Web Automation Results");
        reporter1.config().setDocumentTitle("Test Results");
        extent =new ExtentReports();
        extent.attachReporter(reporter,reporter1);
        extent.setSystemInfo("Tester", "Adarsh");
        return extent;

    }
}