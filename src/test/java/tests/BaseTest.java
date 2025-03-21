package tests;

import constants.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import objects.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest implements ITestConstants, IConstants {
    WebDriver driver;
    HomePage homePage;
    AccountListPage accountListPage;
    NewAccountModalPage newAccountModalPage;
    NewContactModalPage newContactModalPage;
    LoginPage loginPage;
    Account account;
    AccountPage accountPage;
    ContactListPage contactListPage;


    /**
     * Inits  pages
     */
    public void initPages() {
        homePage =  new HomePage(driver);
        accountListPage = new AccountListPage(driver);
        newAccountModalPage = new NewAccountModalPage(driver);
        loginPage =  new LoginPage(driver);
        account = new Account();
        accountPage =  new AccountPage(driver);
        newContactModalPage = new NewContactModalPage(driver);
        contactListPage =  new ContactListPage(driver);
    }

    /**
     * Init test.
     * This method performed before the test method
     */
    @BeforeMethod
    public void initTest(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        PageFactory.initElements(driver,this);
        initPages();
    }

    /**
     * End test.
     * This method performed after test method
     */
    @AfterMethod
    public void endTest() {
        driver.quit();
    }
}

