import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.platform.suite.api.*;
import org.junit.runner.RunWith;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")

public class CucumberTests {

}
