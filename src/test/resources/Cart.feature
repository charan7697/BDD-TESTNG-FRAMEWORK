@cart
Feature: Shopping cart

  Background:
    Given user is on the login page
    And user logs in with username "standard_user" and password "secret_sauce"

  @smoke
  Scenario: Add a product to the cart
    When user adds "Sauce Labs Backpack" to the cart
    Then cart badge should show "1"