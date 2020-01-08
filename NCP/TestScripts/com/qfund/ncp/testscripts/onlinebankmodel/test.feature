#Author: shanmukha.p@qfund.net
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Transactions

  @RegressionSuite
  Scenario: Void Loan
    Given Void Loan transaction
    When Initiate a loan
    And Originate a loan
    And Make Loan void
    Then validate transaction history in LMS Portal

  @RegressionSuite
  Scenario: Rescind Loan
       Given Void Loan transaction
    When Initiate a loan
    And Originate a loan
    And Make Loan Rescind
    Then validate transaction history in LMS Portal
  #@tag1
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
