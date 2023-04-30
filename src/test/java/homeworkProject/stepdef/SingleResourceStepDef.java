package homeworkProject.stepdef;

import homeworkProject.pages.SingleResourse;
import io.cucumber.java.en.Given;

public class SingleResourceStepDef {
    SingleResourse singleResourse = new SingleResourse();

    @Given("user send GET request to single resource and validates status code is {int}")
    public void user_send_get_request_to_single_resource_and_validates_status_code_is(Integer expStatusCode) {
singleResourse.validateStatusCode(expStatusCode);
    }

    @Given("user validates {string}, {string}, {string}, for single resource")
    public void user_validates_for_single_resource(String id, String year, String color) {
        singleResourse.validateInfo(id, year, color);
    }

    @Given("user validates {string} for each single user with {string}")
    public void user_validates_for_each_single_user_with(String supportText, String id) {
        singleResourse.validateSupportText(supportText, id);
    }


}
