package homeworkProject.pages;

import homeworkProject.pojo.DataPojo;
import homeworkProject.pojo.UserListPojo;
import io.cucumber.java.sl.In;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import utils.ConfigReader;

import java.util.ArrayList;
import java.util.List;

public class ListResource {
    @Test
    public void validateStatusCode(int expStatusCode) {
        RestAssured.baseURI = ConfigReader.readProperty("baseURI");
        RestAssured.basePath = ConfigReader.readProperty("ListResourcesBasePath");

        for (int page = 1; page <= 2; page++) {
            Response response = RestAssured.given().accept(ContentType.JSON).queryParam("page", page).when().get().then().statusCode(200).
                    contentType(ContentType.JSON).body("page", Matchers.equalTo(page)).extract().response();
            Assert.assertEquals(expStatusCode, response.getStatusCode());
        }
    }

    @Test
    public void sumOfId(int expSum) {
        RestAssured.baseURI = ConfigReader.readProperty("baseURI");
        RestAssured.basePath = ConfigReader.readProperty("ListResourcesBasePath");
        int sum = 0;
        for (int page = 1; page <= 2; page++) {
            Response response = RestAssured.given().accept(ContentType.JSON).queryParam("page", page).
                    when().get().then().statusCode(200).
                    contentType(ContentType.JSON).body("page", Matchers.equalTo(page)).extract().response();
            List<Integer> pageId = response.path("data.id");
            for (int eachId : pageId){
                sum+=eachId;
            }}
        Assert.assertEquals(expSum, sum);
    }

    @Test
    public void averageOfYears(double expAverageYear){
        RestAssured.baseURI = ConfigReader.readProperty("baseURI");;
        RestAssured.basePath = ConfigReader.readProperty("ListResourcesBasePath");
        double sumYear = 0;
        double count = 0;
        for (int page = 1; page <= 2; page++) {
            Response response = RestAssured.given().accept(ContentType.JSON).queryParam("page", page).
                    when().get().then().statusCode(200).
                    contentType(ContentType.JSON).body("page", Matchers.equalTo(page)).extract().response();
            List<Integer> pageId = response.path("data.year");
            for (int eachId : pageId){
                sumYear+=eachId;
                count++;
            }
        }
        double result = sumYear/count;
        Assert.assertEquals(expAverageYear, result, 0.0001);
    }
}
