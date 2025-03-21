package pages;

import elements.Button;
import elements.Dropdown;
import elements.Input;
import objects.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class NewContactModalPage extends BasePage {

    public static final String SAVE_BUTTON_XPATH_ON_NEW_CONTACT_MODAL = "//button[@name ='SaveEdit']";
    private String modalWindowPath = "//*[@class=\"record-layout-container\"]";

    @FindBy(xpath = "//*[contains(text(),'Contacts')]/ancestor::li")
    public WebElement contactsButton;

    @FindBy(xpath = "//*[@href=\"/lightning/o/Contact/home\"]/following-sibling::one-app-nav-bar-item-dropdown//*[@icon-name=\"utility:chevrondown\"]")
    public WebElement contactOptions;

    @FindBy(xpath = "//*[@href=\"/003/e?sObjectName=Contact&save_new_url=%2F003%2Fe&navigationLocation=LIST_VIEW\"]")
    public WebElement newContactOption;

    public NewContactModalPage(WebDriver driver) {
        super(driver);
    }

    public NewContactModalPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public NewContactModalPage openNewContactModalPage() {
        Actions actions = new Actions(driver);
        waitForPageLoading(driver);
        contactsButton.click();
        waitForPageLoading(driver);
        contactOptions.click();
        actions.moveToElement(newContactOption);
        actions.click();
        actions.perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(modalWindowPath)));
        return this;
    }

    public void waitForPageLoading(WebDriver driver) {
        waitForPageLoad(driver);
    }

    /**
     * This method creates new Contact.We use "Thread.sleep" because the browser close window appears
     * and interrupts the test execution
     * @param contact
     */
    public void createNewContact(Contact contact) {
        new Input(driver, "First Name").writeTextInContactsField(contact.getFirstName());
        new Input(driver, "Last Name").writeTextInContactsField(contact.getLastName());
        new Dropdown(driver, "Account Name").contactSelectAccount(contact.getAccountName());
        new Input(driver, "Phone").writeTextInContactsField(contact.getPhone());
        new Input(driver, "Email").writeTextInContactsField(contact.getEmail());
        new Button(driver).clickButton(driver.findElement(By.xpath(SAVE_BUTTON_XPATH_ON_NEW_CONTACT_MODAL)));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitForPageLoading(driver);
    }
}
