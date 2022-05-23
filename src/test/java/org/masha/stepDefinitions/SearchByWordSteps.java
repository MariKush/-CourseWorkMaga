package org.masha.stepDefinitions;


import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.masha.pageObjects.HeaderElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchByWordSteps {

    HeaderElement headerElement = new HeaderElement();

    @And("^I set (.*) value in Search field and press Enter$")
    public void setValueInSearchFieldAndPressEnter(String searchWord) {
        headerElement.getSearchField().setValue(searchWord).pressEnter();
    }

    @Then("^I verify that URL contain (.*) word$")
    public void assertThenUrlContainSearchWord(String searchWord){
        assertTrue(WebDriverRunner.url().contains(searchWord.toLowerCase()));
    }
}
