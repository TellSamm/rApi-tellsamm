import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;


public class ReqresTest {


    @Test
        // ����� ����������� �������
    void singleUserCheckSchemeTest() {
        get("https://reqres.in/api/users/2")
                .then().
                assertThat().
                body("data.email", equalTo("janet.weaver@reqres.in"));

    }

    @Test
    void singleUserCheckScheme2Test() {
        given() // ����������� configuration
                .log().uri()
           .when() // ��������
                .get("https://reqres.in/api/users/2")

           .then() // ��������
                .log().status()
                .log().body()
                .statusCode(200)
                .assertThat()
                .body("data.email", equalTo("janet.weaver@reqres.in"));

    }


    @Test
    void singleUserCheckSupportLinkTest() {
        given() // ����������� configuration
                .log().uri()
                .when() // ��������
                .get("https://reqres.in/api/users/2")

                .then() // ��������
                .log().status()
                .log().body()
                .statusCode(200)
                .assertThat()
                .body("support.url", equalTo("https://reqres.in/#support-heading"));

    }


}