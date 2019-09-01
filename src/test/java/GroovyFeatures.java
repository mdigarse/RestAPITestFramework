import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.number.OrderingComparison.greaterThan;

public class GroovyFeatures {

    @Test
    public void testPresenceOfElement() {
        given().
                get("https://reqres.in/api/users?page=2").
        then().
                body("data.email", hasItems("michael.lawson@reqres.in")).
                log().all();

    }

    @Test
    public void getResponseAsList() {

        String response =
                when().get("https://reqres.in/api/users?page=2").asString();
        List<String> ls = from(response).getList("data.email");
        for(String st: ls)
            System.out.println(st);
    }
}
