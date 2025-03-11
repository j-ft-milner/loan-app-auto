package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdminPage extends BasePage{

    protected void clickApplicationManageButton(){
        WebElement button = driver.findElement(By.linkText("Applications Management"));
        button.click();
    }

    public void clickUserManageButton(){
        WebElement button = driver.findElement(By.linkText("User Management"));
        button.click();
    }
}
