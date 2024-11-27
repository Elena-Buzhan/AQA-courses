package courses.lesson_16;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class PostmanApiTest {

    private static final String BASE_URI = "http://postman-echo.com";
    private static final Integer STATUS_CODE_OK = 200;

    @Test
    public void testGetMethod() {
        given()
                .baseUri(BASE_URI)
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .assertThat()
                .statusCode(STATUS_CODE_OK)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo(BASE_URI + "/get?foo1=bar1&foo2=bar2"))
                .log().all();
    }

    @Test
    public void testPostRawTextMethod() {
        HashMap<String, String> body = new HashMap<>();
        body.put("test", "value");
        given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .post("/post")
                .then()
                .statusCode(STATUS_CODE_OK)
                .body("data.test", equalTo("value"))
                .body("url", equalTo(BASE_URI + "/post"))
                .log().all();
    }

    @Test
    public void testPostFormDataMethod() {
        HashMap<String, String> form = new HashMap<>();
        form.put("foo1", "bar1");
        form.put("foo2", "bar2");
        given()
                .baseUri(BASE_URI)
                .contentType("application/x-www-form-urlencoded;charset=UTF-8")
                .formParams(form)
                .when()
                .post("/post")
                .then()
                .statusCode(STATUS_CODE_OK)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("url", equalTo(BASE_URI + "/post"))
                .log().all();
    }

    @Test
    public void testPutMethod() {
        HashMap<String, String> test = new HashMap<>();
        test.put("Name", "Lena");
        given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .when()
                .body(test)
                .put("/put")
                .then()
                .statusCode(STATUS_CODE_OK)
                .body("data.Name", equalTo("Lena"))
                .body("url", equalTo(BASE_URI + "/put"))
                .log().all();
    }

    @Test
    public void testPatchMethod() {
        HashMap<String, String> test = new HashMap<>();
        test.put("Name", "Elena");
        given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .when()
                .body(test)
                .patch("/patch")
                .then()
                .statusCode(STATUS_CODE_OK)
                .body("data.Name", equalTo("Elena"))
                .body("url", equalTo(BASE_URI + "/patch"))
                .log().all();
    }

    @Test
    public void testDeleteMethod() {
        HashMap<String, String> test = new HashMap<>();
        test.put("Name", "Lena");
        given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .when()
                .body(test)
                .delete("/delete")
                .then()
                .statusCode(STATUS_CODE_OK)
                .body("data.Name", equalTo("Lena"))
                .body("url", equalTo(BASE_URI + "/delete"))
                .log().all();
    }
}
