package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DepositPage {
    private WebDriver driver;

    // Locators
    private By amountField = By.xpath("//input[@type='number']");
    private By depositButton = By.xpath("//button[contains(text(), 'Deposit')]");
    private By successMessage = By.xpath("//span[contains(text(), 'Deposit Successful')]");

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
        driver.findElement(depositButton).click();
    }

    // Verify deposit success
    public boolean isDepositSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }
}
