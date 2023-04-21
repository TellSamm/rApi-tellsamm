import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.get;



public class ReqresTest {




    @Test
    void singleUserCheckSchemeTest() {
        get("https://reqres.in/api/users/2")
                .then()
                .body("email","")




    }

}