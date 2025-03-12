package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pageObjects.HomePage;
import pageObjects.LogInPage;

public class TestAdminDeleteApplications {

    private static final HomePage homePage = new HomePage();
    private static final LogInPage login = new LogInPage("admin", "admin");

    @Test
    public void testDeleteAllApplications(){
        homePage.goTo();
        homePage.clickLoginButton();
        login.login();
        homePage.clickAdminButton();
    }

    @AfterEach
    public void cleanUp(){
        homePage.goTo();
        homePage.logOut();
    }
}
