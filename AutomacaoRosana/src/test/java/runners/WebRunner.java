package runners;

import core.Custom;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        tags = {"@0001"},
        monochrome = true,
        glue = {"steps"},
        plugin = {"html:target/reports/Relatorio.html", "pretty"},
        strict=true,
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class WebRunner extends Custom{

}
