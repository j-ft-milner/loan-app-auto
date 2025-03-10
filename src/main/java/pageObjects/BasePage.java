package pageObjects;

import config.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

abstract class BasePage {

    protected WebDriver driver = WebDriverManager.getDriver();
    protected Actions actions;
    protected WebDriverWait wait;

    public BasePage(){
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
}
