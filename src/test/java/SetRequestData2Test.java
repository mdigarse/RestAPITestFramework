import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SetRequestData2Test {

    @Test
    public void testSetPAthParameter() {
        given()
                .pathParam("type", "json")
                .pathParam("section", "Domain")
        .when()
                .post("https://api.fonts.com/rest/{type}/{section}/")
                // "https://api.fonts.com/rest/type/Domain"
        .then()
                .statusCode(400);

    }

    @Test
    public void testSetCookiesInRequest() {
        given()
                .cookie("__utmt", "1")
        .when()
                .get("http://www.webservicex.com/globalweather.asmx?op=GetCitiesByCountry")
        .then()
                .statusCode(200);
    }

    @Test
    public void testSetMultipleCookiesRequest() {
        //To set mutiple value
        given().cookie("key", "value1", "value2");

        //set detailed cookie
        Cookie cookie = new Cookie.Builder("some_cookie", "someValue")
                .setSecured(true).setComment("test").build();
        given()
                .cookie(cookie)
        .when()
                .get("/cookie")
        .then()
                .assertThat()
                .body(equalTo("X"));

        // set multiple cookies

        Cookie cookie1 = new Cookie.Builder("some_cookie", "someValue").build();
        Cookie cookie2 = new Cookie.Builder("some_cookie", "someValue").build();

        Cookies cookies = new Cookies(cookie1,cookie2);
        given()
                .cookies(cookies)
                .when()
                .get("/cookie")
                .then()
                .assertThat()
                .body(equalTo("X"));
    }

    @Test
    public void testSetHeader() {
        given()
                .header("key1","value1")
                .header("key1", "value1", "value2")
                .headers("k1", "v1", "k2","v2")
        .when()
                .get("")
        .then()
                .statusCode(200);
    }

    @Test
    public void testSetContentType() {
        given()
                .contentType(ContentType.JSON)
                .contentType("application/json; charset = utf-8")
        .when()
                .get("")
        .then()
                .statusCode(200);
    }
}
