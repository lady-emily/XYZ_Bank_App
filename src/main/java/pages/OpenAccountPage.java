package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenAccountPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By customerDropdown = By.id("userSelect");
    private By currencyDropdown = By.id("currency");
    private By processButton = By.xpath("//button[contains(text(),'Process')]");
    private By addCustomerButton = By.xpath("//button[contains(text(),'Add Customer')]");
    private By openAccountButton = By.xpath("//button[contains(text(),'Open Account')]");
    private By customersButton = By.xpath("//button[contains(text(),'Customers')]");

    @FindBy(xpath = "//button[contains(text(),'Home')]")
    private WebElement homeButton;

    //constructor
    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ Ensure WebDriverWait is initialized
        PageFactory.initElements(driver, this); // ✅ Initialize PageFactory elements
    }

    public void createAccount(String customerName, String currency) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerDropdown));

        new Select(driver.findElement(customerDropdown)).selectByVisibleText(customerName);
        Thread.sleep(2000);
        new Select(driver.findElement(currencyDropdown)).selectByVisibleText(currency);
        Thread.sleep(2000);
        driver.findElement(processButton).click();

        // Handle alert confirmation
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }

    public AddCustomerPage clickAddCustomer() {
        WebElement addCustomer = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(addCustomerButton));
        addCustomer.click();
        return new AddCustomerPage(driver);
    }

    public CustomersPage clickCustomers() {
        WebElement customers = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(customersButton));
        customers.click();
        return new CustomersPage(driver);
    }

    public HomePage clickHomeButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(homeButton)).click();
        return new HomePage(driver);
    }
}
