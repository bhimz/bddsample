Feature: User login
  Scenario: Successful Login
    Given User open login page
    And Has the following user credentials
    | username | password |
    | test     | test123  |
    When I clicked on username field
    And I enter username "test"
    And I clicked on password field
    And I enter password "test123"
    And I clicked login button
    Then I see successful login message