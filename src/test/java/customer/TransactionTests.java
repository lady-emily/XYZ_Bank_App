package customer;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerDashboard;
import pages.DepositPage;
import pages.WithdrawPage;

public class TransactionTests extends BaseTests {

    @Test
    public void testInsufficientBalance() {
        CustomerDashboard customerDashboard = homePage.clickCustomerLogin()
                .selectCustomerName("Harry Potter")
                .clickLoginButton();

        WithdrawPage withdrawPage = customerDashboard.clickWithdraw();
        withdrawPage.enterAmount("1000000"); // Excessive amount
        withdrawPage.clickWithdrawButton();

        Assert.assertTrue(withdrawPage.isTransactionFailed(), "Transaction did not fail for insufficient balance!");
    }

    @Test
    public void testNegativeDeposit() {
        CustomerDashboard customerDashboard = homePage.clickCustomerLogin()
                .selectCustomerName("Harry Potter")
                .clickLoginButton();

        DepositPage depositPage = customerDashboard.clickDeposit();
        depositPage.enterAmount("-100");
        depositPage.clickDepositButton();

        Assert.assertFalse(depositPage.isDepositSuccessful(), "Negative deposit was incorrectly processed!");
    }

    @Test
    public void testZeroDeposit() {
        CustomerDashboard customerDashboard = homePage.clickCustomerLogin()
                .selectCustomerName("Harry Potter")
                .clickLoginButton();

        DepositPage depositPage = customerDashboard.clickDeposit();
        depositPage.enterAmount("0");
        depositPage.clickDepositButton();

        Assert.assertFalse(depositPage.isDepositSuccessful(), "Zero deposit was incorrectly processed!");
    }

    @Test
    public void testNegativeWithdrawal() {
        CustomerDashboard customerDashboard = homePage.clickCustomerLogin()
                .selectCustomerName("Harry Potter")
                .clickLoginButton();

        WithdrawPage withdrawPage = customerDashboard.clickWithdraw();
        withdrawPage.enterAmount("-50");
        withdrawPage.clickWithdrawButton();

        Assert.assertFalse(withdrawPage.isWithdrawalSuccessful(), "Negative withdrawal was incorrectly processed!");
    }

    @Test
    public void testZeroWithdrawal() {
        CustomerDashboard customerDashboard = homePage.clickCustomerLogin()
                .selectCustomerName("Harry Potter")
                .clickLoginButton();

        WithdrawPage withdrawPage = customerDashboard.clickWithdraw();
        withdrawPage.enterAmount("0");
        withdrawPage.clickWithdrawButton();

        Assert.assertFalse(withdrawPage.isWithdrawalSuccessful(), "Zero withdrawal was incorrectly processed!");
    }
}
