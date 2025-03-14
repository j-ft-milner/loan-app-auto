Feature: Login

  Scenario: valid user login
    Given a user with valid login credentials on the login page
    When the user logs in
    Then the user is logged in


  Scenario: invalid user login
    Given a user with invalid credential on the login page
    When the invalid user logs in
    Then the user is shown an error message