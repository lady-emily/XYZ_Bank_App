package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountPage {
    private WebDriver driver;
    private By customerDropdown = By.id("userSelect");
    private By currencyDropdown = By.id("currency");
    private By processButton = By.xpath("//button[contains(text(),'Process')]");

    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createAccount(String customerName, String currency) {
        new Select(driver.findElement(customerDropdown)).selectByVisibleText(customerName);
        new Select(driver.findElement(currencyDropdown)).selectByVisibleText(currency);
        driver.findElement(processButton).click();

        // Handle alert confirmation
        driver.switchTo().alert().accept();
    }
}
