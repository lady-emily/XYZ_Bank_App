package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerAuthenticationPage {
    //fields
    private WebDriver driver;
    private By welcomeText = By.xpath("//label[contains(text(), 'Your Name :')]");
    private By customerNameField = By.id("userSelect");
    private By loginButton = By.linkText("Login");
    private By homeButton = By.linkText("Home");

    //methods
    //constructor
    public CustomerAuthenticationPage(WebDriver driver){
        this.driver = driver;
    }

//    public void selectCustomerName(){
//        driver.findElement(customerNameField).click(2);
//    }

    public boolean isPageLoaded(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeText)).isDisplayed();
    }

    public HomePage clickHomeButton(){
        driver.findElement(homeButton).click();
        return new HomePage(driver);
    }

    public CustomerDashboard clickLoginButton(){
        driver.findElement(loginButton).click();
        return new CustomerDashboard(driver);
    }
}
