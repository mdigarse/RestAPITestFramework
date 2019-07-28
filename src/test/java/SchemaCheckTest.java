import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaCheckTest {
    @Test
    public void testSchema() {
        given().
                get("http://geo.groupkt.com/ip/172.217.4.14/json").
        then().
                assertThat().body(matchesJsonSchemaInClasspath("jsonfile.json"));
    }
}
