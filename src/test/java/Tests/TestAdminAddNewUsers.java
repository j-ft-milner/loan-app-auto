package Tests;

import config.User;
import org.junit.jupiter.api.*;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.UserManagementPage;

public class TestAdminAddNewUsers {

    private static final HomePage homePage = new HomePage();
    private static final LogInPage login = new LogInPage("admin", "admin");
    User user = new User();
    String username = user.getUsername();
    String email = user.getEmail();
    String password = user.getPassword();

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
        userManagementPage.registerNewUser(username, email, password);
        String successMsg = userManagementPage.getSuccessMessage();
        Assertions.assertEquals("Registration successful!", successMsg);
        try {
            homePage.goTo();
            homePage.logOut();
            new LogInPage(username, password).login();
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
    }

    @Test
    public void testAdminAddUserInTable(){
        UserManagementPage userManagementPage = new UserManagementPage();
        userManagementPage.clickRegisterButton();
        userManagementPage.registerNewUser(username, email, password);
        String successMsg = userManagementPage.getSuccessMessage();
        Assertions.assertEquals("Registration successful!", successMsg);

        homePage.goTo();
        homePage.clickAdminButton();
        userManagementPage.clickUserManageButton();
        Assertions.assertTrue(userManagementPage.checkUserInTable(username));
        userManagementPage.deleteUserFromTable(username);
    }

    @AfterEach
    public void cleanUp(){
        homePage.goTo();
        homePage.logOut();
    }
}

