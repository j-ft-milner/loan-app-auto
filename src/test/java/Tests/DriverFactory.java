package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    static {
        WebDriverManager.edgedriver().setup();
    }

    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            setDriver();
        }
        return driver;
    }

    private void setDriver() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

}
