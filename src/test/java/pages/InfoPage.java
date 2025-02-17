package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InfoPage {
    WebDriver driver;
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By zipCodeField = By.id("postal-code");
    By continueButton = By.id("continue");

    public InfoPage(WebDriver driver) {
        this.driver = driver;
    }

    //@Step("Ввод данных для доставки")
    public InfoPage writeInfo(String firstName, String lastName, String zipCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(zipCodeField).sendKeys(zipCode);
        return this;
    }

    //@Step("Переход на страницу CompletePage")
    public OverviewPage clickContinue() {
        driver.findElement(continueButton).click();
        return new OverviewPage(driver);
    }
}
