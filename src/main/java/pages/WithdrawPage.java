package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WithdrawPage {
    private WebDriver driver;

    // Locators
    private By amountField = By.xpath("//input[@type='number']");
    private By withdrawButton = By.xpath("//button[contains(text(), 'Withdraw')]");
    private By successMessage = By.xpath("//span[contains(text(), 'Transaction successful')]");
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
        driver.findElement(withdrawButton).click();
    }

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
}
