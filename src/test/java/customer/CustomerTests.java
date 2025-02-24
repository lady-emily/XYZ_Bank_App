package customer;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TransactionPage;

import static org.testng.Assert.assertTrue;

public class CustomerTests extends BaseTests {

    @Test
    public void testCustomerAuthentication() throws InterruptedException{
         customerAuthenticationPage = homePage.clickCustomerLogin()
                                    .selectCustomerName("Harry Potter");
        Thread.sleep(1000);
         customerAuthenticationPage.clickLoginButton();
        //assertion
            assertTrue(customerAuthenticationPage.isPageLoaded(), "Customer authentication page did not load");
        }

    @Test
    public void testSuccessfulDeposit() throws InterruptedException {
        testCustomerAuthentication();
        customerDashboard = customerAuthenticationPage.clickLoginButton();
        Thread.sleep(2000);
        depositPage = customerDashboard.clickDeposit();
        Thread.sleep(2000);
        depositPage.enterAmount("500");
        Thread.sleep(2000);
        depositPage.clickDepositButton();
        Assert.assertTrue(depositPage.isDepositSuccessful(), "Deposit was not successful!");
        Thread.sleep(2000);
        depositPage.clickHomeButton2();
    }

    @Test
    public void testViewTransactions() throws InterruptedException{
        customerAuthenticationPage = homePage.clickCustomerLogin();
        customerAuthenticationPage.selectCustomerName("Harry Potter");
        customerDashboard = customerAuthenticationPage.clickLoginButton();
        transactionPage = customerDashboard.clickTransactions();

        // Wait for 3 seconds before checking the transactions table
        Thread.sleep(2000);

        Assert.assertTrue(transactionPage.isTransactionTableDisplayed(), "Transaction table not displayed!");
           transactionPage.clickBackButton();
    }

    @Test
    public void testSuccessfulWithdrawal() throws InterruptedException {
        testSuccessfulDeposit();
        testCustomerAuthentication();
        withdrawPage = customerDashboard.clickWithdraw();
        Thread.sleep(2000);
        withdrawPage.enterAmount("200");
        withdrawPage.clickWithdrawButton();
        Thread.sleep(2000);
        Assert.assertTrue(withdrawPage.isWithdrawalSuccessful(), "Withdrawal failed!");
        withdrawPage.clickHomeButton2();
        testViewTransactions();
    }

}
