import data.DataBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static specs.LoginSpecs.loginRequestSpec;
import static specs.LoginSpecs.loginResponseSpec;


public class ReqresTest extends DataBase {


    @Test
    void checkSupportLinkTestAndUserInformation() {
        given() // Подготовка!
                .spec(loginRequestSpec)
                .when() //Действие!
                .get(BASE_URL + "/api/users/2")
                .then() //Проверка!
                // Здесь вы проверяете, соответствует ли фактический результат ожиданиям. Это включает в себя использование матчеров или проверок, чтобы убедиться, что тест прошел успешно.
                .spec(loginResponseSpec)
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("support.url", equalTo("https://reqres.in/#support-heading"))
                .body("data.avatar", containsString("2-image"));
    }


    @Test
    void checkListUsersTest() {
        given()
                .log().uri()
                .when()
                .get(BASE_URL + "/api/users?page=2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("total", is(12))
                .body(matchesJsonSchemaInClasspath("shemes/status-scheme-response-list-users.json"));

    }


    @Test
    void usersSchemeTest() {
        Response response = RestAssured.get(BASE_URL + "/api/users?page=2");
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body(matchesJsonSchemaInClasspath("shemes/status-scheme-response-list-users.json"));
    }


    @Test
    void checkUserNotFound() {
        given()
                .log().uri()
                .when()
                .get(BASE_URL + "/api/users/23")
                .then()
                .log().status()
                .log().body()
                .statusCode(404)
                .assertThat()
                .body(equalTo("{}"));
    }

    @Test
    void createUserTest() {
        String requestBody = "{\"name\":\"morpheus\",\"job\":\"leader\"}";
        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(BASE_URL + "/api/users")
                .then()
                .statusCode(201)
                .log().body()
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"))
                .body("id", not(empty()))
                .body("createdAt", not(empty()));
    }

    @Test
    void deleteUserTest() {
        given()
                .when()
                .delete(BASE_URL + "/api/users/2")
                .then()
                .statusCode(204)
                .assertThat()
                .body(is(emptyString()));


    }


}

