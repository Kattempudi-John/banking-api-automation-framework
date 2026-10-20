package utilities;

import io.restassured.response.Response;
import reports.ExtentReportManager;

public class ApiLogger {

//    public static void logRequest(String method, String uri) {
//
//        System.out.println("========== REQUEST ==========");
//        System.out.println("Method: " + method);
//        System.out.println("URI: " + uri);
//        System.out.println("=============================");
//    }

    public static void logRequest(String method, String uri) {

        String message =
                "========== REQUEST ==========\n" +
                        "Method: " + method + "\n" +
                        "URI: " + uri + "\n" +
                        "=============================";

        System.out.println(message);

        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().info(message);
        }
    }

    public static void logResponse(Response response) {

        String message =
                "========== RESPONSE ==========\n" +
                        "Status Code: " + response.statusCode() + "\n" +
                        "Response Time: " + response.time() + " ms\n" +
                        "Body:\n" +
                        "[Response body omitted to protect authentication tokens]" +
                        "\n==============================";

        System.out.println(message);

        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().info(message);
        }
    }
}
