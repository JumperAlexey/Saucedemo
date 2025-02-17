package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage {

    WebDriver driver;
    By message = By.cssSelector(".complete-header");

    public CompletePage(WebDriver driver) {
        this.driver = driver;
    }

    //@Step("Нажали на кнопку финиш")
    public String getMessage() {
        return driver.findElement(message).getText();
    }
}
