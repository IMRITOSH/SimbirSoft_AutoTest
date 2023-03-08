package com.simbirsoft.autotest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCheckout {

    WebDriver driver;

    public PageCheckout(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='postalCode']")
    WebElement postalCodeInput;

    @FindBy(xpath = "//input[@data-test='continue']")
    WebElement buttonContinue;

    @FindBy(id = "finish")
    WebElement buttonFinish;

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public void setFirstNameInput(WebElement firstNameInput) {
        this.firstNameInput = firstNameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public void setLastNameInput(WebElement lastNameInput) {
        this.lastNameInput = lastNameInput;
    }

    public WebElement getPostalCodeInput() {
        return postalCodeInput;
    }

    public void setPostalCodeInput(WebElement postalCodeInput) {
        this.postalCodeInput = postalCodeInput;
    }

    public WebElement getButtonContinue() {
        return buttonContinue;
    }

    public void setButtonContinue(WebElement buttonContinue) {
        this.buttonContinue = buttonContinue;
    }

    public WebElement getButtonFinish() {
        return buttonFinish;
    }

    public void setButtonFinish(WebElement buttonFinish) {
        this.buttonFinish = buttonFinish;
    }

    public void inputYourInformation(String firstName, String lastName, String postalCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);

        buttonContinue.click();
    }

    public void clickWebElement(WebElement element) {
        element.click();
    }

}
