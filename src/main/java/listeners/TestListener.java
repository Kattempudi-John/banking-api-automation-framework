package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReportManager;


public class TestListener implements ISuiteListener, ITestListener {

    @Override
    public void onStart(ISuite suite) {
        System.out.println(
                "SUITE STARTED: " + suite.getName()
        );

        ExtentReportManager.initializeReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println(
                "SUITE FINISHED: " + suite.getName()
        );

        ExtentReportManager.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(
                "TEST STARTED: " + result.getName()
        );

        ExtentReportManager.createTest(
                result.getName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(
                "TEST PASSED: " + result.getName()
        );

        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest()
                    .pass("Test passed successfully");
        }

        ExtentReportManager.removeTest();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(
                "TEST FAILED: " + result.getName()
        );

        if (result.getThrowable() != null) {
            System.out.println(
                    "FAILURE REASON: "
                            + result.getThrowable().getMessage()
            );
        }

        if (ExtentReportManager.getTest() != null) {
            if (result.getThrowable() != null) {
                ExtentReportManager.getTest()
                        .fail(result.getThrowable());
            } else {
                ExtentReportManager.getTest()
                        .fail("Test failed");
            }
        }

        ExtentReportManager.removeTest();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(
                "TEST SKIPPED: " + result.getName()
        );

        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest()
                    .skip("Test skipped");
        }

        ExtentReportManager.removeTest();
    }



}
