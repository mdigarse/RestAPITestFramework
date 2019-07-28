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
                get("http://services.groupkt.com/country/search?text=lands").
        then().
                body("RestResponse.result.name", hasItems("Cook Islands")).
                log().all();

    }

    @Test
    public void testLengthOfResponse() {
        given().
                get("http://services.groupkt.com/country/search?text=islands").
                then().
                body("RestResponse.result.alpha3_code*.length().sum()", greaterThan(10));

    }

    @Test
    public void getResponseAsList() {

        String response =
                when().get("http://services.groupkt.com/country/search?text=lands").asString();
        List<String> ls = from(response).getList("RestResponse.result.name");
        for(String st: ls)
            System.out.println(st);
    }

    @Test
    public void testConditionOnList() {

        String response =
                when().get("http://services.groupkt.com/country/search?text=lands").asString();
        List<String> ls = from(response).getList("RestResponse.result.findAll { it.name.length()>40}.name");

    }
}
