package manager;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.*;

public class BankManagerTests extends BaseTests {

    private WebDriver driver;

    @Test(priority = 1)
    public void testAddCustomer() throws InterruptedException {
        BankManagerPage bankManagerPage = homePage.clickBankManagerLogin();
        Thread.sleep(2000);
        AddCustomerPage addCustomerPage = bankManagerPage.clickAddCustomer();
        addCustomerPage.addCustomer("Emil", "Afia", "9888");
        Thread.sleep(2000);
        addCustomerPage.addCustomer("Lady", "Britney", "7567");
        Thread.sleep(2000);
        addCustomerPage.clickHomeButton();
//        bankManagerPage.clickOpenAccount();
        // bankManagerPage.clickCustomers();
    }

    @Test(priority = 2)
    public void testCreateAccount() throws InterruptedException {
        BankManagerPage bankManagerPage = homePage.clickBankManagerLogin();
        OpenAccountPage openAccountPage = bankManagerPage.clickOpenAccount();
        Thread.sleep(2000);
        openAccountPage.createAccount("Emil Afia", "Dollar");
        Thread.sleep(2000);
        openAccountPage.createAccount("Lady Britney", "Pound");
        Thread.sleep(2000);
        openAccountPage.clickHomeButton();
//        bankManagerPage.clickAddCustomer();
//        bankManagerPage.clickCustomers();

    }

    @Test(priority = 3)
    public void testDeleteCustomer() throws InterruptedException{
        BankManagerPage bankManagerPage = homePage.clickBankManagerLogin();
        CustomersPage customersPage = bankManagerPage.clickCustomers();
        customersPage.testClass();
        Thread.sleep(2000);
        customersPage.deleteCustomer("9888");
        customersPage.clickHomeButton();
////        bankManagerPage.clickAddCustomer();
////        bankManagerPage.clickOpenAccount();
    }
}