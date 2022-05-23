package org.masha.pageObjects;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class HeaderElement {

    private final SelenideElement searchField = $(byName("search"));

    public SelenideElement getSearchField() {
        return searchField;
    }
}
