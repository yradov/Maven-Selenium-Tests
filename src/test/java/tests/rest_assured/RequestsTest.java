package tests.rest_assured;

import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RequestsTest extends RestAssuredBase {
    @Test
    public void testGetRequest() {
        //Response response = getDataFromUrl("/api/users?page=2", myParams);
        myParams.put("page", 2);
        //Response response = getDataFromUrl("/api/users", myParams);
        //JsonPath json = new JsonPath(response.getBody().asString());
        assignDataFromUrl(Method.GET, "/api/users", myParams);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("total_pages"), "2");

        Assert.assertEquals(response.jsonPath().getString("data[0].email"), "michael.lawson@reqres.in");

        String email = json.getString("data[0].email");
        Assert.assertEquals(email, "michael.lawson@reqres.in");

        email = json.getString("data[1].email");
        Assert.assertEquals(email, "lindsay.ferguson@reqres.in");

        String url = json.getString("support.url");
        Assert.assertEquals(url, "https://reqres.in/#support-heading");
    }

    @Test
    public void testValidationJsonSchema() {
        /**
            {
                "data": {
                    "id": 2,
                    "email": "janet.weaver@reqres.in",
                    "first_name": "Janet",
                    "last_name": "Weaver",
                    "avatar": "https://reqres.in/img/faces/2-image.jpg"
                },
                "support": {
                    "url": "https://reqres.in/#support-heading",
                    "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
                }
            }
        *======================================================
        * use json-schema-validator
        * for XML needs .xsd file convert-json-schema-to-xsd
        * for JSON needs .json file with json schema
        *=====================================================*/
        assignDataFromUrlWithScheme(Method.GET, "/api/users/2", "jsonSchema.json");

        Assert.assertEquals(response.statusCode(), 200);
    }
}
