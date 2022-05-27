Feature: Verify filtering and sorting functionality in catalog

  Scenario: Verify that all goods prices greater than min cost
    Given I open ROZETKA home page
    And I set iPhone value in Search field and press Enter
    And I set 30000 value in min cost field and press OK
    Then I verify that all prices greater than 30000


  Scenario: Verify that all goods prices less than max cost
    Given I open ROZETKA home page
    And I set iPhone value in Search field and press Enter
    And I set 30000 value in max cost field and press OK
    Then I verify that all prices less than 30000

  Scenario: Verify cheap first sorting option of price
    Given I open ROZETKA home page
    And I set iPhone value in Search field and press Enter
    And I choose cheap first sort option
    Then I verify that all goods are sorted in ascending order of price

  Scenario: Verify expensive first sorting option of price
    Given I open ROZETKA home page
    And I set iPhone value in Search field and press Enter
    And I choose expensive first sort option
    Then I verify that all goods are sorted in descending order of price






