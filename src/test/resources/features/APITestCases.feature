Feature: API TESTS
  @API_TC11
  Scenario Outline: TC11 POST To Create/Register User Account
     Given Request parameters : "<name>", "<email>", "<password>", "<title>", "<birth_date>", "<birth_month>", "<birth_year>","<firstname>", "<lastname>", "<company>", "<address1>", "<address2>", "<country>", "<zipcode>", "<state>", "<city>", "<mobile_number>"
     Then Verify Response Code: "<response_code>", Response Message as "<response_message>"

    Examples:
      | name | email          | password       | title | birth_date | birth_month | birth_year | firstname | lastname | company  | address1    | address2 | country | zipcode | state  | city        | mobile_number | response_code | response_message |
      | Arif | arif@marif.com | arif@marif.com | Mr    | 15         | January     | 2011       | Arif      | Arifan   | Arif CO. | Arif Street | No 15    | India   | 42803   | Mumbai | Mumbai City | 0123456987    | 201         | User created!    |
