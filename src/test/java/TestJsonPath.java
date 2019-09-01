import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;

public class TestJsonPath {

    @Test
    public void jsonPath1Test() {
        String responseAsString =
                given()
                        .get("http://jsonplaceholder.typicode.com/photos")
                .then()
                        .extract().asString();
        List<String> list = from(responseAsString).get("title");
            System.out.println(list.size());
    }

    @Test
    public void jsonPath2Test() {
        String responseAsString =
                given().
                        get("http://jsonplaceholder.typicode.com/photos").
                        then().
                        extract().asString();
        JsonPath jsonPath = new JsonPath(responseAsString);
        List<String> list = jsonPath.get("url");
        System.out.println(list.size());
    }
}
