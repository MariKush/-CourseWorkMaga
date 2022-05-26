package org.masha.pageObjects;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.util.stream.Collectors.toList;

public class SearchResultsPage {

    private final List<SelenideElement> goodsTitles = $$(By.xpath("//span[@class='goods-tile__title']"));
    private final SelenideElement catalogEmpty = $(By.xpath("//div[@class='catalog-empty']"));
    private final SelenideElement minPriceInput = $(By.xpath("//input[@formcontrolname='min']"));
    private final SelenideElement priceFilterOKButton  = $(By.xpath("//button[contains(@class, ' slider-filter')]"));
    private final List<SelenideElement> goodsPrices =
            $$(By.xpath("//div[@class='goods-tile ng-star-inserted']//span[@class='goods-tile__price-value']"));


    public List<SelenideElement> getGoodsTitles() {
        return goodsTitles;
    }

    public SelenideElement getCatalogEmpty() {
        return catalogEmpty;
    }

    public SelenideElement getMinPriceInput() {
        return minPriceInput;
    }

    public SelenideElement getPriceFilterOKButton() {
        return priceFilterOKButton;
    }

    public List<Integer> getGoodsPrices() {
        goodsPrices.get(0).shouldBe(visible);
        return goodsPrices.stream()
                .map(SelenideElement::getText)
                .map(text -> text.replaceAll("\\s+", ""))
                .map(Integer::parseInt)
                .collect(toList());
    }






}
