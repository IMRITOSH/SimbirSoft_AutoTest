package com.simbirsoft.autotest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageYourCart {
    WebDriver driver;

    public PageYourCart(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "#checkout")
    WebElement checkoutButton;

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public void setCheckoutButton(WebElement checkoutButton) {
        this.checkoutButton = checkoutButton;
    }

    public void clickWebElement(WebElement element) {
        element.click();
    }
}
