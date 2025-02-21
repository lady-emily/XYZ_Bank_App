package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerDashboard {
    //fields
    private WebDriver driver;
    private By transactionsButton = By.xpath("//button[contains(text(),'Transactions')]");
    private By depositButton = By.xpath("//button[contains(text(),'Deposit')]");
    private By withdrawButton = By.xpath("//button[contains(text(),'Withdrawl')]");
//    private By amountField = By.xpath("//input[@type='number']");
//    private By getDepositButton = By.xpath("//button[contains(text(),'Deposit')]");
//    private By getWithdrawButton = By.xpath("//button[contains(text(),'Withdraw')]");
    private By homeButton = By.linkText("Home");


    //methods
    public CustomerDashboard(WebDriver driver){
        this.driver = driver;
    }

    // Navigate to Transaction Page
    public TransactionPage clickTransactions() {
        driver.findElement(transactionsButton).click();
        return new TransactionPage(driver);
    }

    // Click Deposit Button
    public DepositPage clickDeposit() {
        driver.findElement(depositButton).click();
        return new DepositPage(driver);
    }

    // Click Withdraw Button
    public WithdrawPage clickWithdraw() {
        driver.findElement(withdrawButton).click();
        return new WithdrawPage(driver);
    }

    public HomePage clickHomeButton(){
        driver.findElement(homeButton).click();
        return new HomePage(driver);
    }

//    public void depositFunds(int amount) {
//        driver.findElement(depositButton).click();
//        driver.findElement(amountField).sendKeys(String.valueOf(amount));
//        driver.findElement(getDepositButton).click();
//    }
//
//    public void withdrawFunds(int amount) {
//        driver.findElement(withdrawButton).click();
//        driver.findElement(amountField).sendKeys(String.valueOf(amount));
//        driver.findElement(getWithdrawButton).click();
//    }



}
