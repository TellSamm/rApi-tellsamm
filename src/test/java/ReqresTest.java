import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;



public class ReqresTest {

    public static final String BASE_URL = "https://reqres.in";

    @Test
    void CheckSupportLinkTest() {
        given()
                .log().uri()
                .when() // действие
                .get(BASE_URL + "/api/users/2")

                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .assertThat()
                .body("support.url", equalTo("https://reqres.in/#support-heading"));

    }


    @Test
    void CheckListUsersTest() {
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
    void holl() {
//        String expectedResponse =

        given()
                .log().uri()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .assertThat()
                .body("support.url", equalTo("https://reqres.in/#support-heading"));


    }
}