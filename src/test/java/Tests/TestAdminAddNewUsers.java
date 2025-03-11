package Tests;

import org.junit.jupiter.api.*;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.UserManagementPage;

public class TestAdminAddNewUsers {

    private static final HomePage homePage = new HomePage();
    private static final LogInPage login = new LogInPage("admin", "admin");
    private static final String username = "bob";

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
        userManagementPage.registerNewUser(username, "user1@user", "12345678");
        String successMsg = userManagementPage.getSuccessMessage();
        Assertions.assertEquals("Registration successful!", successMsg);
        try {
            homePage.goTo();
            homePage.logOut();
            new LogInPage(username, "12345678").login();
        }
        catch (Exception e){
            Assertions.fail(e);
        }
        Assertions.assertEquals("Welcome to the Loan Application Portal",homePage.getWelcomeText());
        homePage.goTo();
        homePage.logOut();
        login.login();
        homePage.clickAdminButton();
        userManagementPage.clickUserManageButton();
        userManagementPage.deleteUserFromTable(username);
        homePage.goTo();
        homePage.logOut();
    }

    @Test
    public void testAdminAddUserInTable(){
        UserManagementPage userManagementPage = new UserManagementPage();
        userManagementPage.clickRegisterButton();
        userManagementPage.registerNewUser(username, "bob@user", "abcdef");
        String successMsg = userManagementPage.getSuccessMessage();
        Assertions.assertEquals("Registration successful!", successMsg);

        homePage.goTo();
        homePage.clickAdminButton();
        userManagementPage.clickUserManageButton();
        Assertions.assertTrue(userManagementPage.checkUserInTable(username));
        userManagementPage.deleteUserFromTable(username);
        homePage.goTo();
        homePage.logOut();
    }
}
