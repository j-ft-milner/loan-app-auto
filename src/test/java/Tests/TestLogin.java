package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageObjects.HomePage;
import pageObjects.LogInPage;

public class TestLogin {

    static HomePage homePage = new HomePage();

    @BeforeAll
    public static void setUp(){
        homePage.goTo();
        homePage.clickLoginButton();
    }

    @Test
    public void loginUserTest(){
        try {
            LogInPage login = new LogInPage("user", "user");
            login.login();
        }
        catch (Exception e){
            Assertions.fail();
        }
        Assertions.assertEquals("Welcome to the Loan Application Portal",homePage.getWelcomeText());

    }
}
