Feature: Verify the "I don't remember my password" link

  Scenario: Verify the "I don't remember my password" link
    Given Main page is loaded
    When Support Center panel is loaded
    And Navigation Bar is loaded
    When Go to the login page
    When Click on the I don't remember my password in link
    Then User should be redirected to the help page
