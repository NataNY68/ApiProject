package homeworkProject.stepdef;

import homeworkProject.pages.SingleResourceNotFound;
import io.cucumber.java.en.Given;

public class SingleResourceNotFoundStepDef {

    SingleResourceNotFound singleResourceNotFound = new SingleResourceNotFound();
    @Given("user send GET request to single resource by providing {string} and validates status code is {int}")
    public void user_send_get_request_to_single_resource_by_providing_and_validates_status_code_is(String id, Integer statusCode) {
     singleResourceNotFound.validateStatusCode(id, statusCode);
    }
    @Given("user validate empty response body with {string} for single resource")
    public void user_validate_empty_response_body_with_for_single_resource(String id) {
       singleResourceNotFound.validateEmptyResponseBody(id);
    }
}
