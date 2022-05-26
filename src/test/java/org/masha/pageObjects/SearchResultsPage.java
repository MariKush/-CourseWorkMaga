package org.masha.pageObjects;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {

    private final List<SelenideElement> goodsTitles = $$(By.xpath("//span[@class='goods-tile__title']"));

    private final SelenideElement catalogEmpty = $(By.xpath("//div[@class='catalog-empty']"));

    public List<SelenideElement> getGoodsTitles() {
        return goodsTitles;
    }

    public SelenideElement getCatalogEmpty() {
        return catalogEmpty;
    }



}
