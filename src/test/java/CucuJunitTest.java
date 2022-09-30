import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"src/test/java", "src/test/java/Hooks", "src/test/java/PageObject", "src/test/java/StepDefinition", "src/main/java/utils"},
        tags = "@JiraTest",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CucuJunitTest {
}
