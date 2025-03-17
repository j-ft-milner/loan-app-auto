package stepdefs;

import config.WebDriverInstance;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private static WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        String tag = System.getProperty("cucumber.filter.tags", "@chrome");

        if (tag.contains("@firefox") && scenario.getSourceTagNames().contains("@firefox")) {
            WebDriverInstance.setBrowser("firefox");
        } else if (tag.contains("@edge") && scenario.getSourceTagNames().contains("@edge")) {
            WebDriverInstance.setBrowser("edge");
        } else {
            WebDriverInstance.setBrowser("chrome");
        }

    }
}
