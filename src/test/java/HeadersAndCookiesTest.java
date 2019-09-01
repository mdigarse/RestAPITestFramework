import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.head;

public class HeadersAndCookiesTest {

    @Test
    public void testResponseHeader() {
        Response response = get("http://jsonplaceholder.typicode.com/photos");
       // System.out.print(response.headers());

        //To get single header
        String headerCFRAY = response.getHeader("CF-RAY");
        System.out.println("Header " + headerCFRAY);

        //To get all header
        Headers headers = response.getHeaders();
        for(Header h: headers) {
            System.out.println(h.getName()+" :"+h.getValue());
        }
    }

    @Test
    public void testCookies() {
        Response response = get("http://jsonplaceholder.typicode.com/photos");
        Map<String, String> cookies = response.getCookies();
        for(Map.Entry<String, String> entry: cookies.entrySet()) {
            System.out.println(entry.getKey()+ " :"+ entry.getValue());
        }
    }

    @Test
    public void detailedCookie() {
        Response response = get("http://jsonplaceholder.typicode.com/photos");
        Cookie cookie = response.getDetailedCookie("__cfduid");
        System.out.println(cookie.hasExpiryDate());
        System.out.println(cookie.getExpiryDate());
        System.out.println(cookie.hasValue());
    }
}
