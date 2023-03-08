package com.simbirsoft.autotest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin {
    WebDriver driver;

    public PageLogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "user-name")
    WebElement userNameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement buttonLogin;

    public WebElement getUserNameInput() {
        return userNameInput;
    }

    public void setUserNameInput(WebElement userNameInput) {
        this.userNameInput = userNameInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public void setPasswordInput(WebElement passwordInput) {
        this.passwordInput = passwordInput;
    }

    public WebElement getButtonLogin() {
        return buttonLogin;
    }

    public void setButtonLogin(WebElement buttonLogin) {
        this.buttonLogin = buttonLogin;
    }

    public void login(String userName, String password) {
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        buttonLogin.click();
    }

    public void clickWebElement(WebElement element) {
        element.click();
    }

}
