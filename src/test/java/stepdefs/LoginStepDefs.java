package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pageObjects.HomePage;
import pageObjects.LogInPage;

public class LoginStepDefs {

    static HomePage homePage = new HomePage();
    LogInPage login;

    @Given("a user with valid login credentials on the login page")
    public void aUserWithValidLoginCredentialOnTheLoginPage(){
        if (!homePage.getUserLoggedIn().equals("NULL")){
            homePage.goTo();
            homePage.logOut();
        }
        homePage.goTo();
        homePage.clickLoginButton();
        login = new LogInPage("user", "user");
    }

    @When("the user logs in")
    public void theUserLogsIn(){
        login.login();
    }

    @Then("the user is logged in")
    public void theUserIsLoggedIn(){
        Assertions.assertEquals("user", homePage.getUserLoggedIn());
    }

    @Given("a user with invalid credential on the login page")
    public void aUserWithInvalidCredentialOnTheLoginPage(){
        if (!homePage.getUserLoggedIn().equals("NULL")){
            homePage.goTo();
            homePage.logOut();
        }
        homePage.goTo();
        homePage.clickLoginButton();
        login = new LogInPage("userfafdaf", "josafbal");
    }

    @When("the invalid user logs in")
    public void theInvalidUserLogsIn(){
        login.login();
    }

    @Then("the user is shown an error message")
    public void theUserIsShownAnErrorMessage(){
        Assertions.assertEquals("User not found", login.getErrorMessage());
    }

}