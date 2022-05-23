package org.masha.stepDefinitions;


import io.cucumber.java.en.Given;
import org.masha.pageObjects.HeaderElement;

public class SearchByWordSteps {

    HeaderElement headerElement = new HeaderElement();

    @Given("^I set (.*) value in Search field and press Enter$")
    public void setValueInSearchFieldAndPressEnter(String searchWord) {
        headerElement.getSearchField().setValue(searchWord).pressEnter();
    }
}
