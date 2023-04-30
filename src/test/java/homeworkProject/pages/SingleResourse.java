package homeworkProject.pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import utils.ConfigReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleResourse {

    @Test
    public void validateStatusCode(int expStatusCode) {
        RestAssured.baseURI = ConfigReader.readProperty("baseURI");
        for (int i = 1; i <= 12; i++) {
            RestAssured.basePath = ConfigReader.readProperty("SingleResourceBasePath") + i;
            Response response = RestAssured.given().accept(ContentType.JSON).when().get().
                    then().extract().response();
            Assert.assertEquals(expStatusCode, response.getStatusCode());
        }
    }

    @Test
    public void validateInfo(String id, String year, String color) {
        RestAssured.baseURI = ConfigReader.readProperty("baseURI");
        RestAssured.basePath=ConfigReader.readProperty("SingleResourceBasePath") + id;
            Response response = RestAssured.given().accept(ContentType.JSON).when().get().
                    then().statusCode(200).extract().response();
            JsonPath jsonPath = response.jsonPath();
            Assert.assertEquals(id,String.valueOf(jsonPath.getString("data.id")));
            Assert.assertEquals(year, jsonPath.getString("data.year"));
            Assert.assertEquals(color, jsonPath.getString("data.color"));
    }

    @Test
    public void validateSupportText(String expSupportText, String id) {
        RestAssured.baseURI = ConfigReader.readProperty("baseURI");
        RestAssured.basePath = ConfigReader.readProperty("SingleResourceBasePath") + id;

        Response response = RestAssured.given().accept(ContentType.JSON).when().get().
                then().statusCode(200).extract().response();
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(expSupportText, jsonPath.getString("support.text"));
    }
}
