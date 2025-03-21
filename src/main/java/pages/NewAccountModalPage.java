package pages;

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

public class NewAccountModalPage extends BasePage {
    private String modalWindowPath = "//*[@class=\"record-layout-container\"]";

    @FindBy(xpath = "//*[@name='SaveEdit']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@name='SaveAndNew']")
    public WebElement saveAndNewButton;

    @FindBy(xpath = "//*[@name='CancelEdit']")
    public WebElement cancelButton;

    @FindBy(xpath = "//*[contains(text(),'Accounts')]/ancestor::li")
    public WebElement accountsButton;

    @FindBy(xpath = "//*[@href=\"/lightning/o/Account/home\"]/following-sibling::one-app-nav-bar-item-dropdown//*[@icon-name=\"utility:chevrondown\"]")
    public WebElement accountOptions;

    @FindBy(xpath = "//*[@href=\"/001/e?sObjectName=Account&save_new_url=%2F001%2Fe&navigationLocation=LIST_VIEW\"]")
    public WebElement newAccountOption;

    public NewAccountModalPage(WebDriver driver) {
        super(driver);
    }

    public NewAccountModalPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public NewAccountModalPage openNewAccountModalPage() {
        Actions actions = new Actions(driver);
        accountsButton.click();
        waitForPageLoad(driver);
        accountOptions.click();
        actions.moveToElement(newAccountOption);
        actions.click();
        actions.perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(modalWindowPath)));
        return this;
    }

    public void createNewAccount(Account account) {
        new Input(driver, "Account Name").writeTextToInput(account.getAccountName());
        new Input(driver, "Website").writeTextToInput(account.getWebsite());
        new Dropdown(driver, "Type").accountSelectOption(account.getType());
        new Input(driver, "Description").writeTextToTextarea(account.getDescription());
        new Input(driver, "Phone").writeTextToInput(account.getPhone());
        new Button(driver).clickButton(saveButton);
    }
}
