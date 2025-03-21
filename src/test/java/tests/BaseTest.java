package tests;

import com.codeborne.selenide.Configuration;
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

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest implements ITestConstants, IConstants {
    HomePage homePage;
    AccountListPage accountListPage;
    NewAccountModalPage newAccountModalPage;
    NewContactModalPage newContactModalPage;
    LoginPage loginPage;
    Account account;
    AccountPage accountPage;
    ContactListPage contactListPage;

    public void initPages() {
        homePage =  new HomePage();
        accountListPage = new AccountListPage();
        newAccountModalPage = new NewAccountModalPage();
        loginPage =  new LoginPage();
        account = new Account();
        accountPage =  new AccountPage();
        newContactModalPage = new NewContactModalPage();
        contactListPage =  new ContactListPage();
    }

    @BeforeMethod
    public void initTest(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);

        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.headless = false;
        Configuration.browserSize = "1024x768";
        initPages();
    }

    @AfterMethod
    public void endTest() {
        getWebDriver().quit();
    }
}

