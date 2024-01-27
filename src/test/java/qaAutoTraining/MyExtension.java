package qaAutoTraining;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;


public class MyExtension implements BeforeTestExecutionCallback {

    private ExtentReports extentReports;

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        System.out.println("Выполняется тест " + context.getTestMethod().get().getName());
    }


    public void setUP() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-report/extent-report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }
    // Инициализация ExtentReports и ExtentSparkReporter

}

