import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BeforeClassTest {
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI="http://services.groupkt.com";
        RestAssured.basePath="country";
    }

    @Test
    public void test1() {
        given()
                .get("/get/iso2code/US")
                .then()
                .statusCode(200);
    }
}
