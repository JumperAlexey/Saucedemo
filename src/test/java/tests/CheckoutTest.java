package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class CheckoutTest extends BaseTest {

    @Test
    @Description("Выполнение е2е тестп по покупке товара")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Saucedemo-1-1")
    public void checkoutTest() throws InterruptedException {
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Fleece Jacket")
                .addToCart("Sauce Labs Onesie")
                .clickToCart()
                .clickCheckout()
                .writeInfo("alex", "jum", "456456")
                .clickContinue()
                .clickFinish();
        Assert.assertEquals(completePage.getMessage(), "Thank you for your order!");


//        loginPage.open();
//        loginPage.login("standard_user", "secret_sauce");
//        productsPage.addToCart("Sauce Labs Fleece Jacket");
//        productsPage.addToCart("Sauce Labs Onesie");
//        productsPage.clickToCart();
//        cartPage.clickCheckout();
//        infoPage.writeInfo("alex", "jum", "456456");
//        infoPage.clickContinue();
//        overviewPage.clickFinish();
//        Assert.assertEquals(completePage.getMessage(), "Thank you for your order!");


        //sleep(2000);

    }
}
