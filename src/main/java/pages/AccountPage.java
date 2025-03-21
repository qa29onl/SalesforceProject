package pages;


import static com.codeborne.selenide.Selenide.$x;

public class AccountPage extends BasePage {

    public static final String DATA_BY_FIELD_NAME_XPATH = "//*[@class='record-body-container']//*[text()='%s']";

    public AccountPage() {
    }

    public String getFieldValueByName(String name) {
        return $x(String.format(DATA_BY_FIELD_NAME_XPATH, name)).getText();
    }
}
