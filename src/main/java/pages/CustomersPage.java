package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CustomersPage {

    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath = "//button[contains(text(),'Home')]")
    private WebElement homeButton;

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    private WebElement openAccountButton;

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    private WebElement addCustomerButton;

    // Constructor
    public CustomersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Deletes a row based on the given Postcode.
     */
    public void deleteCustomer(String postcode) throws InterruptedException {
        try {
            // XPath to locate the row containing the given Postcode
            String rowXpath = "//tr[td[contains(text(), '" + postcode + "')]]";
            // XPath for the "Delete" button in the same row
            String deleteButtonXpath = rowXpath + "//button[contains(text(),'Delete')]";

            // Wait for the delete button to be clickable
            WebElement deleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(deleteButtonXpath)));

            // Wait an additional 5 seconds before clicking
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.elementToBeClickable(deleteButton));

            // Click the Delete button
            Thread.sleep(3000);
            deleteButton.click();

            System.out.println("✅ Successfully deleted customer with Postcode: " + postcode);
        }
        catch (TimeoutException e) {
            System.out.println("❌ No matching customer found with Postcode: " + postcode);
        }
    }

    /**
     * Clicks the "Open Account" button and navigates to OpenAccountPage.
     */
    public OpenAccountPage clickOpenAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(openAccountButton)).click();
        return new OpenAccountPage(driver);
    }

    /**
     * Clicks the "Add Customer" button and navigates to AddCustomerPage.
     */
    public AddCustomerPage clickAddCustomer() {
        wait.until(ExpectedConditions.elementToBeClickable(addCustomerButton)).click();
        return new AddCustomerPage(driver);
    }

    /**
     * Clicks the "Home" button and navigates to HomePage.
     */
    public HomePage clickHomeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(homeButton)).click();
        return new HomePage(driver);
    }

    public void testClass(){
        System.out.println("TEsting customers page");
    }
}
