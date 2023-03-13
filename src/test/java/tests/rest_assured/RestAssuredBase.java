package tests.rest_assured;

import io.netty.handler.codec.http.HttpResponseStatus;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RestAssuredBase {
    public Map<String, Object> myParams = new HashMap<>();
    public Response response;
    public JsonPath json;

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/";
    }

    public void assignDataFromUrlGET(String url) {
        response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .assertThat().statusCode(HttpResponseStatus.OK.code())
                .extract().response();

        json = new JsonPath(response.getBody().asString());
    }

    public void assignDataFromUrl(Method method, String url) {
        response = given().log().uri()
                .contentType(ContentType.JSON)
                .when().request(method, url)
                .then().log().body()
                //.assertThat().statusCode(HttpResponseStatus.OK.code())
                .extract().response();

        json = new JsonPath(response.getBody().asString());
    }

    public void assignDataFromUrl(Method method, String url, Map<String, ?> params) {
        response = given().log().uri()
                .contentType(ContentType.JSON)
                .params(params)
                .when().request(method, url)
                .then().log().body()
                //.assertThat().statusCode(HttpResponseStatus.OK.code())
                .extract().response();

        json = new JsonPath(response.getBody().asString());
    }

    public void assignDataFromUrlWithScheme(Method method, String url, String jsonPath) {
        response = given().log().uri()
                .contentType(ContentType.JSON)
                .when().request(method, url)
                //.then().body(matchesXsdInClasspath(xsdPath)).log().body()//XML
                .then().body(matchesJsonSchemaInClasspath(jsonPath)).log().body()//JSON
                //.assertThat().statusCode(HttpResponseStatus.OK.code())
                .extract().response();

        json = new JsonPath(response.getBody().asString());
    }

//    public Response getDataFromUrl(String url, Map<String, ?> params) {
//        Response response = given()
//                .contentType(ContentType.JSON)
//                .params(params)
//                .when()
//                .get(url)
//                .then()
//                .assertThat().statusCode(HttpResponseStatus.OK.code())
//                .extract().response();
//
//        json = new JsonPath(response.getBody().asString());
//
//        return response;
//    }
}
