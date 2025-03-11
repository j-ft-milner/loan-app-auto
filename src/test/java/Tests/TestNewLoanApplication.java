package Tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
    }



}
