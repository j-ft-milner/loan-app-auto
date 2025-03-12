package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ApplicationManagementPage extends AdminPage{

    public ApplicationManagementPage(){
        clickApplicationManageButton();
    }

    public void deleteAllApplications(){
        WebElement delete = driver.findElement(By.cssSelector("button.btn.btn-danger"));
        delete.click();
    }
}
