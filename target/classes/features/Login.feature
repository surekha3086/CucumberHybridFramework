@testcases
Feature: Login functionality

Scenario Outline: Login with valid credentials 
Given User navigate to login feature
When User enter the valid email address <userName> into the feild
And User entered the valid password <password> into the feild 
And User click on login button
Then User should logged in successfully
Examples:
|userName                |password|
|amotooricap1@gmail.com  |12345   |
|amotooricap2@gmail.com  |12345   |
|amotooricap3@gmail.com  |12345   |

Scenario: Login with invalid credentials 
Given User navigate to login feature
When User enter the invalid email address into the feild
And User entered the invalid password "1234568" into the feild 
And User click on login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password 
Given User navigate to login feature
When User enter the valid email address "amotooricap1@gmail.com" into the feild
And User entered the invalid password "1234568" into the feild 
And User click on login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password 
Given User navigate to login feature
When User enter the invalid email address into the feild
And User entered the invalid password "12345" into the feild 
And User click on login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login without entering any credentials 
Given User navigate to login feature
When User dont enter any credentials into the feilds 
And User click on login button
Then User should get a proper warning message about credentials mismatch

