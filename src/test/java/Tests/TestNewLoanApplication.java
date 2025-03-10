package Tests;

import org.junit.jupiter.api.Test;
import pageObjects.HomePage;

public class TestNewLoanApplication {

    private final HomePage homepage = new HomePage();

    //TODO Test to add valid loan applications
    @Test
    public void test(){
        homepage.goTo();
    }

    //TODO Various tests adding loan applications

}
