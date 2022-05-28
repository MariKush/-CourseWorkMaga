package org.masha.stepDefinitions;


import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.masha.pageObjects.CartPage;
import org.masha.pageObjects.HeaderElement;
import org.masha.pageObjects.SearchResultsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartSteps {


    String firstGoodsTitleInCatalog;
    Integer firstGoodsPriceInCatalog;

    SearchResultsPage searchResultsPage = new SearchResultsPage();
    HeaderElement headerElement = new HeaderElement();
    CartPage cartPage = new CartPage();

    @And("^I click add to cart button for the fist good$")
    public void lickAddToCartButtonForTheFirstGood() {
        searchResultsPage.getFirstAddToCartButton().click();
    }

    @Then("^I verify that cart header counter equals (.*)$")
    public void checkCartHeaderCounter(Integer count) {
        assertEquals(headerElement.getCartCounter().getText(), count.toString());
    }

    @And("^I store first goods title in catalog$")
    public void storeFirstGoodsTitleInCatalog() {
        firstGoodsTitleInCatalog = searchResultsPage.getGoodsTitles().get(0).getText();
    }

    @And("^I store first goods price in catalog$")
    public void storeFirstGoodsPriceInCatalog() {
        firstGoodsPriceInCatalog = searchResultsPage.getGoodsPrices().get(0);
    }

    @And("^I open cart using header$")
    public void openCartUsingHeader() {
        headerElement.getCartButton().click();
    }

    @Then("^I verify that goods title in the cart equals to title in the catalog$")
    public void assertGoodsTitle() {
        assertEquals(cartPage.getGoodTitle().text(), firstGoodsTitleInCatalog);
    }

    @Then("^I verify that goods price in the cart equals to price in the catalog$")
    public void assertGoodsPrice() {
        assertEquals(Integer.parseInt(cartPage.getGoodPrice().getText().replaceAll("[^0-9.]", "")),
                firstGoodsPriceInCatalog);
    }

    @And("^I increment goods count in the cart$")
    public void incrementGoodsCountInTheCart() {
        cartPage.getAddOneMoreGood().click();
    }

    @Then("^I verify sum goods price in the cart with two the same goods$")
    public void assertSumGoodsPriceForTwoTheSameGoodsInTheCart() {
        assertEquals(Integer.parseInt(cartPage.getGoodPrice().getText().replaceAll("[^0-9.]", "")),
                firstGoodsPriceInCatalog * 2);
    }

    @And("^I decrement goods count in the cart$")
    public void decrementGoodsCountInTheCart() {
        cartPage.getSubtractOneGood().click();
    }

    @And("^I wait for goods changing count to (.*)$")
    public void waitForGoodsChangingCount(String count) {
       cartPage.getGoodsCount().shouldHave(Condition.value(count));
    }


}
