package homeworkProject.stepdef;

import homeworkProject.pages.SingleUserNotFound;
import io.cucumber.java.en.Given;

public class SingleUserNotFoundStepDef {
    SingleUserNotFound singleUserNotFound = new SingleUserNotFound();

    @Given("user send GET request by providing {string} and validates status code is {int} for single user")
    public void user_send_get_request_by_providing_and_validates_status_code_is(String id, Integer statusCode) {
        singleUserNotFound.validateStatusCode(id, statusCode);

    }

    @Given("user validate empty response body with {string} for single user")
    public void user_validate_empty_response_body_with(String id) {
        singleUserNotFound.validateEmptyResponseBody(id);
    }



}
