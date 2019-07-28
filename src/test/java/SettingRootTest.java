import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

public class SettingRootTest {
    @Test
    public void testWithoutRoot() {
        given()
                .get("http://services.groupkt.com/country/get/iso3code/ita").
        then()
                .log().all()
                .body("RestResponse.result.name", is("Italy"))
                .body("RestResponse.result.alpha2_code", is("IT"))
                .body("RestResponse.result.alpha3_code", is("ITA"));

    }

    @Test
    public void testWithRoot() {
        given()
                .get("http://services.groupkt.com/country/get/iso3code/ita").
        then()
                .root("RestResponse.result")
                .body("name", is("Italy"))
                .body("alpha2_code", is("IT"))
                .body("alpha3_code", is("ITA"));
    }

    @Test
    public void detaichRoot() {
        given()
                .get("http://services.groupkt.com/country/get/iso3code/ita").
        then()
                .root("RestResponse.result")
                .body("name", is("Italy"))
                .body("alpha2_code", is("IT"))
                .detachRoot("result")
                .body("result.alpha3_code", is("ITA"));

    }

    @Test
    public void testPostRequest() {
        given()
                .headers("key", "value")
                .param("param1", "value1")
                .param("param2", "value2").
        when()
                .post("http://api.fonts.com/rest/json/accounts/").
        then()
                .statusCode(200).log().all();

    }
}
