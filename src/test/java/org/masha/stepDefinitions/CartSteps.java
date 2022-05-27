package org.masha.stepDefinitions;


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





/*


    void checkItemInCart() {

        assertEquals(goodTitle, getCartPage().getGoodTitle());
        assertEquals(goodPrice, getCartPage().getGoodPrice());

    }
*/

}
