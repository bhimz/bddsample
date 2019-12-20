Feature: User login
  Scenario: Successful Login
    Given User open login page
    And The following user credentials are valid
    | username | password |
    | test     | test123  |
    When I clicked on username field
    And I enter username "test"
    And I clicked on password field
    And I enter password "test123"
    And I clicked login button
    Then I see successful login message saying "Welcome, test"

  Scenario: Unsuccessful Login
    Given User open login page
    And The following user credentials are valid
      | username | password |
      | test     | test123  |
    When I clicked on username field
    And I enter username "test"
    And I clicked on password field
    And I enter password "test122"
    And I clicked login button
    Then I see warning message saying "Your username/password is not valid"

  Scenario: Empty password
    Given User open login page
    And The following user credentials are valid
      | username | password |
      | test     | test123  |
    When I clicked on username field
    And I enter username "test"
    And I clicked login button
    Then I see warning message saying "Your username/password is not valid"

  Scenario: Empty username
    Given User open login page
    And The following user credentials are valid
      | username | password |
      | test     | test123  |
    When I clicked on password field
    And I enter password "test123"
    And I clicked login button
    Then I see warning message saying "Your username/password is not valid"