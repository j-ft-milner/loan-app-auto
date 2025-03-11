package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObjects.ApplicationPage;
import pageObjects.HomePage;
import pageObjects.LogInPage;

public class TestNewLoanApplicationFieldValidation {

    private static final HomePage homePage = new HomePage();
    private static final LogInPage login = new LogInPage("user", "user");

    @BeforeAll
    public static void setUp(){
        homePage.goTo();
        homePage.clickLoginButton();
        login.login();
        homePage.clickApply();
    }

    @BeforeEach
    public void refreshForm(){
        homePage.goTo();
        homePage.clickApply();
    }

    @Test
    public void testInvalidAge(){
        ApplicationPage applicationPage = new ApplicationPage();
        applicationPage.populateApplicationForm(
                "bob",
                "bill",
                "12",
                "123",
                "4",
                "City",
                "",
                "12345",
                "test@test",
                "10000");

        Assertions.assertEquals("Error: Age must be 18 or over.", applicationPage.getErrorMessage());
    }

    @Test
    public void testEmptyEmail(){
        ApplicationPage applicationPage = new ApplicationPage();
        applicationPage.populateApplicationForm(
                "bob",
                "bill",
                "30",
                "123",
                "4",
                "City",
                "",
                "12345",
                "",
                "10000");

        Assertions.assertEquals("Please fill in this field.", applicationPage.getAlertText("Email"));
    }

    @Test
    public void testInvalidEmailFormat(){
        ApplicationPage applicationPage = new ApplicationPage();
        applicationPage.populateApplicationForm(
                "bob",
                "bill",
                "30",
                "123",
                "4",
                "City",
                "",
                "12345",
                "email",
                "10000");

        Assertions.assertEquals("Please include an '@' in the email address. 'email' is missing an '@'.", applicationPage.getAlertText("Email"));
    }

    @Test
    public void testInvalidLoanAmount(){
        ApplicationPage applicationPage = new ApplicationPage();
        applicationPage.populateApplicationForm(
                "bob",
                "bill",
                "20",
                "123",
                "4",
                "City",
                "",
                "12345",
                "test@test",
                "10");

        Assertions.assertEquals("Error: Loan amount must be at least 1000.", applicationPage.getErrorMessage());
    }

    @Test
    public void testEmptyPostcode(){
        ApplicationPage applicationPage = new ApplicationPage();
        applicationPage.populateApplicationForm(
                "bob",
                "bill",
                "30",
                "123",
                "4",
                "City",
                "",
                "",
                "email@email",
                "10000");

        Assertions.assertEquals("Please fill in this field.", applicationPage.getAlertText("Postcode"));
    }
}
