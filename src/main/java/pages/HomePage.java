package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    //fields
    private WebDriver driver;
    private By customerLoginButton = By.xpath("//button[contains(text(), 'Customer Login')]");
    //private By bankManagerLoginButton = By.cssSelector("<button class=\"btn btn-primary btn-lg\" ng-click=\"manager()\">Bank Manager Login</button>");

    //methods/ functions
    //constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //for interaction with customer authentication page
    public CustomerAuthenticationPage clickCustomerLogin(){
        //Explicit wait for the driver to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(customerLoginButton));
        button.click();
        return new CustomerAuthenticationPage(driver);
    }

    //for interaction with customer authentication page

}
