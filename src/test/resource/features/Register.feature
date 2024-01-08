 Feature: Registeration functionality

Scenario: User creates an account only with mandatory feilds
Given User navigate to register account page
When User enters the below feilds
| firstName   | Surekha|
|lastName     | Naik |
|telephone    | 1234567890|
|password     | 12345 | 
|confirmpassword     | 12345 |
And User selects privacy policy
And User clicks on continue button
Then User account should get created successfully
 
Scenario: User creates a duplicate account
Given User navigate to register account page
When User enters the below feilds with duplicate email
| firstName   | Surekha|
|lastName     | Naik |
|email        | amotooricap1@gmail.com|
|telephone    | 1234567890|
|password     | 12345 | 
|confirmpassword     | 12345 |
And User selects privacy policy
And User clicks on continue button
Then User should get a proper warning message about duplicate email

Scenario: User creates an account without entering any account details
Given User navigate to register account page
When User dont enter any account details
And User clicks on continue button
Then User should get proper warning message for every mandatory feild

