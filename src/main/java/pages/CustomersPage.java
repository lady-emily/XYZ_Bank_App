package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomersPage {
    private WebDriver driver;
    private By searchField = By.xpath("//input[@placeholder='Search Customer']");
    private By deleteButton = By.xpath("//button[contains(text(),'Delete')]");

    public CustomersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void deleteCustomer(String name) {
        driver.findElement(searchField).sendKeys(name);
        driver.findElement(deleteButton).click();
    }
}

