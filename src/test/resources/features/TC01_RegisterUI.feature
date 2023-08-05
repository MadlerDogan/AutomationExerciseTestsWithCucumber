@Register
Feature: TC 01 Register User

  Background:
    Given Launch browser
    When Navigate to url 'http://automationexercise.com'
    Then Verify that home page is visible successfully

  Scenario Outline:
    Given Click on Signup Login button
    Then Verify New User Signup! is visible
    And Enter name and email address
    And Click Signup button
    Then Verify that "ENTER ACCOUNT INFORMATION" is visible
    When Fill details: "<Title>", "<Name>", "<Email>", "<Password>", "<Date of birth>"
    And Select checkbox Sign up for our newsletter!
    And Select checkbox Receive special offers from our partners!
    When Fill details: "<First name>", "<Last name>", "<Company>", "<Address>", "<Address2>", "<Country>", "<State>", "<City>", "<Zipcode>", "<Mobile Number>"
    And Click Create Account button
    Then Verify that "ACCOUNT CREATED!" is visible
    And Click Continue button in Account Created Page
    And  if there is a popup add, close add
    Then Verify that Logged in as username is visible
    And Click Delete Account button
    Then Verify that "ACCOUNT DELETED!" is visible
    And click Continue button in Account Deleted Page
    And close the page
    Examples:
      | Title | Name | Email | Password | Date of birth | First name | Last name | Company | Address | Address2 | Country | State | City | Zipcode | Mobile Number |
