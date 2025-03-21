package pages;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class AccountListPage extends BasePage {
    public static final String TABLE_XPATH = "//table";
    public static final String ACCOUNT_NAME_FIELD_XPATH = TABLE_XPATH + "//a[contains(@title, '%s')]";
    public static final String PHONE_BY_ACCOUNT_NAME_XPATH = ACCOUNT_NAME_FIELD_XPATH + "/ancestor::tbody//span[contains(@class, 'forceOutputPhone')]";
    public static final String ACCOUNT_OWNER_BY_ACCOUNT_NAME_XPATH = ACCOUNT_NAME_FIELD_XPATH + "/ancestor::tbody//span[contains(@class, 'uiOutputText')]";
    public static final String PHONE_FIELDS_XPATH = TABLE_XPATH + "//*[contains(@class,'uiOutputPhone') and contains(text(),'%s')]";

    public AccountListPage() {
    }

    public AccountListPage openPage(String url) {
        open(url);
        return this;
    }

    public String getExistAccountName(String accountName) {
        return $x(String.format(ACCOUNT_NAME_FIELD_XPATH, accountName)).getText();
    }

    public String getExistPhoneNumberByAccountName(String accountName) {
        return $x(String.format(PHONE_BY_ACCOUNT_NAME_XPATH, accountName)).getText();
    }

    public String getExistAccountOwnerByAccountName(String accountName) {
        return $x(String.format(ACCOUNT_OWNER_BY_ACCOUNT_NAME_XPATH, accountName)).getText();
    }

    public AccountPage clickOnAccountName(String accountName) {
        $x(String.format(ACCOUNT_NAME_FIELD_XPATH, accountName)).click();
        return new AccountPage();
    }
}
