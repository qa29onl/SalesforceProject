package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {

    WebDriver driver;
    String label;
    private static final String INPUT_XPATH = "//*[contains(text(), '%s')]/ancestor::div[contains(@part, 'input-text')]//input";
    private static final String TEXTAREA_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@slot, 'inputField')]//textarea";
    private static final String CONTACT_INPUT_XPATH = "//*[contains(text(),'%s')]/ancestor::lightning-input[contains(@class,'slds-form-element')]//input";
    private static final String CONTACT_DROPDOWN_INPUT_XPATH = "//label[contains(text(),'%s')]/ancestor::lightning-lookup[contains(@class,'slds-form-element')]//input";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void writeTextToInput(String text) {
        driver.findElement(By.xpath(String.format(INPUT_XPATH, label))).sendKeys(text);
    }

    public void writeTextToTextarea(String text) {
        driver.findElement(By.xpath(String.format(TEXTAREA_XPATH, label))).sendKeys(text);
    }

    public void writeTextInContactsField(String text) {
        driver.findElement(By.xpath(String.format(CONTACT_INPUT_XPATH,label))).sendKeys(text);
    }

    public void writeTextInDropdownField(String text) {
        driver.findElement(By.xpath(String.format(CONTACT_DROPDOWN_INPUT_XPATH,label))).sendKeys(text);
    }
}
