package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReporterNG {
    private static ExtentReports extent;

    public static ExtentReports getReportObject() {
        if (extent != null) {
            return extent;
        }

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String timeStampedReportPath = System.getProperty("user.dir") + "\\reports\\" + timeStamp + "\\index.html";
        String latestReportPath = System.getProperty("user.dir") + "\\Maven-reports\\Extent.html";

        ExtentSparkReporter timeStampedReporter = new ExtentSparkReporter(timeStampedReportPath);
        ExtentSparkReporter latestReporter = new ExtentSparkReporter(latestReportPath);

        timeStampedReporter.config().setReportName("Web Automation Results");
        timeStampedReporter.config().setDocumentTitle("Test Results");
        latestReporter.config().setReportName("Web Automation Results");
        latestReporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(timeStampedReporter, latestReporter);
        extent.setSystemInfo("Tester", "Adarsh");
        return extent;
    }
}

