package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import pages.CustomerAuthenticationPage;
import pages.HomePage;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homepage;
    protected CustomerAuthenticationPage customerAuthenticationPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //declare driver variable and instantiate driver
        driver = new ChromeDriver();
        System.out.println("Instantiating Chrome Driver...");
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        homepage = new HomePage(driver);
        customerAuthenticationPage = new CustomerAuthenticationPage(driver);
    }

}
