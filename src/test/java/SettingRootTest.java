import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

public class SettingRootTest {
    @Test
    public void testWithoutRoot() {
        given()
                .get("https://reqres.in/api/users/2").
        then()
                .log().body()
                .body("data.id", is(3))
                .body("data.email", is("janet.weaver@reqres.in"))
                .body("data.first_name", is("Janet"))
                .body("data.last_name", is("Weaver"))
                .body("data.avatar", is("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"));



    }

    @Test
    public void testWithRoot() {
        given()
                .get("https://reqres.in/api/users/2").
        then()
                .root("data")
                .body("id", is(2))
                .body("email", is("janet.weaver@reqres.in"))
                .body("first_name", is("Janet"))
                .body("last_name", is("Weaver"))
                .body("avatar", is("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"));

    }

    @Test
    public void detaichRoot() {
        given()
                .get("https://reqres.in/api/users/2").
        then()
                .root("data")
                .body("id", is(2))
                .body("email", is("janet.weaver@reqres.in"))
                .body("first_name", is("Janet"))
                .detachRoot("data")
                .body("data.last_name", is("Weaver"))
                .body("data.avatar", is("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"));

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
