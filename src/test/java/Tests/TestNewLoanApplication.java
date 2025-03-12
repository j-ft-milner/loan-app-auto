package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageObjects.ApplicationPage;
import pageObjects.HomePage;
import pageObjects.LogInPage;

public class TestNewLoanApplication {

    private static final HomePage homePage = new HomePage();
    private static final LogInPage login = new LogInPage("user", "user");

    @BeforeAll
    public static void setUp(){
        homePage.goTo();
    }

    @Test
    public void test(){
        homePage.clickLoginButton();
        login.login();
        homePage.clickApply();
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
                "test@test",
                "10000");

        Assertions.assertEquals("The initial application has been successful.", applicationPage.getResultText());
    }

    @AfterEach
    public void cleanUp(){
        homePage.goTo();
        homePage.logOut();
    }
}
