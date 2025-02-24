package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TransactionPage {
    private WebDriver driver;

    // Locators
    private By transactionsTable = By.xpath("//table[@class='table table-bordered table-striped']");
    private By transactionRows = By.xpath("//table[@class='table table-bordered table-striped']//tbody/tr");
    private By resetButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");
    private By backButton = By.xpath("//button[contains(text(), 'Back')]");
    private By homeButton2 = By.xpath("/html/body/div/div/div[1]/button[1]");


    // Constructor
    public TransactionPage(WebDriver driver) {
        this.driver = driver;
    }

    // Check if the transactions table is displayed
    public boolean isTransactionTableDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(transactionsTable)).isDisplayed();
    }

    // Get all transactions as a list
    public List<WebElement> getTransactionRecords() {
        return driver.findElements(transactionRows);
    }

    // Click Back button to return to Customer Dashboard
    public CustomerDashboard clickBackButton() {
        driver.findElement(backButton).click();
        return new CustomerDashboard(driver);
    }

    //Click Reset button
    public TransactionPage clickResetButton(){
        driver.findElement(resetButton).click();
        return new TransactionPage(driver);
    }

    //Click Home Button
    public CustomerAuthenticationPage clickHomeButton2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(homeButton2)).click();
        return new CustomerAuthenticationPage(driver);
    }
}
