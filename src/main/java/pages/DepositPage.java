package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DepositPage {
    private WebDriver driver;

    // Locators
    private By amountField = By.xpath("//input[@type='number']");
    private By depositButton = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");
    private By successMessage = By.xpath("//span[contains(text(), 'Deposit Successful')]");
    private By transactionsButton = By.xpath("//button[contains(text(),'Transactions')]");
    private By withdrawButton = By.xpath("//button[contains(text(),'Withdrawl')]");


    // Constructor
    public DepositPage(WebDriver driver) {
        this.driver = driver;
    }

    // Enter deposit amount
    public void enterAmount(String amount) {
        driver.findElement(amountField).sendKeys(amount);
    }

    // Click deposit button
    public void clickDepositButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(depositButton));

        try {
            button.click();
        } catch (Exception e) {
            System.out.println("Normal click failed, using JavaScript click.");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }
    }

    // Verify deposit success
    public boolean isDepositSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increase wait time
        return wait.until(ExpectedConditions.presenceOfElementLocated(successMessage)).isDisplayed();
    }

    // Click Withdraw Button
    public WithdrawPage clickWithdraw() {
        driver.findElement(withdrawButton).click();
        return new WithdrawPage(driver);
    }

    public TransactionPage clickTransactions() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement transactionsBtn = wait.until(ExpectedConditions.elementToBeClickable(transactionsButton));
        transactionsBtn.click();
        return new TransactionPage(driver);
    }
}