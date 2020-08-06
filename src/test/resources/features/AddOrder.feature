Feature: Add order
  As user, I want to be able to create new orders

  Scenario: 1.Verify product information
    Given user is on the login page
    And user logs in
    And user navigates to "Order" page
    When user enters product information
      | Product     | Quantity | Price per unit | Discount |
      | ScreenSaver | 12       | 20             | 10%      |
    And user click on calculate button
    Then user should verify that total 216 is displayed

  Scenario: 2. Create order
    Given user is on the login page
    And user logs in
    And user navigates to "Order" page
    When user enters address information
      | Customer name | Street | City     | State | Zip   |
      | Test User     | 5th av | New York | NY    | 10011 |
    And user enters payment information
      | Card | Card Nr:     | Expire date (mm/yy) |
      | Visa | 1234567890   | 09/24               |
    And user clicks on process button
    And user navigates to "View all orders" page
    Then user verifies that order is displayed
      | Name          | Product                 |
      | Test User     | ScreenSaver             |