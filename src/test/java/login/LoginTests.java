package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerAuthenticationPage;
import pages.CustomerDashboard;
import pages.TransactionPage;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulCustomerLogin(){
        System.out.println("Clicking Customer Login button...");
        CustomerAuthenticationPage customerAuthenticationPage = homePage.clickCustomerLogin();
        //assertion
        assertTrue(customerAuthenticationPage.isPageLoaded(), "Customer authentication page did not load");
    }

    @Test
    public void testViewTransactions() {
        CustomerDashboard customerDashboard = homePage.clickCustomerLogin()
                .selectCustomerName("Harry Potter")  // Replace with valid customer
                .clickLoginButton();

        TransactionPage transactionPage = customerDashboard.clickTransactions();

        Assert.assertTrue(transactionPage.isTransactionTableDisplayed(), "Transaction table not displayed!");

        int transactionCount = transactionPage.getTransactionRecords().size();
        System.out.println("Number of transactions found: " + transactionCount);
        Assert.assertTrue(transactionCount > 0, "No transactions found!");

        transactionPage.clickBackButton();
    }
}
