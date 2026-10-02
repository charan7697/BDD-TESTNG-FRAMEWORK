@login
  Feature: Login Functionality

    @smoke
    Scenario: Successful login with valid credentials
      Given user is on the login page
      When user logs in with username "standard_user" and password "secret_sauce"
      Then user should land on the products page

    @regression
    Scenario Outline: Login with invalid credentials
      Given user is on the login page
      When user logs in with username "<username>" and password "<password>"
      Then error message should contain "<error>"

      Examples:
        | username        | password     | error                         |
        | locked_out_user | secret_sauce | locked out                    |
        | standard_user   | wrong_pass   | do not match any user         |
        | invalid_user    | secret_sauce | do not match any user         |