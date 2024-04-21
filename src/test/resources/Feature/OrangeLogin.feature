@LoginPage
Feature: OrangeHRM login functionality

Scenario: Sceanrio to check login functionality with valid credential
Given User Open the chrome browser
When Users Open the URL
When Users enter username as "Admin" and password as "admin123"
And Clicks on the Login_button
Then user is Navigate on the Home Page
And Close the browser