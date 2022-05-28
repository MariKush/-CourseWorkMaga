package org.masha.pageObjects;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {


    private final SelenideElement goodTitle = $(By.xpath("//a[@class='cart-product__title']"));
    private final SelenideElement goodPrice = $(By.xpath("//p[@class='cart-product__price']"));
    private final SelenideElement cartCounter = $(By.xpath("//input[contains(@class, 'cart-counter')]"));
    private final SelenideElement sumPrice = $(By.xpath("//div[@class='cart-receipt__sum-price']/span[1]"));
    private final SelenideElement addOneMoreGood = $(By.xpath("//button[contains(@class, 'cart-counter__button')][2]"));
    private final SelenideElement subtractOneGood = $(By.xpath("//button[contains(@class, 'cart-counter__button')][1]"));
    private final SelenideElement goodActionButton = $(By.xpath("//button[@id='cartProductActions0']"));
    private final SelenideElement deleteGoodButton = $(By.xpath("//button[contains(@class, 'actions')]"));
    private final SelenideElement emptyChart = $(By.xpath("//div[contains(@class, 'cart-dummy')]"));
    private final SelenideElement goodsCount = $(By.xpath("//input[@data-testid='cart-counter-input']"));

    public SelenideElement getGoodTitle() {
        return goodTitle;
    }

    public SelenideElement getGoodPrice() {
        return goodPrice;
    }

    public SelenideElement getCartCounter() {
        return cartCounter;
    }

    public SelenideElement getSumPrice() {
        return sumPrice;
    }

    public SelenideElement getAddOneMoreGood() {
        return addOneMoreGood;
    }

    public SelenideElement getSubtractOneGood() {
        return subtractOneGood;
    }

    public SelenideElement getGoodActionButton() {
        return goodActionButton;
    }

    public SelenideElement getDeleteGoodButton() {
        return deleteGoodButton;
    }

    public SelenideElement getEmptyChart() {
        return emptyChart;
    }

    public SelenideElement getGoodsCount() {
        return goodsCount;
    }

}
