import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;

public class ResponseSpecBuilder {

    public static ResponseSpecification responseSpecification;
    public static RequestSpecification requestSpecification;

    @BeforeClass
    public void setUp() {
        responseSpecification = expect().statusCode(200)
                .header("Content-Type", "text/html; charset=UTF-8");


        requestSpecification = given().contentType("application/json")
                .basePath("photos");

    }

    @Test
    public void testResponse() {
        when()
                .get("http://jsonplaceholder.typicode.com")
        .then()
                .spec(responseSpecification)
                .time(lessThan(4000L));
    }

    @Test
    public void testRequest() {
        given()
                .spec(requestSpecification)
        .when()
                .get("http://jsonplaceholder.typicode.com")
                .then()
                .spec(responseSpecification)
                .time(lessThan(4000L));
    }
}
