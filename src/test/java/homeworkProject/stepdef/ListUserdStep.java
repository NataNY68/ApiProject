package homeworkProject.stepdef;

import homeworkProject.pages.ListUsers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ListUserdStep {
    WebDriver driver;
    ListUsers listUsers = new ListUsers();

    @Given("user send GET request to list of users and validates status code is {int}")
    public void user_send_get_request_to_list_of_users_and_validates_status_code_is(int expStatusCode) {
        listUsers.validateStatusCodeListUsers(expStatusCode);
        //Assert.assertEquals(expStatusCode, listUsers.validateStatusCodeListUsers(200));
    }


    @Then("user validates page number")
    public void user_validates_page_number() {
        listUsers.validatePageNumber();
    }


    @Given("user validate key total")
    public void user_validate_key_total() {
        listUsers.validateTotalKeyValue();
    }


    @Given("user validates {string}, {string}, {string}, and {string}")
    public void user_validates_and(String id, String firstName, String lastName, String avatarUrl) {
        listUsers.validateAllInfo();
    }

    @Then("user store data in a map first name,last name as a key and email as a value")
    public void user_store_data_in_a_map_first_name_last_name_as_a_key_and_email_as_a_value() {
        listUsers.validateUsersInfo();
    }

}
