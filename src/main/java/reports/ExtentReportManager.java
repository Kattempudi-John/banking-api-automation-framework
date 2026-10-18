package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extentReports;
    private static final ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();

    public static void initializeReport() {

        if (extentReports == null) {
            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(
                            "test-output/ExtentReport.html"
                    );

            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
        }
    }

    public static ExtentTest createTest(String testName) {

        if (extentReports == null) {
            throw new IllegalStateException(
                    "ExtentReports is not initialized. " +
                            "Ensure initializeReport() runs before the test."
            );
        }

        ExtentTest test = extentReports.createTest(testName);
        extentTest.set(test);

        return test;
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    public static void removeTest() {
        extentTest.remove();
    }

    public static void flushReport() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }

//    private static ExtentReports extentReports;
//    private static ExtentTest extentTest;
//
//    public static void initializeReport() {
//
//        ExtentSparkReporter sparkReporter =
//                new ExtentSparkReporter(
//                        "test-output/ExtentReport.html"
//                );
//
//        extentReports = new ExtentReports();
//
//        extentReports.attachReporter(sparkReporter);
//    }
//
//    public static ExtentTest createTest(String testName) {
//
//        extentTest = extentReports.createTest(testName);
//
//        return extentTest;
//    }
//
//    public static ExtentTest getTest() {
//
//        return extentTest;
//    }
//
//    public static void flushReport() {
//
//        extentReports.flush();
//    }

}
