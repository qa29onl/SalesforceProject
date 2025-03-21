package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Dropdown {
    String label;

    private static final String ACCOUNT_DROPDOWN_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@slot, 'inputField')]//button";
    private static final String ACCOUNT_DROPDOWN_OPTION_XPATH = "//*[contains(@title, '%s')]";
    private static final String CONTACT_DROPDOWN_XPATH = "//*[contains(text(),'%s')]/ancestor::div[contains(@class,'slds-form-element')]//input";
    private static final String CONTACT_SELECT_OPTION_XPATH = "//*[contains(@class,'slds-media__body')]/descendant::span[contains(@title,'%s')]";
    private static final String ACCOUNT_SELECT_ACCOUNT_XPATH =
            "//label[contains(text(),'Account Name')]/ancestor::lightning-grouped-combobox[contains(@class,'slds-form-element')]//*[@title='%s']";

    public Dropdown(String label) {
        this.label = label;
    }

    public void accountSelectOption(String option) {
        $x(String.format(ACCOUNT_DROPDOWN_XPATH, label)).click();
        $x(String.format(ACCOUNT_DROPDOWN_OPTION_XPATH, option)).click();
    }

    public void contactSelectOption(String option) {
        $x(String.format(CONTACT_DROPDOWN_XPATH,label)).click();
        $x((String.format(CONTACT_SELECT_OPTION_XPATH,option))).click();
    }

    public void contactSelectAccount(String option) {
        new Input("Account Name").writeTextInDropdownField(option);
        $x(String.format(ACCOUNT_SELECT_ACCOUNT_XPATH,option)).click();
    }
}
