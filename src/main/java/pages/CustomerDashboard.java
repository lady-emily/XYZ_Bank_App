package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.json.JsonOutput;

public class CustomerDashboard {
    //fields
    private WebDriver driver;
    private By homeButton = By.linkText("Home");


    //methods
    public CustomerDashboard(WebDriver driver){
        this.driver = driver;
    }

    public CustomerAuthenticationPage clickHomeButton(){
        driver.findElement(homeButton).click();
        return new CustomerAuthenticationPage(driver);
    }

}
