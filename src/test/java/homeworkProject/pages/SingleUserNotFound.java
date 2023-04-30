package homeworkProject.pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import utils.ConfigReader;

import java.util.Iterator;
import java.util.Random;

public class SingleUserNotFound {

    @Test
    public void validateStatusCode(String id, int statusCode) {
        RestAssured.baseURI = ConfigReader.readProperty("baseURI");
        RestAssured.basePath = ConfigReader.readProperty("SingleUserBasePath") + id;
        Response response = RestAssured.given().accept(ContentType.JSON).
                when().get().then().extract().response();

        Assert.assertEquals(404, response.getStatusCode());
    }

    @Test
    public void validateEmptyResponseBody(String id) {
        RestAssured.baseURI = ConfigReader.readProperty("baseURI");
        RestAssured.basePath = ConfigReader.readProperty("SingleUserBasePath") + id;
        Response response = RestAssured.given().accept(ContentType.JSON).
                when().get().then().extract().response();
        String actualBody = response.getBody().asString();
        Assert.assertEquals("{}", actualBody);
    }
}

