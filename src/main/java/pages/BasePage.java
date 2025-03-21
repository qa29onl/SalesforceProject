package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;

    public BasePage() {
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoad(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }
}
