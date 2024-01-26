package endpoints;

import models.DataRegisterUserRequest;
import models.DataRegisterUserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegistrationService {

    //Успешная регистрация юзера
    @POST("api/register")
    Call<DataRegisterUserResponse> registrationUserSuccessful (@Body DataRegisterUserRequest dataRegisterUser);
}
