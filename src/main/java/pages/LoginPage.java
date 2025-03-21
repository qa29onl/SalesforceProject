package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "Login")
    public WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public HomePage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        waitForPageLoad(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody")));
        return new HomePage(driver);
    }
}
