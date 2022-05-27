package org.masha.stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.masha.pageObjects.HeaderElement;
import org.masha.pageObjects.SearchResultsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartSteps {

    SearchResultsPage searchResultsPage = new SearchResultsPage();
    HeaderElement headerElement = new HeaderElement();

    @And("^I click add to cart button for the fist good$")
    public void lickAddToCartButtonForTheFirstGood() {
        searchResultsPage.getFirstAddToCartButton().click();
    }

    @Then("^I verify that cart header counter equals (.*)$")
    public void checkCartHeaderCounter(Integer count) {
        assertEquals(headerElement.getCartCounter().getText(),count.toString());
    }
}
