package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Dropdown;
import elements.Input;
import objects.Contact;

import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class NewContactModalPage extends BasePage {

    public static final String SAVE_BUTTON_XPATH_ON_NEW_CONTACT_MODAL = "//button[@name ='SaveEdit']";
    public static final SelenideElement CONTACTS_BUTTON = $x("//*[contains(text(),'Contacts')]/ancestor::li");
    public static final SelenideElement CONTACTS_OPTIONS = $x("//*[@href=\"/lightning/o/Contact/home\"]/following-sibling::one-app-nav-bar-item-dropdown//*[@icon-name=\"utility:chevrondown\"]");
    public static final SelenideElement NEW_CONTACT_OPTION = $x("//*[@href=\"/003/e?sObjectName=Contact&save_new_url=%2F003%2Fe&navigationLocation=LIST_VIEW\"]");

    private String modalWindowPath = "//*[@class=\"record-layout-container\"]";

    public NewContactModalPage() {
    }

    public NewContactModalPage openPage(String url) {
        open(url);
        return this;
    }

    public NewContactModalPage openNewContactModalPage() {
        Actions actions = new Actions(getWebDriver());
        waitForPageLoading();
        CONTACTS_BUTTON.click();
        waitForPageLoading();
        CONTACTS_OPTIONS.click();
        actions.moveToElement(NEW_CONTACT_OPTION);
        actions.click();
        actions.perform();
        $x(modalWindowPath).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    public void waitForPageLoading() {
        waitForPageLoad();
    }

    public void createNewContact(Contact contact) {
        new Input("First Name").writeTextInContactsField(contact.getFirstName());
        new Input("Last Name").writeTextInContactsField(contact.getLastName());
        new Dropdown("Account Name").contactSelectAccount(contact.getAccountName());
        new Input("Phone").writeTextInContactsField(contact.getPhone());
        new Input("Email").writeTextInContactsField(contact.getEmail());
        new Button().clickButton($x(SAVE_BUTTON_XPATH_ON_NEW_CONTACT_MODAL));
        waitForPageLoading();
    }
}
