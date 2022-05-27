package org.masha.pageObjects;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class HeaderElement {

    private final SelenideElement searchField = $(byName("search"));
    private final SelenideElement cartCounter = $(By.xpath("//span[contains(@class, 'counter')]"));
    private final SelenideElement cartButton = $(By.xpath("//button[contains(@class, 'header__button--active')]"));

    public SelenideElement getSearchField() {
        return searchField;
    }

    public SelenideElement getCartCounter() {
        return cartCounter;
    }

    public SelenideElement getCartButton() {
        return cartButton;
    }
}
