
Feature: Automation Exercise Tests
  Background: Launch browser and website
    Given Launch browser
    When Navigate to url "http://automationexercise.com"
  @TC01
  Scenario Outline: TC01 Register end to end test
    Given Verify that home page is visible successfully
    And Click on Signup Login button
    Then Verify New User Signup! is visible
    And Enter "<name>" and "<email>" address
    And Click Signup button
    Then Verify that "ENTER ACCOUNT INFORMATION" is visible
    When Fill details: "<Title>", "<Password>", "<Day>", "<Month>","<Year>"
    And Select checkbox Sign up for our newsletter!
    And Select checkbox Receive special offers from our partners!
    When Fill details: "<First name>", "<Last name>", "<Company>", "<Address>", "<Address2>", "<Country>", "<State>", "<City>", "<Zipcode>", "<Mobile Number>"
    And Click Create Account button
    Then After account created verify that "ACCOUNT CREATED!" is visible
    And Click Continue button in Account Created Page
    Then Verify that Logged in as username is visible
    And Click Delete Account button
    Then After account deleted verify that "ACCOUNT DELETED!" is visible
    And click Continue button in Account Deleted Page
    And close the page


    Examples:
      | name      | email               | Title | Password | Day | Month   | Year | First name | Last name | Company    | Address     | Address2 | Country       | State  | City        | Zipcode | Mobile Number |
      | SaintJean | SaintJean@gmail.com | Man   | Password | 1   | January | 2000 | Jean       | Saint     | ST Company | Company Str | No 52    | India | Mumbai | Mumbai City | 25809   | 01252584569   |

