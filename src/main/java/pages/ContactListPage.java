package pages;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ContactListPage extends BasePage{

    public ContactListPage() {
    }

    public ContactListPage openPage(String url) {
        open(url);
        return this;
    }

    public String getExistContactName(String firstName, String lastName){
        return $x(String.format(AccountListPage.ACCOUNT_NAME_FIELD_XPATH, firstName + " " + lastName)).getText();
    }

    public String getExistPhoneNumber(String phoneNumber){
        return $x(String.format(AccountListPage.PHONE_FIELDS_XPATH, phoneNumber)).getText();
    }
}
