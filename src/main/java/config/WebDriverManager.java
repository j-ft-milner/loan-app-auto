package config;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {

    private static final WebDriver DRIVER = WebDriverInstance.getInstance();

    private static final Thread THREAD = new Thread(DRIVER::quit);

    static {
        Runtime.getRuntime().addShutdownHook(THREAD);
    }

    public static WebDriver getDriver(){
        return DRIVER;
    }

}
