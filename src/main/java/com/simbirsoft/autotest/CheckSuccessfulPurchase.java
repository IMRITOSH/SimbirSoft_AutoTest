package com.simbirsoft.autotest;

import com.simbirsoft.autotest.pages.PageCheckout;
import com.simbirsoft.autotest.pages.PageLogin;
import com.simbirsoft.autotest.pages.PageProducts;
import com.simbirsoft.autotest.pages.PageYourCart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckSuccessfulPurchase {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\IMRITO\\projects\\drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        try {
            driver.get("https://www.saucedemo.com/");

            Thread.sleep(3000);

            PageLogin pageLogin = new PageLogin(driver);

            pageLogin.login("standard_user", "secret_sauce");

            Thread.sleep(3000);

            PageProducts pageProducts = new PageProducts(driver);

            pageProducts.clickWebElement(pageProducts.getAddToCartButton());

            pageProducts.clickWebElement(pageProducts.getCartButton());

            Thread.sleep(1000);

            PageYourCart pageYourCart = new PageYourCart(driver);

            pageYourCart.clickWebElement(pageYourCart.getCheckoutButton());

            Thread.sleep(1000);

            PageCheckout pageCheckout = new PageCheckout(driver);

            pageCheckout.inputYourInformation("test", "test", "test");

            Thread.sleep(1000);

            pageCheckout.clickWebElement(pageCheckout.getButtonFinish());

            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }


    }
}
