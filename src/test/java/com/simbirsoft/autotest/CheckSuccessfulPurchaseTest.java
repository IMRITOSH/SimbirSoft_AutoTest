package com.simbirsoft.autotest;

import com.simbirsoft.autotest.pages.PageCheckout;
import com.simbirsoft.autotest.pages.PageLogin;
import com.simbirsoft.autotest.pages.PageProducts;
import com.simbirsoft.autotest.pages.PageYourCart;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class CheckSuccessfulPurchaseTest {
    public static WebDriver driver;
    public static PageLogin pageLogin;
    public static PageProducts pageProducts;
    public static PageYourCart pageYourCart;
    public static PageCheckout pageCheckout;


    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\IMRITO\\projects\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        pageLogin = new PageLogin(driver);
        pageProducts = new PageProducts(driver);
        pageYourCart = new PageYourCart(driver);
        pageCheckout = new PageCheckout(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        pageLogin.login("standard_user", "secret_sauce");
    }

    @Test
    public void testMain() {
        try {
            pageProducts.clickWebElement(pageProducts.getAddToCartButton());

            pageProducts.clickWebElement(pageProducts.getCartButton());

            Thread.sleep(1000);

            pageYourCart.clickWebElement(pageYourCart.getCheckoutButton());

            Thread.sleep(1000);

            pageCheckout.inputYourInformation("test", "test", "test");

            Thread.sleep(1000);

            pageCheckout.clickWebElement(pageCheckout.getButtonFinish());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String currentUrl = driver.getCurrentUrl();
        String message = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']")).getText();

        Assertions.assertEquals("Thank you for your order!", message);
        Assertions.assertEquals("https://www.saucedemo.com/checkout-complete.html", currentUrl);

    }

    @AfterAll
    public static void after() {
        driver.quit();
    }
}