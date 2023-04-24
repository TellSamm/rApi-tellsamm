import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



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

           .when() // ��������
                .get("https://reqres.in/api/users/2")

           .then(). // ��������
                assertThat().
                body("data.email", equalTo("janet.weaver@reqres.in"));

    }


}