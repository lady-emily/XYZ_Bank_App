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
    //fields
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    private WebElement postCodeField;

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    private WebElement addCustomerButton;

    //constructor
    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // ✅ Initialize WebDriverWait FIRST
        PageFactory.initElements(driver, this); // ✅ Then initialize PageFactory elements
    }

    public void addCustomer(String firstName, String lastName, String postCode) {
        wait.until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postCodeField.sendKeys(postCode);
        wait.until(ExpectedConditions.elementToBeClickable(addCustomerButton)).click();

        // 🔹 Extra wait to ensure alert appears before interacting with it
        try {
            WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(8));
            alertWait.until(ExpectedConditions.alertIsPresent()).accept();
        } catch (Exception e) {
            System.out.println("⚠️ No alert appeared after clicking 'Add Customer'. Check UI behavior.");
        }
    }
}
