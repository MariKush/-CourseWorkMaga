package org.masha.stepDefinitions;


import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.masha.pageObjects.CartPage;
import org.masha.pageObjects.HeaderElement;
import org.masha.pageObjects.SearchResultsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.masha.utils.Utility.toPriceFormat;

public class CartSteps {


    String firstGoodsTitleInCatalog;
    Integer firstGoodsPriceInCatalog;
    Integer secondGoodsPriceInCatalog;

    SearchResultsPage searchResultsPage = new SearchResultsPage();
    HeaderElement headerElement = new HeaderElement();
    CartPage cartPage = new CartPage();

    @And("^I click add to cart button for the fist good$")
    public void lickAddToCartButtonForTheFirstGood() {
        searchResultsPage.getFirstAddToCartButton().click();
    }

    @And("^I click add to cart button for the second good$")
    public void lickAddToCartButtonForTheSecondGood() {
        searchResultsPage.getSecondAddToCartButton().click();
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

    @And("^I increment goods count in the cart$")
    public void incrementGoodsCountInTheCart() {
        cartPage.getAddOneMoreGood().click();
    }

    @Then("^I verify sum goods price in the cart with (.*) the same goods$")
    public void assertSumGoodsPriceForSomeCountOfTheSameGoodsInTheCart(int count) {
        String expectedPriceInFormat = toPriceFormat(firstGoodsPriceInCatalog * count);
        cartPage.getGoodPrice().shouldHave(Condition.text(expectedPriceInFormat));
    }

    @And("^I decrement goods count in the cart$")
    public void decrementGoodsCountInTheCart() {
        cartPage.getSubtractOneGood().click();
    }

    @And("^I store second goods price in catalog$")
    public void storeSecondGoodsPriceInCatalog() {
        secondGoodsPriceInCatalog = searchResultsPage.getGoodsPrices().get(1);
    }

    @Then("^I verify sum goods price in the cart with two different goods$")
    public void assertSumGoodsPriceForTwoDifferentInTheCart() {
        cartPage.getSumPrice().shouldHave(
                Condition.text(firstGoodsPriceInCatalog + secondGoodsPriceInCatalog + ""));
    }

    @And("^I open goods actions tab and choose delete button$")
    public void openGoodsActionsTabAndChooseDeleteButton() {
        cartPage.getGoodActionButton().click();
        cartPage.getDeleteGoodButton().click();
    }

    @Then("^I verify that empty cart icon present$")
    public void verifyThatEmptyCartIconPresent() {
        cartPage.getEmptyChart().shouldBe(Condition.visible);
    }



}
