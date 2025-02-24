package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddCustomerPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators using @FindBy
    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    private WebElement postCodeField;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/button")
    private WebElement addCustomerButton;

    @FindBy(xpath = "//button[contains(text(),'Home')]")
    private WebElement homeButton;

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    private WebElement openAccountButton;

    @FindBy(xpath ="//button[contains(text(),'Customers')]")
    private  WebElement customersButton;

    // Constructor
    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ Ensure WebDriverWait is initialized
        PageFactory.initElements(driver, this); // ✅ Initialize PageFactory elements
    }

    /**
     * Adds a customer by filling in the details and clicking the "Add Customer" button.
     * Ensures inputs are valid and handles alert confirmation.
     */
    public void addCustomer(String firstName, String lastName, String postCode) throws InterruptedException{
        // Validate inputs
        if (!firstName.matches("^[A-Za-z]+$")) {
            throw new IllegalArgumentException("❌ Invalid First Name: Only alphabetic characters are allowed.");
        }
        if (!lastName.matches("^[A-Za-z]+$")) {
            throw new IllegalArgumentException("❌ Invalid Last Name: Only alphabetic characters are allowed.");
        }
        if (!postCode.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("❌ Invalid Postcode: Only numeric characters are allowed.");
        }

        System.out.println("✅ Validation Passed. Proceeding with adding customer...");

        // Wait for fields to be visible and input values
        wait.until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys(firstName);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(lastNameField)).sendKeys(lastName);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(postCodeField)).sendKeys(postCode);

        // Wait for button to be clickable and click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(addCustomerButton)).click();

        // Handle alert confirmation
        try {
            WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Thread.sleep(2000);
            alertWait.until(ExpectedConditions.alertIsPresent()).accept();
            System.out.println("✅ Alert handled successfully.");
        } catch (Exception e) {
            System.out.println("⚠️ No alert appeared after clicking 'Add Customer'. Check UI behavior.");
        }
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

    public HomePage clickHomeButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(homeButton)).click();
        return new HomePage(driver);
    }
}
