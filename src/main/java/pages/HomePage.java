package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    //fields
    private WebDriver driver;
    private By customerLoginButton = By.linkText("Customer Login");
    private By bankManagerLoginButton = By.linkText("Bank Manager Login");

    //methods/ functions
    //constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //for interaction with home page
    public CustomerAuthenticationPage clickCustomerLogin(){
        driver.findElement(customerLoginButton).click();
        return new CustomerAuthenticationPage(driver);
    }

    //for interaction with customer authentication page

}
