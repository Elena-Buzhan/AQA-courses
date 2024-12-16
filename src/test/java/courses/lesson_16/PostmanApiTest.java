package courses.lesson_16;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class PostmanApiTest {

    private static final String BASE_URI = "http://postman-echo.com";
    private static final Integer STATUS_CODE_OK = 200;

    private io.restassured.specification.RequestSpecification baseRequest() {
        return given()
                .baseUri(BASE_URI)
                .filter(new AllureRestAssured())
                .log().uri();
    }

    @Test
    public void testGetMethod() {
        performGetRequest();
    }

    @Step("Выполнение GET-запроса с параметрами foo1=bar1 и foo2=bar2")
    private void performGetRequest() {
        baseRequest()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(STATUS_CODE_OK)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo(BASE_URI + "/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void testPostRawTextMethod() {
        HashMap<String, String> body = new HashMap<>();
        body.put("test", "value");
        performPostRawRequest(body);
    }

    @Step("Выполнение POST-запроса с JSON-данными: {body}")
    private void performPostRawRequest(HashMap<String, String> body) {
        baseRequest()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/post")
                .then()
                .statusCode(STATUS_CODE_OK)
                .body("data.test", equalTo(body.get("test")))
                .body("url", equalTo(BASE_URI + "/post"));
    }

    @Test
    public void testPostFormDataMethod() {
        HashMap<String, String> form = new HashMap<>();
        form.put("foo1", "bar1");
        form.put("foo2", "bar2");
        performPostFormRequest(form);
    }

    @Step("Выполнение POST-запроса с form-data: {form}")
    private void performPostFormRequest(HashMap<String, String> form) {
        baseRequest()
                .contentType("application/x-www-form-urlencoded;charset=UTF-8")
                .formParams(form)
                .when()
                .post("/post")
                .then()
                .statusCode(STATUS_CODE_OK)
                .body("form.foo1", equalTo(form.get("foo1")))
                .body("form.foo2", equalTo(form.get("foo2")))
                .body("url", equalTo(BASE_URI + "/post"));
    }

    @Test
    public void testPutMethod() {
        HashMap<String, String> data = new HashMap<>();
        data.put("Name", "Lena");
        performPutRequest(data);
    }

    @Step("Выполнение PUT-запроса с JSON-данными: {data}")
    private void performPutRequest(HashMap<String, String> data) {
        baseRequest()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .put("/put")
                .then()
                .statusCode(STATUS_CODE_OK)
                .body("data.Name", equalTo(data.get("Name")))
                .body("url", equalTo(BASE_URI + "/put"));
    }

    @Test
    public void testPatchMethod() {
        HashMap<String, String> data = new HashMap<>();
        data.put("Name", "Elena");
        performPatchRequest(data);
    }

    @Step("Выполнение PATCH-запроса с JSON-данными: {data}")
    private void performPatchRequest(HashMap<String, String> data) {
        baseRequest()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .patch("/patch")
                .then()
                .statusCode(STATUS_CODE_OK)
                .body("data.Name", equalTo(data.get("Name")))
                .body("url", equalTo(BASE_URI + "/patch"));
    }

    @Test
    public void testDeleteMethod() {
        HashMap<String, String> data = new HashMap<>();
        data.put("Name", "Lena");
        performDeleteRequest(data);
    }

    @Step("Выполнение DELETE-запроса с JSON-данными: {data}")
    private void performDeleteRequest(HashMap<String, String> data) {
        baseRequest()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .delete("/delete")
                .then()
                .statusCode(STATUS_CODE_OK)
                .body("data.Name", equalTo(data.get("Name")))
                .body("url", equalTo(BASE_URI + "/delete"));
    }
}
