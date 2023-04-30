package homeworkProject.stepdef;

import homeworkProject.pages.ListResource;
import io.cucumber.java.en.Given;

public class ListResourcesStepDef {
    ListResource listResource = new ListResource();

    @Given("user send GET request to list of resources and validates status code is {int}")
    public void user_send_get_request_to_list_of_resources_and_validates_status_code_is(Integer expStatusCode) {
        listResource.validateStatusCode(expStatusCode);
    }

    @Given("user validates sum of ids equal to {int}")
    public void user_validates_sum_of_ids_equal_to(Integer expSum) {
        listResource.sumOfId(expSum);
    }

    @Given("user validates average years equal to {double}")
    public void user_validates_average_years_equal_to(Double expAverageYear) {
        listResource.averageOfYears(expAverageYear);
    }


}
