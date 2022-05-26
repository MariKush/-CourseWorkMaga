Feature: Verify filtering and sorting functionality in catalog

  Scenario: Verify that all goods prices greater than min cost
    Given I open ROZETKA home page
    And I set iPhone value in Search field and press Enter
    And I set 30000 value in min cost field and press OK
    Then I verify that all prices greater than 30000




