package qaAutoTraining;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.JsonFormatter;
import endpoints.RegistrationService;
import models.DataRegisterUserRequest;
import models.UnsuccessRegistrationResponse;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.support.AnnotationSupport;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Optional;

public class AfterTestExtension implements AfterAllCallback, AfterTestExecutionCallback, BeforeEachCallback {


    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient.Builder()
            .build();
    private final Retrofit RETROFIT = new Retrofit.Builder()
            .client(HTTP_CLIENT)
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final RegistrationService registrationService = RETROFIT.create(RegistrationService.class);
    public static final ExtensionContext.Namespace NAMESPACE
            = ExtensionContext.Namespace.create(AfterTestExtension.class);

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        DataRegisterUserRequest dataRegisterUserRequest = new DataRegisterUserRequest("sydney@fife");
        String response = registrationService.registrationUserUnsuccessful(dataRegisterUserRequest).execute().errorBody().string();
        extensionContext.getStore(NAMESPACE)
                .put("response", response);
        }


    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {

        Response response = context.getStore(ExtensionContext.Namespace.GLOBAL).get("response", Response.class);

        if (response != null && response.code() >= 400 && response.code() <= 406) {
            System.out.println("Тело ответа теста: ");
            System.out.println(response.body().toString());
        }

    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-report/extent-report.html");
        extentReports.attachReporter(sparkReporter);

        // Добавляем код для создания отчета после всех тестов
        ExtentTest extentTest = extentReports.createTest("After All my Tests"); //  ----?

        extentTest.log(Status.INFO, "All tests have completed.");

        // save
        extentReports.flush();


    }


}
