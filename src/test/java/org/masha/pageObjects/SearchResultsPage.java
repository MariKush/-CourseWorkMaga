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
    private final SelenideElement maxPriceInput = $(By.xpath("//input[@formcontrolname='max']"));
    private final SelenideElement priceFilterOKButton  = $(By.xpath("//button[contains(@class, ' slider-filter')]"));
    private final List<SelenideElement> goodsPrices =
            $$(By.xpath("//div[@class='goods-tile ng-star-inserted']//span[@class='goods-tile__price-value']"));
    private final SelenideElement selectSortOption  = $(By.xpath("//select[contains(@class, 'select-css')]"));
    private final SelenideElement cheapFirstOption  = $(By.xpath("//option[contains(@value, 'cheap')]"));
    private final SelenideElement expensiveFirstOption  = $(By.xpath("//option[contains(@value, 'expensive')]"));
    private final SelenideElement memory64GBCheckBox  = $(By.xpath("//li/a[(@data-id='64 ГБ')]"));


    public List<SelenideElement> getGoodsTitles() {
        return goodsTitles;
    }

    public SelenideElement getCatalogEmpty() {
        return catalogEmpty;
    }

    public SelenideElement getMinPriceInput() {
        return minPriceInput;
    }

    public SelenideElement getMaxPriceInput() {
        return maxPriceInput;
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


    public SelenideElement getSelectSortOption() {
        return selectSortOption;
    }

    public SelenideElement getCheapFirstOption() {
        return cheapFirstOption;
    }

    public SelenideElement getExpensiveFirstOption() {
        return expensiveFirstOption;
    }

    public SelenideElement getMemory64GBCheckBox() {
        return memory64GBCheckBox;
    }




}
