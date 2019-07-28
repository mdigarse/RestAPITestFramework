import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HandlingSSL_TSL {

    @BeforeClass
    public void setUp() {
        // if write this line here, no need to write in tests.
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    public void testSSL1() {
        given()
                .relaxedHTTPSValidation()
        .when()
                .get("http://www.bupa.com.au/")
        .then()
                .statusCode(200);
    }

    @Test
    public void testTSL() {
        given()
                .relaxedHTTPSValidation("TLS")
                .when()
                .get("http://www.bupa.com.au/")
                .then()
                .statusCode(200);
    }

}
