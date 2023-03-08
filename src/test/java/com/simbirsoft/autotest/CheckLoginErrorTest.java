package com.simbirsoft.autotest;

import com.simbirsoft.autotest.pages.PageLogin;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

class CheckLoginErrorTest {
    public static WebDriver driver;
    public static PageLogin pageLogin;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\IMRITO\\projects\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        pageLogin = new PageLogin(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    void main() {
        pageLogin.login("test", "test");
        String message = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();

        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", message);
    }

    @AfterAll
    public static void tear() {
        driver.quit();
    }
}