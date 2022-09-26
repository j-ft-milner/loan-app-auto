package Tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import static Tests.TestSuite.driverFactory;

public class NewLoanApplication {

    public static WebDriver driver = driverFactory.getDriver();
    private final HomePage homepage = new HomePage(driver);

    @Before
    public void individualSetUp(){
        homepage.goTo();
    }

    @Test
    public void test(){

    }

}
