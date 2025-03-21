package elements;

import com.codeborne.selenide.SelenideElement;

public class Button {

    public Button() {
    }

    public void clickButton(SelenideElement selenideElement) {
        selenideElement.click();
    }
}
