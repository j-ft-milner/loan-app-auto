package config;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebDriverInstance {

    private static WebDriver driver;
    private static String browser = "chrome";

    public static void setBrowser(String browserType) {
        browser = browserType;
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            if (browser.equals("firefox")) {
                driver = new FirefoxDriver();
                driver.manage().window().setPosition(new Point(-2000, 0));
            } else if (browser.equals("edge")) {
                driver = new EdgeDriver();
            } else if (browser.equals("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1400,800");
                driver = new ChromeDriver(options);
            }
            assert driver != null;
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        }
        return driver;
    }

}
