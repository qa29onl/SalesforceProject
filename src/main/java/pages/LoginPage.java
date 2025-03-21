package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {

    public static final SelenideElement USERNAME_INPUT = $(By.id("username"));
    public static final SelenideElement PASSWORD_INPUT = $(By.id("password"));
    public static final SelenideElement LOGIN_BUTTON = $(By.id("Login"));

    public LoginPage() {
    }

    public LoginPage openPage(String url) {
        open(url);
        return this;
    }

    public HomePage login(String username, String password) {
        USERNAME_INPUT.sendKeys(username);
        PASSWORD_INPUT.sendKeys(password);
        LOGIN_BUTTON.click();
        waitForPageLoad();
        $x("//tbody").shouldBe(Condition.visible, Duration.ofSeconds(10));
        return new HomePage();
    }
}
