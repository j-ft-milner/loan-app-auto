package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class UserManagementPage extends AdminPage{

    public UserManagementPage(){
        clickUserManageButton();
    }

    public String getSuccessMessage(){
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div[role='alert'].alert.alert-success.show")));
        return successMsg.getText();
    }

    public void registerNewUser(String username, String email, String password){
        WebElement userBox = driver.findElement(By.id("formBasicUsername"));
        userBox.click();
        userBox.sendKeys(username);
        WebElement emailBox = driver.findElement(By.id("formBasicEmail"));
        emailBox.click();
        emailBox.sendKeys(email);
        WebElement passBox = driver.findElement(By.id("formBasicPassword"));
        passBox.click();
        passBox.sendKeys(password);

        WebElement button = driver.findElement(By.xpath("//button[text()='Register']"));
        button.click();
    }

    public void clickRegisterButton(){
        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Register a New User')]"));
        button.click();
    }

    public boolean checkUserInTable(String username){
        WebElement table = driver.findElement(By.cssSelector("table.UserManagement_table__fAz7r"));

        List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));
        for (WebElement row : rows) {
            WebElement usernameCell = row.findElements(By.tagName("td")).get(1);
            String rowUsername = usernameCell.getText().trim();

            if (rowUsername.equals(username)) {
                return true;
            }
        }
        return false;
    }
}
