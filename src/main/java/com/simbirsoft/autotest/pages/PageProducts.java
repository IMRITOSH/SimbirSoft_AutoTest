package com.simbirsoft.autotest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageProducts {

    WebDriver driver;

    public PageProducts(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a")
    WebElement cartButton;

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public void setAddToCartButton(WebElement addToCartButton) {
        this.addToCartButton = addToCartButton;
    }

    public WebElement getCartButton() {
        return cartButton;
    }

    public void setCartButton(WebElement cartButton) {
        this.cartButton = cartButton;
    }

    public void clickWebElement(WebElement element) {
        element.click();
    }
}
