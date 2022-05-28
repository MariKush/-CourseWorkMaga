Feature: Verify cart functionality

  Scenario: Verify cart header counter for one good in the cart
    Given I open ROZETKA home page
    And I set iPhone value in Search field and press Enter
    And I click add to cart button for the fist good
    Then I verify that cart header counter equals 1

  Scenario: Verify cart title and price in the cart
    Given I open ROZETKA home page
    And I set iPhone value in Search field and press Enter
    And I store first goods title in catalog
    And I store first goods price in catalog
    And I click add to cart button for the fist good
    And I open cart using header
    Then I verify that goods title in the cart equals to title in the catalog
    Then I verify that goods price in the cart equals to price in the catalog

  Scenario: Verify sum in cart after changing goods count
    Given I open ROZETKA home page
    And I set iPhone value in Search field and press Enter
    And I store first goods price in catalog
    And I click add to cart button for the fist good
    And I open cart using header
    Then I verify that goods price in the cart equals to price in the catalog
    And I increment goods count in the cart
    And I wait for goods changing count to 2
    Then I verify sum goods price in the cart with two the same goods
    And I decrement goods count in the cart
    And I wait for goods changing count to 1
    Then I verify that goods price in the cart equals to price in the catalog

