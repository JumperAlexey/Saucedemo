import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void checkPositiveLogin() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        boolean titleIsDisplayed = driver.findElement(By.cssSelector("[data-test=title]")).isDisplayed();
        Assert.assertTrue(titleIsDisplayed);
    }

    @Test
    public void checkPositiveWithEmptyUsername() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required" );
    }

    @Test
    public void checkPositiveWithEmptyPassword() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("login-button")).click();
        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Password is required" );
    }

    @AfterMethod (alwaysRun = true)
    public void closs(){
        driver.quit();
    }

}
