package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ApplicationPage extends BasePage {

    public ApplicationPage(){

    }

    public String getErrorMessage(){
        WebElement errorMessage = driver.findElement(By.cssSelector("div.mt-4.alert.alert-danger"));
        return errorMessage.getText();
    }

    public String getAlertText(String field){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String script = "return document.querySelector('#" + "form" + field + "').validationMessage";

        return (String) jsExecutor.executeScript(script);
    }

    public String getResultText(){
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.lead")));

        return successMessage.getText();
    }

    public void populateApplicationForm(String firstName, String lastName, String age, String addressLine1, String addressLine2,
                                        String addressLine3, String addressLine4, String postcode, String email, String loanAmount){

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("formFirstName")));

        WebElement firstNameBox = driver.findElement(By.id("formFirstName"));
        firstNameBox.sendKeys(firstName);

        WebElement lastNameBox = driver.findElement(By.id("formLastName"));
        lastNameBox.sendKeys(lastName);

        WebElement ageBox = driver.findElement(By.id("formAge"));
        ageBox.sendKeys(age);

        WebElement addressLine1Box = driver.findElement(By.id("formAddressLine1"));
        addressLine1Box.sendKeys(addressLine1);

        WebElement addressLine2Box = driver.findElement(By.id("formAddressLine2"));
        addressLine2Box.sendKeys(addressLine2);

        WebElement addressLine3Box = driver.findElement(By.id("formAddressLine3"));
        addressLine3Box.sendKeys(addressLine3);

        WebElement addressLine4Box = driver.findElement(By.id("formAddressLine4"));
        addressLine4Box.sendKeys(addressLine4);

        WebElement postcodeBox = driver.findElement(By.id("formPostcode"));
        postcodeBox.sendKeys(postcode);

        WebElement emailBox = driver.findElement(By.id("formEmail"));
        emailBox.sendKeys(email);

        WebElement loanAmountBox = driver.findElement(By.id("formLoanAmount"));
        loanAmountBox.sendKeys(loanAmount);

        WebElement submitButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
        actions.moveToElement(submitButton).click().perform();

    }
}
