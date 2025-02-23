package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(withdrawButton));

        try {
            button.click();
        } catch (Exception e) {
            System.out.println("Normal click failed, using JavaScript click.");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }    }

    // Verify withdrawal success
    public boolean isWithdrawalSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }

    // Check if transaction failed (e.g., insufficient balance)
    public boolean isTransactionFailed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
    }

    public TransactionPage clickTransactions() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement transactionsBtn = wait.until(ExpectedConditions.elementToBeClickable(transactionsButton));
        transactionsBtn.click();
        return new TransactionPage(driver);
    }
}
