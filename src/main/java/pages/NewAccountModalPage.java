package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Dropdown;
import elements.Input;
import objects.Account;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class NewAccountModalPage extends BasePage {
    private String modalWindowPath = "//*[@class=\"record-layout-container\"]";

    public static final SelenideElement SAVE_BUTTON = $x("//*[@name='SaveEdit']");
    public static final SelenideElement SAVE_AND_NEW_BUTTON = $x("//*[@name='SaveAndNew']");
    public static final SelenideElement CANCEL_BUTTON = $x("//*[@name='CancelEdit']");
    public static final SelenideElement ACCOUNTS_BUTTON = $x("//*[contains(text(),'Accounts')]/ancestor::li");
    public static final SelenideElement ACCOUNT_OPTIONS = $x("//*[@href=\"/lightning/o/Account/home\"]/following-sibling::one-app-nav-bar-item-dropdown//*[@icon-name=\"utility:chevrondown\"]");
    public static final SelenideElement NEW_ACCOUNT_OPTION = $x("//*[@href=\"/001/e?sObjectName=Account&save_new_url=%2F001%2Fe&navigationLocation=LIST_VIEW\"]");

    public NewAccountModalPage() {
    }

    public NewAccountModalPage openPage(String url) {
        open(url);
        return this;
    }

    public NewAccountModalPage openNewAccountModalPage() {
        Actions actions = new Actions(getWebDriver());
        ACCOUNTS_BUTTON.click();
        waitForPageLoad();
        ACCOUNT_OPTIONS.click();
        actions.moveToElement(NEW_ACCOUNT_OPTION);
        actions.click();
        actions.perform();
        $x(modalWindowPath).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    public void createNewAccount(Account account) {
        new Input("Account Name").writeTextToInput(account.getAccountName());
        new Input("Website").writeTextToInput(account.getWebsite());
        new Dropdown("Type").accountSelectOption(account.getType());
        new Input("Description").writeTextToTextarea(account.getDescription());
        new Input("Phone").writeTextToInput(account.getPhone());
        new Button().clickButton(SAVE_BUTTON);
    }
}
