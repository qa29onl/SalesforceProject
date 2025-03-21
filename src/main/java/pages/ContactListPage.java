package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactListPage extends BasePage{

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    public ContactListPage openPage(String url) {
        driver.get(url);
        return this;
    }

    /**
     * this method gets contact name.
     * @param firstName
     * @param lastName
     * @return
     */
    public String getExistContactName(String firstName, String lastName){
        return driver.findElement(By.xpath(String.format(AccountListPage.ACCOUNT_NAME_FIELD_XPATH, firstName + " " + lastName))).getText();
    }

    /**
     * this method gets phone number.
     * @param phoneNumber
     * @return phone number
     */
    public String getExistPhoneNumber(String phoneNumber){
        return driver.findElement(By.xpath(String.format(AccountListPage.PHONE_FIELDS_XPATH, phoneNumber))).getText();
    }
}
