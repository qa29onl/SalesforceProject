package elements;

import static com.codeborne.selenide.Selenide.$x;

public class Input {

    String label;
    private static final String INPUT_XPATH = "//*[contains(text(), '%s')]/ancestor::div[contains(@part, 'input-text')]//input";
    private static final String TEXTAREA_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@slot, 'inputField')]//textarea";
    private static final String CONTACT_INPUT_XPATH = "//*[contains(text(),'%s')]/ancestor::lightning-input[contains(@class,'slds-form-element')]//input";
    private static final String CONTACT_DROPDOWN_INPUT_XPATH = "//label[contains(text(),'%s')]/ancestor::lightning-lookup[contains(@class,'slds-form-element')]//input";

    public Input(String label) {
        this.label = label;
    }

    public void writeTextToInput(String text) {
        $x(String.format(INPUT_XPATH, label)).setValue(text);
    }

    public void writeTextToTextarea(String text) {
        $x(String.format(TEXTAREA_XPATH, label)).setValue(text);
    }

    public void writeTextInContactsField(String text) {
        $x(String.format(CONTACT_INPUT_XPATH, label)).setValue(text);
    }

    public void writeTextInDropdownField(String text) {
        $x(String.format(CONTACT_DROPDOWN_INPUT_XPATH, label)).setValue(text);
    }
}
