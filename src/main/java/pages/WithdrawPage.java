package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WithdrawPage {
    private WebDriver driver;

    // Locators
    private By amountField = By.xpath("//input[@type='number']");
    private By withdrawButton = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");
    private By successMessage = By.xpath("//span[contains(text(), 'Transaction successful')]");
    private By transactionsButton = By.xpath("//button[contains(text(),'Transactions')]");
    private By errorMessage = By.xpath("//span[contains(text(), 'Transaction Failed')]");
    private By homeButton2 = By.xpath("/html/body/div/div/div[1]/button[1]");


    // Constructor
    public WithdrawPage(WebDriver driver) {
        this.driver = driver;
    }

    // Enter withdrawal amount
    public void enterAmount(String amount) {
        driver.findElement(amountField).sendKeys(amount);
    }

    // Click withdraw button
    public void clickWithdrawButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement button1 = wait.until(ExpectedConditions.elementToBeClickable(withdrawButton));

        try {
            button1.click();
        } catch (Exception e) {
            System.out.println("Normal click failed, using JavaScript click.");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button1);
        }    }

    // Verify withdrawal success
    public boolean isWithdrawalSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set wait time
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)); // Wait for the success message
            return true; // If element is found, return true
        } catch (TimeoutException e) {
            return false; // If element is not found within timeout, return false
        }
    }

    // Check if transaction failed (e.g., insufficient balance)
    public boolean isTransactionFailed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set wait time
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)); // Wait for the success message
            return true; // If element is found, return true
        } catch (TimeoutException e) {
            return false; // If element is not found within timeout, return false
        }

    }

    public TransactionPage clickTransactions() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement transactionsBtn = wait.until(ExpectedConditions.elementToBeClickable(transactionsButton));
        transactionsBtn.click();
        return new TransactionPage(driver);
    }

    public CustomerAuthenticationPage clickHomeButton2(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(homeButton2)).click();
        return new CustomerAuthenticationPage(driver);
    }
}
