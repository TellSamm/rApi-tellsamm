import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



public class ReqresTest {


    @Test
        // более оптимальный вариант
    void singleUserCheckSchemeTest() {
        get("https://reqres.in/api/users/2")
                .then().
                assertThat().
                body("data.email", equalTo("janet.weaver@reqres.in"));

    }


    @Test
    void singleUserCheckScheme2Test() {
        given() // предусловия configuration

           .when() // действие
                .get("https://reqres.in/api/users/2")

           .then(). // проверка
                assertThat().
                body("data.email", equalTo("janet.weaver@reqres.in"));

    }


}