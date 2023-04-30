package homeworkProject.pages;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.cucumber.java.it.Ma;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import utils.ConfigReader;

import java.util.Arrays;
import java.util.List;

public class SingleUser {
    @Test
    public void validateStatusCode(int expStatusCode) {
        RestAssured.baseURI = ConfigReader.readProperty("baseURI");
        for (int i = 1; i <= 12; i++) {
            RestAssured.basePath = ConfigReader.readProperty("SingleUserBasePath") + i;
            Response response = RestAssured.given().accept(ContentType.JSON).when().get().
                    then().extract().response();
            Assert.assertEquals(expStatusCode,response.getStatusCode() );
        }
    }

    @Test
    public void validateAllInfo(String id, String firstName, String lastName, String avatarUrl) {
        RestAssured.baseURI = ConfigReader.readProperty("baseURI");
        RestAssured.basePath = ConfigReader.readProperty("SingleUserBasePath") + id;
        Response response = RestAssured.given().accept(ContentType.JSON).when().get()
                .then().statusCode(200).extract().response();
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(id, jsonPath.getString("data.id"));
        Assert.assertEquals(firstName, jsonPath.getString("data.first_name"));
        Assert.assertEquals(lastName, jsonPath.getString("data.last_name"));
        Assert.assertEquals(avatarUrl, jsonPath.getString("data.avatar"));
    }


    @Test
    public void validateSupportUrl(String expSupportUrl) {
        RestAssured.baseURI = ConfigReader.readProperty("baseURI");
        for (int i = 1; i <= 12; i++) {
            RestAssured.basePath = ConfigReader.readProperty("SingleUserBasePath") + i;
            Response response = RestAssured.given().accept(ContentType.JSON).when().get().
                    then().statusCode(200).body("support.url", Matchers.equalTo(expSupportUrl))
                    .extract().response();
        }
    }
}
