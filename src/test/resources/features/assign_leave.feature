Feature: Assign leave

  Background: User should be logged in
    Given user is on the login page
    When user enters valid username "Admin"
      And user enter valid password "admin123"
      And user clicks login button
    Then user should be redirected to home page

  Scenario: User should be able to successfully assign a leave when all required fields are filled
    Given user is on the assign leave page
    When user fills all required fields
      And user confirms leave assignment
    Then user should see message "Successfully assigned"