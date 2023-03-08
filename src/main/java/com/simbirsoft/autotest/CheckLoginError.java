package com.simbirsoft.autotest;

import com.simbirsoft.autotest.pages.PageLogin;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CheckLoginError {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\IMRITO\\projects\\drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        try {
            driver.get("https://www.saucedemo.com/");
            Thread.sleep(5000);

            PageLogin pageLogin = new PageLogin(driver);

            pageLogin.login("test", "test");

            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
