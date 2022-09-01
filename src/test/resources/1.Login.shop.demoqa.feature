Feature: Login User

  Scenario: User invalid Login
    When user navigate to login page
    And user enter username password
    And user click button login
    Then validate page with scenario
    
  Scenario: User valid Login
    When user navigate to login page
    And user enter username password
    And user click button login
    Then validate page with scenario