package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.CustomerAuthenticationPage;
import pages.HomePage;

public class BaseTests {
    //fields
    private WebDriver driver;
    protected HomePage homePage;
    protected CustomerAuthenticationPage customerAuthenticationPage;

    @BeforeClass
    public void setUp(){
        //Use WebDriverManager for automatic driver setup
        WebDriverManager.chromedriver().setup();
        //declare driver variable and instantiate driver
        driver = new ChromeDriver();
        System.out.println("Instantiating Chrome Browser...");
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();
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
