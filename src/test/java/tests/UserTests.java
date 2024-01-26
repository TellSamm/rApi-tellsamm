package tests;

import data.DataBase;
import endpoints.RegistrationService;
import endpoints.UserService;
import models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class UserTests extends DataBase {

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    private final UserService userService = retrofit.create(UserService.class);

    private final RegistrationService registrationService = retrofit.create(RegistrationService.class);

    @Test
    public void testUserListPage() throws IOException {
        int page = 1;

        Response<UserListRootResponse> response = userService.getUserList(page).execute();

        Assertions.assertTrue(response.isSuccessful());
        UserListRootResponse rootResponse = response.body();
        Assertions.assertEquals(page, rootResponse.getPage());

        List<UserResponse> userData = rootResponse.getData();
        Assertions.assertTrue(userData.size() > 0);


    }

    @Test
    public void testSingleUser() throws IOException {
        int id = 2;
        Response<SingleUserResponse> response = userService.getUserById(id).execute();

        Assertions.assertTrue(response.isSuccessful());
        SingleUserResponse userResponse = response.body();
        Assertions.assertEquals(id, userResponse.getData().getId());


    }

    @Test
    public void testCreateUser() throws IOException {

        String correctTimepattern = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}Z";
        String name = "TellSamm";
        String job = "QATestingForever";

        UserRequest userRequest = new UserRequest(name, job);
        Response<CreateUserResponse> response = userService.createUser(userRequest)
                .execute();

        Assertions.assertTrue(response.isSuccessful());
        CreateUserResponse userResponse = response.body();
        Assertions.assertEquals(name, userResponse.getName());
        Assertions.assertEquals(job, userResponse.getJob());
        Assertions.assertTrue(userResponse.getCreatedAt().matches(correctTimepattern));


    }


    @Test
    public void testUpdateUser() throws IOException {

        String name = "TellSamm2";
        String job = "QATestingForever2";

        UserRequest userRequest = new UserRequest(name, job);
        Response<UserUpdateResponse> response = userService.updateUserById(4, userRequest).execute();

        assertTrue(response.isSuccessful());
        assertTrue(isTimePatternCorrect(response.body().getUpdatedAt()));


    }


    @Test
    public void testDeleteUser() throws IOException {
        Response<Void> response = userService.deleteUserById(4).execute();
        assertTrue(response.isSuccessful());
        assertEquals(204,response.code());
    }


    private boolean isTimePatternCorrect(String time){
        return time.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{3}Z");
    }

    @Test
    public void registrationUserSuccessfull() throws IOException {

        DataRegisterUserRequest dataRegisterUserRequest = new DataRegisterUserRequest(email,password);
        Response<DataRegisterUserResponse> response = registrationService.registrationUserSuccessful(dataRegisterUserRequest).execute();

        Assertions.assertTrue(response.isSuccessful());
        DataRegisterUserResponse dataRegisterUserResponse = response.body();
        Assertions.assertEquals(id, dataRegisterUserResponse.getId());
        Assertions.assertEquals(token, dataRegisterUserResponse.getToken());

    }

}
