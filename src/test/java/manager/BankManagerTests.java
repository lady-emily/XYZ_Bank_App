package manager;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.*;

public class BankManagerTests extends BaseTests {

    @Test
    public void testAddCustomer() {
        BankManagerPage bankManagerPage = homePage.clickBankManagerLogin();
        AddCustomerPage addCustomerPage = bankManagerPage.clickAddCustomer();
        addCustomerPage.addCustomer("John", "Doe", "12345");
    }

    @Test
    public void testCreateAccount() {
        BankManagerPage bankManagerPage = homePage.clickBankManagerLogin();
        OpenAccountPage openAccountPage = bankManagerPage.clickOpenAccount();
        openAccountPage.createAccount("John Doe", "Dollar");
    }

    @Test
    public void testDeleteCustomer() {
        BankManagerPage bankManagerPage = homePage.clickBankManagerLogin();
        CustomersPage customersPage = bankManagerPage.clickCustomers();
        customersPage.deleteCustomer("John Doe");
    }
}