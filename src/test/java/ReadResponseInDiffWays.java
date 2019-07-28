import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ReadResponseInDiffWays {

    @Test
    public void testGetResponseAsString() {
        String responseString = get("http://services.groupkt.com/country/search?text=lands").asString();
        System.out.println(responseString);
    }

    @Test
    public void testGetResponseAsInputStream() throws IOException {
        InputStream responseString = get("http://services.groupkt.com/country/search?text=lands").asInputStream();
        System.out.println(responseString.toString().length());
        responseString.close();
    }

    @Test
    public void testGetResponseAsByteArray() {
        byte[] byteArray = get("http://services.groupkt.com/country/search?text=lands").asByteArray();
        System.out.println(byteArray.length);
    }

    @Test
    public void testExtractDetailUsingPath() {
        String href =
        when().
               get("").
        then().
               contentType(ContentType.JSON).
               body("id", equalTo(1)).
        extract().
               path("url");
        when().get(href).then().statusCode(200);
    }

    @Test
    public void testExtractDetailUsingResponse() {
        Response response=
                when().
                        get("").
                then().
                        extract().response();
                System.out.println(response.getStatusCode());
                System.out.println(response.getContentType());
                System.out.println(response.getBody());


    }
}
