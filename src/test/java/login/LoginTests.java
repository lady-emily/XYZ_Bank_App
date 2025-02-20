package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CustomerAuthenticationPage;
import pages.CustomerDashboard;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulCustomerLogin(){
        System.out.println("Clicking Customer Login button...");
        CustomerAuthenticationPage customerAuthenticationPage = homePage.clickCustomerLogin();
        System.out.println("This all worked");
        //assertion
        assertTrue(customerAuthenticationPage.isPageLoaded(), "Customer authentication page did not load");
    }

}
