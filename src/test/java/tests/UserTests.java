package tests;

import data.DataBase;
import endpoints.RegistrationService;
import endpoints.UserService;
import jupiter.PrintUnsuccessBody;
import models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import qaAutoTraining.AfterTestExtension;
import qaAutoTraining.MyExtension;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith({MyExtension.class, AfterTestExtension.class})
public class UserTests extends DataBase {


    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    //реалуем интерфейс через метод ретрофита .create
    private final UserService userService = retrofit.create(UserService.class); //тут по сути происходит чтение аннотаций внутри интерфейса UserService

    //реалуем интерфейс через метод ретрофита .create
    private final RegistrationService registrationService = retrofit.create(RegistrationService.class); // тоже самое что и сверху


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
        assertEquals(204, response.code());
    }


    private boolean isTimePatternCorrect(String time) {
        return time.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{3}Z");
    }

    @Test
    public void registrationUserSuccessfull() throws IOException {

        DataRegisterUserRequest dataRegisterUserRequest = new DataRegisterUserRequest(email, password);
        Response<DataRegisterUserResponse> response = registrationService.registrationUserSuccessful(dataRegisterUserRequest).execute();

        Assertions.assertTrue(response.isSuccessful());
        DataRegisterUserResponse dataRegisterUserResponse = response.body();
        Assertions.assertEquals(id, dataRegisterUserResponse.getId());
        Assertions.assertEquals(token, dataRegisterUserResponse.getToken());
        System.out.println(dataRegisterUserResponse.getToken().toString());


    }

    @PrintUnsuccessBody
    @Test
    public void registrationUserUnsuccessfull() throws IOException {

        DataRegisterUserRequest dataRegisterUserRequest = new DataRegisterUserRequest(emailError);
        //тут метод .body мы не можем использовать так как он работает только при успешности ответа от сервера 200 - 299
        Response<UnsuccessRegistrationResponse> response = registrationService.registrationUserUnsuccessful(dataRegisterUserRequest).execute();
        Assertions.assertEquals(400, response.code());
        //преобразуем эту JSON-строку в объект типа UnsuccessRegistrationResponse.class
        UnsuccessRegistrationResponse unsuccessRegistrationResponse = gson.fromJson(response.errorBody().string(), UnsuccessRegistrationResponse.class);
        Assertions.assertEquals(error, unsuccessRegistrationResponse.getError());
    }

}
