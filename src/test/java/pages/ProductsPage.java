package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;
    By title = By.cssSelector("[data-test=title]");
    By cart = By.cssSelector(".shopping_cart_link");
    String productAddCart = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageOpened() {
        return driver.findElement(title).isDisplayed();
    }

    //@Step("Добавление товара в корзину")
    public ProductsPage addToCart (String product) {
        driver.findElement(By.xpath(String.format(productAddCart, product))).click();
        return this;
    }

    //@Step("Переход в корзину")
    public CartPage clickToCart() {
        driver.findElement(cart).click();
        return new CartPage(driver);
    }
}
