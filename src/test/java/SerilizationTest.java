import io.restassured.mapper.ObjectMapperType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class SerilizationTest {
    VideosGame videosGame;

    @Test
    public void videoGameSerializationTest() {

        videosGame = new VideosGame("hello3", 88, "2012-06-03", "shooter", "PG-13",11);
        given()
                .contentType("application/json")
                .body(videosGame)
        .when()
                .post("")
        .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void VideoGameDeserialization() {
       // VideosGame videosGame = get("").as(VideosGame.class);
        System.out.println(videosGame.toString());
    }

    @Test
    public void videoGameSerializationXML() {
        VideosGame videosGame = new VideosGame("hello3", 88, "2012-06-03", "shooter", "PG-13",11);
        given()
                .contentType("application/xml")
                .body(videosGame)
        .when()
                .post("")
        .then()
                .statusCode(200);
    }
}
