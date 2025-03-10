package pageObjects;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final String URL = "https://d2vo1vcw0l31zb.cloudfront.net/";

    public void goTo() {
        driver.get(URL);
    }

}
