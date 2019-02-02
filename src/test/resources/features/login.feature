Feature: Login functionality
  User should be logged in
  to user an application

  Background: User should be on login page
    Given user is on the login page

  Scenario: Login successfully with valid credentials
    When user enters valid username "Admin"
      And user enter valid password "admin123"
      And user clicks login button
    Then user should be redirected to home page

  Scenario: Login should not be able to login with invalid credentials
    When user enters invalid username "Whatever"
      And user enters invalid password "whatever"
      And user clicks login button
    Then user should see warning message "Invalid credentials"

  Scenario: Login should not be able to login without username
    When user enter valid password "admin123"
      And user clicks login button
    Then user should see warning message "Username cannot be empty"

  Scenario: Login should not be able to login without password
    When user enters valid username "Admin"
      And user clicks login button
    Then user should see warning message "Password cannot be empty"