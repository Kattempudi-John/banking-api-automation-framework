package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    public static void initializeReport() {

        ExtentSparkReporter sparkReporter =
                new ExtentSparkReporter(
                        "test-output/ExtentReport.html"
                );

        extentReports = new ExtentReports();

        extentReports.attachReporter(sparkReporter);
    }

    public static ExtentTest createTest(String testName) {

        extentTest = extentReports.createTest(testName);

        return extentTest;
    }

    public static ExtentTest getTest() {

        return extentTest;
    }

    public static void flushReport() {

        extentReports.flush();
    }
}
