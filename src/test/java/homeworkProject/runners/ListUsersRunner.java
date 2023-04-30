package homeworkProject.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/ListUsers.feature", //features
        glue = "homeworkProject/stepdef/ListUserdStep.java", //step definitions
        dryRun = false, //getting snips without executing
        tags = "@aaa",
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"}
        //and refers to one scenario
        //or refers to multiple scenarios
)
public class ListUsersRunner {
}
