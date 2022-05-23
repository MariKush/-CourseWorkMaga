package org.masha.stepDefinitions;


import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class GeneralSteps {

    String homePageUrl = "https://rozetka.com.ua/";

    @Given("I open ROZETKA home page")
    public void openHomePage() {
        open(homePageUrl);
    }
}
