package qaAutoTraining;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.JsonFormatter;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class AfterTestExtension implements AfterAllCallback {


    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-report/extent-report.html");
        extentReports.attachReporter(sparkReporter);

        // Добавляем код для создания отчета после всех тестов
        ExtentTest extentTest = extentReports.createTest("After All my Tests");
        extentTest.log(Status.INFO, "All tests have completed.");

        // save
        extentReports.flush();


    }
}
