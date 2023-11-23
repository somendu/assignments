Feature: Application Login

  Scenario: Admin page default login
    Given User is on Netbanking Login Page
    When User login into Application with "admin" and password "1234"
    Then Home page is displayed
    And Cards are displayed

  Scenario: User page default login
    Given User is on Netbanking Login Page
    When User login into Application with user1 and password 9023
    Then Home page is displayed
    And Cards are displayed

  Scenario Outline: User page default login
    Given User is on Netbanking Login Page
    When User login into Application with "<Username>" and password "<Password>" 
    Then Home page is displayed
    And Cards are displayed

    Examples: 
      | Username   | Password |
      | debituser  | hellodbu |
      | credituser | hellocdu |

 
   Scenario: User page default Sign up 
    Given User is on Practice Login Page
    When User sign up  into Application
    | somendu | 
    | maiti		|
    | sm@sm.com	|
    |	9004030800	|
    Then Home page is displayed
    And Cards are displayed