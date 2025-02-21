package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    //fields
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    private WebElement customerLoginButton;

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    private WebElement bankManagerLoginButton;

    @FindBy(xpath = "//button[contains(text(),'Home')]")
    private WebElement homeButton;


    //methods
    //constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //for interaction with customer authentication page
    public CustomerAuthenticationPage clickCustomerLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(customerLoginButton)).click();
        return new CustomerAuthenticationPage(driver);
    }

    public BankManagerPage clickBankManagerLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(bankManagerLoginButton)).click();
        return new BankManagerPage(driver);
    }

    public HomePage clickHomeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(homeButton)).click();
        return new HomePage(driver);
    }

}
