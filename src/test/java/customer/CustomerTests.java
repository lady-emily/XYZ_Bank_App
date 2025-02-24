package customer;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerDashboard;
import pages.TransactionPage;

import static org.testng.Assert.assertTrue;

public class CustomerTests extends BaseTests {

    @Test(priority = 1)
    public void testCustomerAuthentication() throws InterruptedException{
         customerAuthenticationPage = homePage.clickCustomerLogin()
                                    .selectCustomerName("Harry Potter");
        Thread.sleep(1000);
         customerAuthenticationPage.clickLoginButton();
        //assertion
            assertTrue(customerAuthenticationPage.isPageLoaded(), "Customer authentication page did not load");
        }

    @Test(priority = 2)
    public void testSuccessfulDeposit() throws InterruptedException {
//        testCustomerAuthentication();
        customerDashboard = customerAuthenticationPage.clickLoginButton();
        Thread.sleep(1000);
        depositPage = customerDashboard.clickDeposit();
        Thread.sleep(1000);
        depositPage.enterAmount("500");
        Thread.sleep(1000);
        depositPage.clickDepositButton();
        Assert.assertTrue(depositPage.isDepositSuccessful(), "Deposit was not successful!");
        Thread.sleep(1000);
        depositPage.clickHomeButton2();
    }

    @Test(priority = 3)
    public void testViewTransactions() throws InterruptedException{
        customerAuthenticationPage = homePage.clickCustomerLogin();
        customerAuthenticationPage.selectCustomerName("Harry Potter");
        Thread.sleep(2000);
        customerDashboard = customerAuthenticationPage.clickLoginButton();
        transactionPage = customerDashboard.clickTransactions();
        Thread.sleep(2000);
        Assert.assertTrue(transactionPage.isTransactionTableDisplayed(), "Transaction table not displayed!");
           transactionPage.clickBackButton();
    }

    @Test(priority = 4)
    public void testSuccessfulWithdrawal() throws InterruptedException {
        withdrawPage = customerDashboard.clickWithdraw();
        Thread.sleep(2000);
        withdrawPage.enterAmount("200");
        Thread.sleep(2000);
        withdrawPage.clickWithdrawButton();
        Thread.sleep(2000);
        Assert.assertTrue(withdrawPage.isWithdrawalSuccessful(), "Withdrawal failed!");
        Thread.sleep(2000);
        withdrawPage.clickHomeButton2();
        Thread.sleep(2000);
        testViewTransactions();
    }

    @Test(priority = 5)
    public void testClickResetButton() throws InterruptedException{
        transactionPage = customerDashboard.clickTransactions();
        Thread.sleep(2000);
        transactionPage.clickResetButton();
        Thread.sleep(2000);
        transactionPage.clickBackButton();
    }

}
