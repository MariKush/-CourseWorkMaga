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
    Then  I verify sum goods price in the cart with 1 the same goods

  Scenario: Verify sum in cart after changing goods count
    Given I open ROZETKA home page
    And I set iPhone value in Search field and press Enter
    And I store first goods price in catalog
    And I click add to cart button for the fist good
    And I open cart using header
    Then I verify sum goods price in the cart with 1 the same goods
    And I increment goods count in the cart
    Then I verify sum goods price in the cart with 2 the same goods
    And I decrement goods count in the cart
    Then I verify sum goods price in the cart with 1 the same goods

  Scenario: Verify sum price of different goods in cart
    Given I open ROZETKA home page
    And I set iPhone value in Search field and press Enter
    And I store first goods price in catalog
    And I store second goods price in catalog
    And I click add to cart button for the fist good
    And I click add to cart button for the second good
    And I open cart using header
    Then I verify sum goods price in the cart with two different goods

  Scenario: Verify delete all goods from cart
    Given I open ROZETKA home page
    And I set iPhone value in Search field and press Enter
    And I click add to cart button for the fist good
    And I open cart using header
    And I open goods actions tab and choose delete button
    Then I verify that empty cart icon present