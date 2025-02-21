package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerAuthenticationPage {
    //fields
    private WebDriver driver;
    private By welcomeText = By.xpath("//label[contains(text(), 'Your Name :')]");
    private By customerDropdown = By.id("userSelect"); // Dropdown for selecting customer
    private By loginButton = By.xpath("//button[contains(text(), 'Login')]");
    private By homeButton = By.xpath("//button[contains(text(), 'Home')]");


    //methods
    //constructor
    public CustomerAuthenticationPage(WebDriver driver){
        this.driver = driver;
    }

    // Select a customer from the dropdown (Now returns `this` for method chaining)
    public CustomerAuthenticationPage selectCustomerName(String customerName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(customerDropdown));

        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(customerName);

        return this; // Enables method chaining
    }

    public boolean isPageLoaded(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeText)).isDisplayed();
    }

    //click Home button
    public HomePage clickHomeButton(){
        driver.findElement(homeButton).click();
        return new HomePage(driver);
    }

    // Click Login button
    public CustomerDashboard clickLoginButton() {
        driver.findElement(loginButton).click(); // Corrected: Find element first, then click
        return new CustomerDashboard(driver);
    }
}
