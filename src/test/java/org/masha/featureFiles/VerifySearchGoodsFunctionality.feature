Feature: Verify search goods functionality

  Scenario: Verify that URL contains search word
    Given I open ROZETKA home page
    And I set IPhone value in Search field and press Enter
    Then I verify that URL contain IPhone word
