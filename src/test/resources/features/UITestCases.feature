Feature: Automation Exercise UI Tests

  Background: Launch browser and website
    Given Launch browser
    When Navigate to url "http://automationexercise.com"
    Then Verify that home page is visible successfully

  @TC01
  Scenario Outline: TC01 Register end to end test
    Given Click on Signup Login button
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
      | name | email                | Title | Password | Day | Month   | Year | First name | Last name | Company    | Address     | Address2 | Country | State  | City        | Zipcode | Mobile Number |
      | John | John012578@gmail.com | Man   | Password | 1   | January | 2000 | John       | Wick      | ST Company | Company Str | No 52    | India   | Mumbai | Mumbai City | 25809   | 01252584569   |


  @TC02
  Scenario: TC02 Login User with correct email and password
    Given Click on Signup Login button
    Then Verify Login to your account is visible
    And Enter correct email address and password
    And Click login button
    Then Verify that Logged in as username is visible
    And Click Delete Account button
    Then After account deleted verify that "ACCOUNT DELETED!" is visible
    And close the page

  @TC03
  Scenario: TC03 Login User with incorrect email and password
    Given Click on Signup Login button
    Then Verify Login to your account is visible
    And Enter incorrect email address and password
    And Click login button
    Then Verify error your email or password is incorrect! is visible
    And close the page

  @TC04
  Scenario: TC04 Logout User
    Given Click on Signup Login button
    Then Verify Login to your account is visible
    And Enter correct email address and password
    And Click login button
    Then Verify that Logged in as username is visible
    And Click Logout button
    Then Verify that user is navigated to login page
    And close the page

