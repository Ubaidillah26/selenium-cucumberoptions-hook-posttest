Feature: Check Out

  Scenario: user add first item
    When user navigate to web page
    And search item
    And add item
    And search item
    And add item
    And user filling billing detail
    And user place order
    Then validate scenario