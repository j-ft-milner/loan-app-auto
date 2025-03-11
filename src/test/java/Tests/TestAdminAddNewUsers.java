package Tests;

import org.junit.jupiter.api.*;
import pageObjects.AdminPage;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.UserManagementPage;

public class TestAdminAddNewUsers {

    private static final HomePage homePage = new HomePage();
    private static final LogInPage login = new LogInPage("admin", "admin");

    @BeforeEach
    public void setUp(){
        homePage.goTo();
        homePage.clickLoginButton();
        login.login();
        homePage.clickAdminButton();
    }

    @Test
    public void testAdminAddUser(){
        UserManagementPage userManagementPage = new UserManagementPage();
        userManagementPage.clickRegisterButton();
        userManagementPage.registerNewUser("user1", "user1@user", "12345678");
        String successMsg = userManagementPage.getSuccessMessage();
        Assertions.assertEquals("Registration successful!", successMsg);
        try {
            homePage.goTo();
            homePage.logOut();
            new LogInPage("user1", "12345678").login();
        }
        catch (Exception e){
            Assertions.fail(e);
        }
        Assertions.assertEquals("Welcome to the Loan Application Portal",homePage.getWelcomeText());
        homePage.goTo();
        homePage.logOut();
    }

    @Test
    public void testAdminAddUserInTable(){
        UserManagementPage userManagementPage = new UserManagementPage();
        userManagementPage.clickRegisterButton();
        userManagementPage.registerNewUser("bob", "bob@user", "abcdef");
        String successMsg = userManagementPage.getSuccessMessage();
        Assertions.assertEquals("Registration successful!", successMsg);

        homePage.goTo();
        homePage.clickAdminButton();
        userManagementPage.clickUserManageButton();
        Assertions.assertTrue(userManagementPage.checkUserInTable("bob"));
        homePage.goTo();
        homePage.logOut();
    }
}
