package specs;

import data.DataBase;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.*;

public class LoginSpecs extends DataBase {

    public static RequestSpecification loginRequestSpec = with()
            .log().all();

    //новый коммент
    public static ResponseSpecification loginResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .log(COOKIES)
            .log(STATUS)
             .expectStatusCode(200)
            .build();
}
