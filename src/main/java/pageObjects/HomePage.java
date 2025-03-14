package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private static final String URL = "https://d2vo1vcw0l31zb.cloudfront.net/";

    private static final By LOGGED_IN_USER = By.cssSelector("#navbar-links span");

    public void goTo() {
        driver.get(URL);
    }

    public void logOut(){

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' Logout']")));
        link.click();

    }

    public void clickAdminButton(){
        WebElement admin = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Admin")));
        admin.click();
    }

    public void clickLoginButton(){
        WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login")));
        login.click();
    }

    public void clickApply(){
        WebElement apply = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.linkText("Apply")));
        apply.click();
    }

    public String getWelcomeText(){
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.tagName("h1")));
        return text.getText();
    }

    public String getUserLoggedIn() {

        String user;
        try {
            user = wait.until(ExpectedConditions.visibilityOfElementLocated(LOGGED_IN_USER)).getText();
        } catch (Exception e) {
            return "NULL";
        }
        return user;
    }

}
