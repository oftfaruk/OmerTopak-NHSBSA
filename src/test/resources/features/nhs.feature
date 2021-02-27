Feature:NHS Costs Checker

  @wip
  Scenario: As a user  from Wales I should be able to check my NHS cost
    Given I am a person from "Wales"
    When I put my circumstances into the Checker tool
    Then I should get a result of whether I will get help or not


