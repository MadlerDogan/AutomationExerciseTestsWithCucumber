package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:src/test/resources/reports/Reports.html"},
        features = "src/test/resources/features",
        glue ={"stepdef","hooks"},
        tags = "@Register",
        dryRun = true

)
public class Runner {

}