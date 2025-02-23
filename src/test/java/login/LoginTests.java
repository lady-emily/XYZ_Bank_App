package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void testCustomerAuthentication(){
        homePage.clickCustomerLogin();
         customerAuthenticationPage = homePage.clickCustomerLogin()
                                    .selectCustomerName("Harry Potter");
         customerAuthenticationPage.clickLoginButton();
        //assertion
            assertTrue(customerAuthenticationPage.isPageLoaded(), "Customer authentication page did not load");
        }

    @Test
    public void testSuccessfulDeposit() {
        customerDashboard = customerAuthenticationPage.clickLoginButton();
        depositPage = customerDashboard.clickDeposit();
        depositPage.enterAmount("500");
        depositPage.clickDepositButton();

        Assert.assertTrue(depositPage.isDepositSuccessful(), "Deposit was not successful!");
    }

    @Test
    public void testSuccessfulWithdrawal() {
        withdrawPage = depositPage.clickWithdraw();
        withdrawPage.enterAmount("200");
        withdrawPage.clickWithdrawButton();

        Assert.assertTrue(withdrawPage.isWithdrawalSuccessful(), "Withdrawal failed!");
    }

//    @Test
//    public void testViewTransactions() throws InterruptedException{
//        transactionPage = withdrawPage.clickTransactions();
//
//        // Wait for 3 seconds before checking the transactions table
//        Thread.sleep(3000);
//
//        Assert.assertTrue(transactionPage.isTransactionTableDisplayed(), "Transaction table not displayed!");
//        transactionPage.getTransactionRecords();
////        transactionPage.clickBackButton();
//    }



}
