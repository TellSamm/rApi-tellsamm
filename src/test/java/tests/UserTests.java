package tests;

import endpoints.UserService;
import models.SingleUserResponse;
import models.UserListRootResponse;
import models.UserResponse;
import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Response;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class UserTests {

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    private final UserService userService = retrofit.create(UserService.class);


    @Test
    public void testUserListPage() throws IOException {
        int page = 1;

//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Response<UserListRootResponse> response = userService.getUserList(page).execute();

        Assertions.assertTrue(response.isSuccessful());
        UserListRootResponse rootResponse = response.body();
        Assertions.assertEquals(page, rootResponse.getPage());

        List<UserResponse> userData = rootResponse.getData();
        Assertions.assertTrue(userData.size() > 0);


    }

    @Test
    public void testSingleUser() throws IOException{
        int id = 2;
        Response<SingleUserResponse> response = userService.getUserById(id).execute();

        Assertions.assertTrue(response.isSuccessful());
        SingleUserResponse userResponse = response.body();
        Assertions.assertEquals(id, userResponse.getData().getId());


    }

}
