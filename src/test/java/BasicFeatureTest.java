import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BasicFeatureTest {

    @Test
    public void testStatuscode() {
        given()
                .get("http://jsonplaceholder.typicode.com/posts/3")
        .then()
                .statusCode(200);
    }

    @Test
    public void testLogging() {
        given()
                .get("http://jsonplaceholder.typicode.com/posts/3")
        .then()
                .statusCode(200)
                .log()
                .body();
    }

    @Test
    public void testEqualToFunction() {
        given()
                .get("http://jsonplaceholder.typicode.com/posts/3")
        .then()
                .body("title", equalTo("ea molestias quasi exercitationem repellat qui ipsa sit aut"));
    }

    @Test
    public void testParameterAndAddress() {
        given()
                .param("key0","value0")
                .param("key1","value1")
                .param("key2", "value2")
                .header("","")
                .header("header1","value1")
                .header("header2", "value2").
        when()
                .get("http://jsonplaceholder.typicode.com/posts/3").
        then()
                .statusCode(200)
                .log().all();

    }
}
