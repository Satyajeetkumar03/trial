import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class extentreport {
    public ExtentReports extent;
    public ExtentTest test;
    @BeforeSuite
    public void setup() {

        extent = new ExtentReports();
        ExtentSparkReporter sparkReporter=new ExtentSparkReporter("output.html");
        extent.attachReporter(sparkReporter);
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        if (test != null) {
            if (result.getStatus() == ITestResult.FAILURE) {
                test.log(Status.FAIL, "Test Case Failed: " + result.getName());
                // Additional actions for a failed test
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                test.log(Status.PASS, "Test Case Passed: " + result.getName());
                // Additional actions for a passed test
            } else {
                test.log(Status.SKIP, "Test Case Skipped: " + result.getName());
                // Additional actions for a skipped test
            }

            extent.flush();
            Desktop.getDesktop().browse(new File("output.html").toURI());
        }
    }
//    public static void main(String[] args) throws Exception
//    {
//        ExtentReports extent=new ExtentReports();
//        File file=new File("report.html");
//        ExtentSparkReporter sparkReporter=new ExtentSparkReporter("report.html");
//        extent.attachReporter(sparkReporter);
//        ExtentTest test1=extent.createTest("Test 1");
//        test1.pass("passed test");
//
//        ExtentTest test2=extent.createTest("Test 2");
//        test2.log(Status.FAIL,"<b>Failed test</b>");
//
//        ExtentTest test3=extent.createTest("Test 3");
//        test3.skip("This is skipped");
//        String json="{\"menu\": {\n" +
//                "  \"id\": \"file\",\n" +
//                "  \"value\": \"File\",\n" +
//                "  \"popup\": {\n" +
//                "    \"menuitem\": [\n" +
//                "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n" +
//                "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n" +
//                "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" +
//                "    ]\n" +
//                "  }\n" +
//                "}}\n";
//        String xml="<menu id=\"file\" value=\"File\">\n" +
//                "  <popup>\n" +
//                "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\n" +
//                "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\n" +
//                "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\n" +
//                "  </popup>\n" +
//                "</menu>";
//        extent.createTest("Xml based test")
//        .info(MarkupHelper.createCodeBlock(xml, CodeLanguage.XML));
//        extent.createTest("JSON based test")
//        .log(Status.INFO,MarkupHelper.createCodeBlock(json,CodeLanguage.JSON));
//
//
//        extent.flush();
//        Desktop.getDesktop().browse(new File("report.html").toURI());
//    }
}
