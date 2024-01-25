package endpoints;

import models.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserService {

    // Получение списка пользователей
    @GET("api/users")
    Call<UserListRootResponse> getUserList(@Query("page") int pageParam);

    // Получение одного пользователя
    @GET("api/users/{id}")
    Call<SingleUserResponse> getUserById(@Path("id") int id);

    // Создание пользователя
    @POST("api/users")
    Call<CreateUserResponse> createUser(@Body UserRequest userRequest);

    // Обновление пользователя по id
    @PUT("api/users/{id}")
    Call<UserUpdateResponse> updateUserById(@Path("id") int id, @Body UserRequest userRequest);

    // Удаление пользователя
    @DELETE("api/users/{id}")
    Call<Void> deleteUserById (@Path("id") int id);

}
