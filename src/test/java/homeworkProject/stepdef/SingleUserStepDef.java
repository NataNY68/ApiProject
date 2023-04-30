package homeworkProject.stepdef;

import homeworkProject.pages.SingleUser;
import io.cucumber.java.en.Given;

public class SingleUserStepDef {

    SingleUser singleUser = new SingleUser();

    @Given("user send GET request to single user and validates status code is {int}")
    public void user_send_get_request_to_single_user_and_validates_status_code_is(Integer expStatusCode) {
        singleUser.validateStatusCode(expStatusCode);
    }

    @Given("And user validates {string}, {string}, {string}, and {string} for single user")
    public void and_user_validates_and_for_single_user(String id, String firstName, String lastName, String avatar) {
singleUser.validateAllInfo(id, firstName, lastName, avatar);
    }

    @Given("user validate {string}")
    public void user_validate(String expSupportUrl) {
        singleUser.validateSupportUrl(expSupportUrl);
    }


}
