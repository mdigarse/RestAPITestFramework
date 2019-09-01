import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BeforeClassTest {
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI="http://jsonplaceholder.typicode.com";
        RestAssured.basePath="photos";
        System.out.println("setUp method executed");
    }

    @Test
    public void test1() {
        given()
                .get("/2")
                .then()
                .statusCode(200);
        System.out.println("Test1 executed");
    }

    @Test
    public void test2() {
        given()
                .get("/3")
                .then()
                .statusCode(200);
        System.out.println("Test2 executed");
    }
}
