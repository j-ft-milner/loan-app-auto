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

        System.out.println(applicationPage.getAlertText());
    }
}
