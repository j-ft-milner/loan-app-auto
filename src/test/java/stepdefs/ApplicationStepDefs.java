package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Exception;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pageObjects.ApplicationPage;
import pageObjects.HomePage;
import pageObjects.LogInPage;

import java.util.NoSuchElementException;

public class ApplicationStepDefs {

    private static final HomePage homePage = new HomePage();
    private static final LogInPage login = new LogInPage("user", "user");
    private static ApplicationPage applicationPage;


    @Step("Logged in user on the application page")
    @Given("a logged in user on the application page")
    public void aLoggedInUserOnTheApplicationPage(){
        if (!homePage.getUserLoggedIn().equals("NULL")){
            homePage.logOut();
        }
        homePage.goTo();
        homePage.clickLoginButton();
        login.login();
        homePage.clickApply();
    }

    @Step("User submits a valid application")
    @When("the user submits a valid application")
    public void theUserSubmitsAValidApplication(){
        applicationPage = new ApplicationPage();
        applicationPage.populateApplicationForm(
                "bob",
                "bill",
                "30",
                "123",
                "4",
                "City",
                "",
                "12345",
                "test@test",
                "10000");
    }

    @Step("Application is submitted")
    @Then("the application is submitted")
    public void theApplicationIsSubmitted(){
        Assertions.assertEquals("The initial application has been successful.", applicationPage.getResultText());
    }

    @Given("a user is on the loan application form")
    public void aUserIsOnTheLoanApplicationForm() {
        if (!homePage.getUserLoggedIn().equals("NULL")){
            homePage.goTo();
            homePage.logOut();
        }
        homePage.goTo();
        homePage.clickLoginButton();
        login.login();
        homePage.clickApply();
    }

    @When("the user submits the form with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void theUserSubmitsTheForm(
            String firstName, String lastName, String age, String phone, String houseNumber,
            String city, String address, String postcode, String email, String loanAmount) {

        applicationPage = new ApplicationPage();
        applicationPage.populateApplicationForm(firstName, lastName, age, phone, houseNumber, city, address, postcode, email, loanAmount);
    }

    @Then("an error message {string} is displayed")
    public void anErrorMessageIsDisplayed(String expectedMessage) {
        String actualMessage;

        if (expectedMessage.contains("@") || expectedMessage.equals("Please fill out this field.")) {
            actualMessage = applicationPage.getAlertText("Email");

            if (actualMessage == null || actualMessage.isEmpty()) {
                actualMessage = applicationPage.getAlertText("Postcode");
            }
        }
        else{
            actualMessage = applicationPage.getErrorMessage();
        }

        Assertions.assertEquals(expectedMessage, actualMessage);
    }
}

