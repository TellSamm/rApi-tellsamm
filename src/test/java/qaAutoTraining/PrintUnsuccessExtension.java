package qaAutoTraining;

import endpoints.RegistrationService;
import models.DataRegisterUserRequest;
import models.UnsuccessRegistrationResponse;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PrintUnsuccessExtension implements AfterTestExecutionCallback, BeforeEachCallback {

    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient.Builder()
            .build();
    private final Retrofit RETROFIT = new Retrofit.Builder()
            .client(HTTP_CLIENT)
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final RegistrationService registrationService = RETROFIT.create(RegistrationService.class);
    public static final ExtensionContext.Namespace NAMESPACE
            = ExtensionContext.Namespace.create(PrintUnsuccessExtension.class);

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        DataRegisterUserRequest dataRegisterUserRequest = new DataRegisterUserRequest("sydney@fife");
        Response<UnsuccessRegistrationResponse> response = registrationService.registrationUserUnsuccessful(dataRegisterUserRequest).execute();
        extensionContext.getStore(NAMESPACE)
                .put("response", response);
    }


    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {

        Response response = context.getStore(NAMESPACE).get("response", Response.class);

        if (response != null && response.code() >= 400 && response.code() <= 406) {
            System.out.println("Тело ответа теста: ");
            System.out.println(response.errorBody().string());
        }

    }
}
