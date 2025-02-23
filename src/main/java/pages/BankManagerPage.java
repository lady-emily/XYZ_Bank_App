package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BankManagerPage {
    private WebDriver driver;
    private By addCustomerButton = By.xpath("//button[contains(text(),'Add Customer')]");
    private By openAccountButton = By.xpath("//button[contains(text(),'Open Account')]");
    private By customersButton = By.xpath("//button[contains(text(),'Customers')]");


    //constructor
    public BankManagerPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddCustomerPage clickAddCustomer() {
        WebElement addCustomer = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(addCustomerButton));
        addCustomer.click();
        return new AddCustomerPage(driver);
    }

    public OpenAccountPage clickOpenAccount() {
        WebElement openAccount = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(openAccountButton));
        openAccount.click();
        return new OpenAccountPage(driver);
    }

    public CustomersPage clickCustomers() {
        WebElement customers = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(customersButton));
        customers.click();
        return new CustomersPage(driver);
    }
}
