package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

import java.time.Duration;

public class BaseTests {
    //fields
    private WebDriver driver;
    protected HomePage homePage;
    protected AddCustomerPage addCustomerPage;
    protected OpenAccountPage openAccountPage;
    protected CustomersPage customersPage;

    protected CustomerAuthenticationPage customerAuthenticationPage;

    @BeforeClass
    public void setUp(){
        //Use WebDriverManager for automatic driver setup
        WebDriverManager.chromedriver().setup();
        //declare driver variable and initialise driver
        driver = new ChromeDriver();
        System.out.println("Initialising Chrome Browser...");
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println(driver.getTitle());

        homePage = new HomePage(driver);
        customerAuthenticationPage = new CustomerAuthenticationPage(driver);
    }

//    @AfterClass
//    public void terminateSession(){
//        if (driver != null){
//            driver.quit();
//            System.out.println("Closing Browser...");
//        }
//    }
}
