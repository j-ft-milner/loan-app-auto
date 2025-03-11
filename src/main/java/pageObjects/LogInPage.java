package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogInPage extends BasePage {

    String username;
    String password;

    public LogInPage(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void login() {
        fillUsername();
        fillPassword();
        submit();
    }

    private void fillUsername() {
        WebElement userBox = driver.findElement(By.id("formBasicUsername"));
        userBox.click();
        userBox.sendKeys(username);
    }

    private void fillPassword() {
        WebElement passBox = driver.findElement(By.id("formBasicPassword"));
        passBox.click();
        passBox.sendKeys(password);
    }

    private void submit() {
        WebElement submit = driver.findElement(By.cssSelector("button.w-100.btn.btn-primary"));;
        submit.click();
    }

}
