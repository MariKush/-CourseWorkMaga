Feature: Verify cart functionality

  Scenario: Verify cart header counter for one good in the cart
    Given I open ROZETKA home page
    And I set iPhone value in Search field and press Enter
    And I click add to cart button for the fist good
    Then I verify that cart header counter equals 1