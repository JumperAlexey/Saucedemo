package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {

    WebDriver driver;
    By finishButton = By.id("finish");

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public CompletePage clickFinish(){
        driver.findElement(finishButton).click();
        return new CompletePage(driver);
    }
}
