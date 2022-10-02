import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"src/test/java", "src/test/java/PageObject/PageElement", "src/test/java/PageObject/PageFunctions", "src/main/java/utils"},
        tags = "@JiraTestFromCucumber",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CucumberJunitTest {
}
