import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class SetRequestDataTest {

    @Test
    public void testConnectRequest() {
        when()
                .request("CONECT","https://api.fonts.com/rest/json/accounts/")
        .then()
                .statusCode(400);
    }

    @Test
    public void testQueryParameters() {
        given()
                .queryParam("A", "A val")
                .queryParam("B", "B val")
        .when()
                .get("https://api.fonts.com/rest/json/Acounts/*")
        .then()
                .statusCode(400);
    }

    @Test
    public void testFormParameter() {
        given()
                .formParam("name1", "value1")
                .formParam("name2", "value2")
        .when()
                .post("https://api.fonts.com/rest/json/Domains/")
        .then()
                .statusCode(400);
    }

    @Test
    public void testParameter() {
        given()
                .param("name1", "value1")
                .param("name2", "value2")
        .when()
                .post("https://api.fonts.com/rest/json/Domains/")
        .then()
                .statusCode(400);
    }

    @Test
    public void setMultipleValueParametersTest() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");

        given()
                .param("a","b")
                .param("f")
                .param("C", list)
        .when()
                .get("https://api.fonts.com/rest/json/Accounts/")
        .then()
                .statusCode(400);
    }
}
