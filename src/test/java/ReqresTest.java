import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;


public class ReqresTest {

    @Test
    void singleUserCheckSupportLinkTest() {
        given() // предусловия configuration
                .log().uri()
                .when() // действие
                .get("https://reqres.in/api/users/2")

                .then() // проверка
                .log().status()
                .log().body()
                .statusCode(200)
                .assertThat()
                .body("support.url", equalTo("https://reqres.in/#support-heading"));

    }


}