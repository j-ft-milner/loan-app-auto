Feature: LoanApplication

  Scenario: Valid loan application
    Given a logged in user on the application page
    When the user submits a valid application
    Then the application is submitted

  @firefox @edge
  Scenario Outline: Validate incorrect loan application inputs
    Given a user is on the loan application form
    When the user submits the form with "<FirstName>", "<LastName>", "<Age>", "<Phone>", "<HouseNumber>", "<City>", "<Address>", "<Postcode>", "<Email>", "<LoanAmount>"
    Then an error message "<ExpectedMessage>" is displayed

    Examples:
      | FirstName | LastName | Age | Phone | HouseNumber | City  | Address | Postcode | Email       | LoanAmount | ExpectedMessage                                    |
      | bob       | bill     | 12  | 123   | 4           | City  |         | 12345    | test@test   | 10000      | Error: Age must be 18 or over.                     |
      | bob       | bill     | 30  | 123   | 4           | City  |         | 12345    |             | 10000      | Please fill out this field.                         |
      | bob       | bill     | 30  | 123   | 4           | City  |         | 12345    | email       | 10000      | Please include an '@' in the email address. 'email' is missing an '@'.        |
      | bob       | bill     | 20  | 123   | 4           | City  |         | 12345    | test@test   | 10         | Error: Loan amount must be at least 1000.         |
      | bob       | bill     | 30  | 123   | 4           | City  |         |          | email@email | 10000      | Please fill out this field.                         |


