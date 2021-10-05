Feature: Make the purchase of a product and add to shopping cart
  me as a costumer of Saucedemo
  need search and add products to shopping cart
  to verify a successful purchase

  Background:
    Given that the costumer enter to the webpage of Saucedemo
    When enter the personal data to access
      | user          | password     |
      | standard_user | secret_sauce |

  Scenario: Validate a successful Login
    Then the user could see products in the PRODUCTS page

  Scenario: Validate sort for Name (Z to A)
    When the user filter by Name (Z to A)
    Then user could see Test.allTheThings() T-Shirt (Red) first in the list

  Scenario: Validate sort for price low to high and add product to cart
    When the user filter by Price (low to high)
    Then user could see Sauce Labs Onesie first in the list
    When the user add product Sauce Labs Backpack, Sauce Labs Bike Light in the shopping car
    Then the user could see the products in the shopping car
    When the user remove the product Sauce Labs Backpack
    Then the product was removed correctly
    When the user end the purchase and buy a product
      | name   | lastName | zipCode |
      | Hernan | Barrera  | 5000    |
    Then the user can see the message Thank you for your order
    When the user close it's session
    Then the user is returned to initial page