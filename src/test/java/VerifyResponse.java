import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class VerifyResponse {

    @Test
    public void testStatusInResponse() {
        given()
                .get("http://services.groupkt.com/country/search?text=lands")
        .then()
                .assertThat().statusCode(200)
                .log().all();
    }

    @Test
    public void testHeaderInResponse() {
        given()
                .get("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .assertThat().headers("Transfer-Encoding", "chunked", "Content-Type", containsString("json"))
                .assertThat().contentType(ContentType.JSON);

    }

    @Test
    public void testBodyInResponse() {
        String responseString = get("http://services.groupkt.com/country/search?text=lands").asString();
        given()
                .get("http://services.groupkt.com/country/search?text=lands")
        .then()
                .assertThat().body(equalTo(responseString));
    }

  /*  @Test
    public void testBodyParameterInResponse() {
        given().get("http://jsonplaceholder.typecode.com/photos/1")
                .then().body("thumbnailUrl",response ->equalTo("http://placehold.it/150/92c952"));
    } */
}
