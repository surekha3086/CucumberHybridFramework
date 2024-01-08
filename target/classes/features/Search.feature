@all
Feature: Search functionality

Scenario: User searches for a valid product
Given User opens the application 
When user enters the valid product "HP" on the search feild
And User clicks on search button
Then Searched valid product should get displayed in the search results

Scenario: User searches for a invalid product
Given User opens the application 
When user enters the invalid product "Honda" on the search feild
And User clicks on search button
Then User should get a message about no product matching

Scenario: User searches without entering the product
Given User opens the application 
When user do not enter any product name into the feild
And User clicks on search button
Then User should get a message about no product matching
