package org.masha.stepDefinitions;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.google.common.collect.Comparators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.masha.pageObjects.SearchResultsPage;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilteringAndSortingSteps {


    SearchResultsPage searchResultsPage = new SearchResultsPage();

    @And("^I set (.*) value in min cost field and press OK$")
    public void setValueInMinCostFieldAndPressEnter(String minCost) {
        searchResultsPage.getMinPriceInput().clear();
        searchResultsPage.getMinPriceInput().setValue(minCost);
        searchResultsPage.getPriceFilterOKButton().click();
    }

    @And("^I set (.*) value in max cost field and press OK$")
    public void setValueInMaxCostFieldAndPressEnter(String minCost) {
        searchResultsPage.getMaxPriceInput().clear();
        searchResultsPage.getMaxPriceInput().setValue(minCost);
        searchResultsPage.getPriceFilterOKButton().click();
    }

    @Then("^I verify that all prices greater than (.*)$")
    public void assetThatAllGoodsPricesGreaterThatValue(int cost) {
        for (Integer price : searchResultsPage.getGoodsPrices()) {
            assertTrue(price >= cost);
        }
    }

    @Then("^I verify that all prices less than (.*)$")
    public void assetThatAllGoodsPricesLessThatValue(int cost) {
        for (Integer price : searchResultsPage.getGoodsPrices()) {
            assertTrue(price <= cost);
        }
    }

    @And("^I choose cheap first sort option$")
    public void chooseCheapFirstSortOption() {
        searchResultsPage.getSelectSortOption().click();
        searchResultsPage.getCheapFirstOption().click();
    }

    @And("^I choose expensive first sort option$")
    public void chooseExpensiveFirstSortOption() {
        searchResultsPage.getSelectSortOption().click();
        searchResultsPage.getExpensiveFirstOption().click();
    }

    @Then("^I verify that all goods are sorted in ascending order of price$")
    public void checkCheapFirstSortOption() {
        assertTrue(Comparators.isInOrder(searchResultsPage.getGoodsPrices(), Comparator.naturalOrder()));
    }

    @Then("^I verify that all goods are sorted in descending order of price$")
    public void checkExpensiveFirstSortOption() {
        assertTrue(Comparators.isInOrder(searchResultsPage.getGoodsPrices(), Comparator.reverseOrder()));
    }

    @And("^I choose 64GB option in memory filter$")
    public void choose64GBMemoryFilter() {
        searchResultsPage.getMemory64GBCheckBox().scrollIntoView("{block: \"center\"}");
        searchResultsPage.getMemory64GBCheckBox().shouldBe(Condition.visible).click();
    }

    @Then("^I verify that all goods descriptions contains 65GB$")
    public void checkThatAllGoodsDescriptionContains65GB() {
        searchResultsPage.getGoodsTitles().get(0).scrollTo();
        for (SelenideElement goodsTitle : searchResultsPage.getGoodsTitles()) {
            assertTrue(goodsTitle.getText().contains("64 GB") ||
                    goodsTitle.getText().contains("64GB"));

        }
    }


}
