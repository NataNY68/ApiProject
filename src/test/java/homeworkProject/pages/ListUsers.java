package homeworkProject.pages;

import groovyjarjarantlr4.v4.codegen.model.SrcOp;
import homeworkProject.pojo.DataPojo;
import homeworkProject.pojo.UserListPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.util.*;

public class ListUsers {

    @Test
    public void getRequest() {
        RestAssured.baseURI = ConfigReader.readProperty("baseURI");
        RestAssured.basePath = ConfigReader.readProperty("ListUsersBasePath");
        Response response = RestAssured.given().accept(ContentType.JSON).when().get().then().statusCode(200).
                contentType(ContentType.JSON).extract().response();
    }

    @Test
    public void validateStatusCodeListUsers(int expStatusCode) {
        RestAssured.baseURI = ConfigReader.readProperty("baseURI");
        RestAssured.basePath = ConfigReader.readProperty("ListUsersBasePath");
        Response response = RestAssured.given().accept(ContentType.JSON).when().get().then().statusCode(200).
                contentType(ContentType.JSON).extract().response();
        Assert.assertEquals(expStatusCode, response.getStatusCode());
    }

    @Test
    public void validatePageNumber() {
        RestAssured.baseURI = ConfigReader.readProperty("baseURI");
        RestAssured.basePath = ConfigReader.readProperty("ListUsersBasePath");

        for (int page = 1; page <= 2; page++) {
            Response response = RestAssured.given().accept(ContentType.JSON).queryParam("page", page).when().get().then().statusCode(200).
                    contentType(ContentType.JSON).body("page", Matchers.equalTo(page)).extract().response();
        }
    }


    @Test
    public void validateAllInfo() {
        RestAssured.baseURI = ConfigReader.readProperty("baseURI");
        RestAssured.basePath = ConfigReader.readProperty("ListUsersBasePath");
        List<Integer> expId = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        List<String> expNames = Arrays.asList("George Bluth", "Janet Weaver", "Emma Wong", "Eve Holt",
                "Charles Morris", "Tracey Ramos", "Michael Lawson", "Lindsay Ferguson", "Tobias Funke",
                "Byron Fields", "George Edwards", "Rachel Howell");
        int i=0;

        for (int page = 1; page <= 2; page++) {
            Response response = RestAssured.given().accept(ContentType.JSON).queryParam("page", page).
                    when().get().then().statusCode(200).
                    contentType(ContentType.JSON).extract().response();

            UserListPojo parsedResp = response.as(UserListPojo.class);
            List<DataPojo> list = parsedResp.getData();
            for ( DataPojo each :list){
                String expAvatarUrl = ConfigReader.readProperty("baseURI")+"/img/faces/"+(expId.get(i))+"-image.jpg";
                Assert.assertEquals((long)expId.get(i), (long) each.getId());
                Assert.assertEquals(expNames.get(i), each.getFirst_name()+" "+each.getLast_name());
                Assert.assertEquals(expAvatarUrl, each.getAvatar());
                i++;
            }
        }
    }

    @Test
    public void validateTotalKeyValue() {
        RestAssured.baseURI = ConfigReader.readProperty("baseURI");
        RestAssured.basePath = ConfigReader.readProperty("ListUsersBasePath");

        for (int page = 1; page <= 2; page++) {
            Response response = RestAssured.given().accept(ContentType.JSON).queryParam("page", page).
                    when().get().then().statusCode(200).contentType(ContentType.JSON).
                    body("total", Matchers.equalTo(12)).extract().response();
        }
    }

    @Test
    public void validateUsersInfo() {
        RestAssured.baseURI = ConfigReader.readProperty("baseURI");
        RestAssured.basePath = ConfigReader.readProperty("ListUsersBasePath");

        Map<String, String> m = new HashMap<>();
        for (int page = 1; page <= 2; page++) {
            Response response = RestAssured.given().accept(ContentType.JSON).queryParam("page", page).
                    when().get().then().statusCode(200).
                    contentType(ContentType.JSON).extract().response();
            UserListPojo parsedResp = response.as(UserListPojo.class);
            List<DataPojo> list = parsedResp.getData();
            for (DataPojo each : list) {
                m.put(each.getFirst_name() + "." + each.getLast_name(), each.getEmail());
            }
        }
    }
}
