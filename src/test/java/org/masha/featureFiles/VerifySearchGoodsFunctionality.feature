Feature: Verify search goods functionality

  Scenario: Verify that URL contains search word
    Given I open ROZETKA home page
    And I set IPhone value in Search field and press Enter
    Then I verify that URL contain IPhone word

  Scenario: Verify that search results contains search word
    Given I open ROZETKA home page
    And I set iPhone value in Search field and press Enter
    Then I verify that search result contains iPhone word

  Scenario: Verify catalog empty message is displayed
    Given I open ROZETKA home page
    And I set wrongSearchWord value in Search field and press Enter
    Then I see catalog empty message


