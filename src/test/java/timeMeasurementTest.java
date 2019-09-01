import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class timeMeasurementTest {
    @Test
    public void testResponseTime() {
        long t = given().get("http://jsonplaceholder.typicode.com/photos/").time();
        System.out.println("Time(MS): "+t);
    }

    @Test
    public void testResponseTimeInUnit() {
        long t = given().get("http://jsonplaceholder.typicode.com/photos/").timeIn(TimeUnit.SECONDS);
        System.out.println("Time(S): "+t);
    }

    @Test
    public void testResponseTimeAssersion() {
        given().get("http://jsonplaceholder.typicode.com/photos/")
                .then()
                .time(lessThan(5L));
    }
}
