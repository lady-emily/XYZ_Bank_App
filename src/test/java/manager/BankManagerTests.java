package manager;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.*;

public class BankManagerTests extends BaseTests {

    private WebDriver driver;

    @Test
    public void testAddCustomer() {
        BankManagerPage bankManagerPage = homePage.clickBankManagerLogin();
        AddCustomerPage addCustomerPage = bankManagerPage.clickAddCustomer();
        addCustomerPage.addCustomer("Emil", "Afia", "9888");
        addCustomerPage.addCustomer("Lady", "Britney", "7567");
        addCustomerPage.clickHomeButton();
//        bankManagerPage.clickOpenAccount();
        // bankManagerPage.clickCustomers();
    }

    @Test
    public void testCreateAccount() {
        BankManagerPage bankManagerPage = homePage.clickBankManagerLogin();
        OpenAccountPage openAccountPage = bankManagerPage.clickOpenAccount();
        openAccountPage.createAccount("Emil Afia", "Dollar");
        openAccountPage.createAccount("Lady Britney", "Pound");
        openAccountPage.clickHomeButton();
//        bankManagerPage.clickAddCustomer();
//        bankManagerPage.clickCustomers();

    }

    @Test
    public void testDeleteCustomer() {
        BankManagerPage bankManagerPage = homePage.clickBankManagerLogin();
        CustomersPage customersPage = bankManagerPage.clickCustomers();
        customersPage.testClass();
        customersPage.deleteCustomer("9888");
////        customersPage.clickHomeButton();
////        bankManagerPage.clickAddCustomer();
////        bankManagerPage.clickOpenAccount();
    }
}