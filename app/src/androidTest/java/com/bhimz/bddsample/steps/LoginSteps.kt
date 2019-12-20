package com.bhimz.bddsample.steps

import com.bhimz.bddsample.robot.LoginRobot
import cucumber.api.Scenario
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import io.cucumber.datatable.DataTable


class LoginSteps {

    private lateinit var robot: LoginRobot

    @Before
    fun setup(scenario: Scenario) {
        println("=============================================")
        println(" Scenario: ${scenario.name}")
        println("=============================================")
        robot = LoginRobot()
        robot.setup()
    }

    @After
    fun tearDown(scenario: Scenario) {
        println("=============================================")
        println(" Scenario: ${scenario.name} - status: ${scenario.status}")
        println("=============================================")
        robot.tearDown()
    }

    @Given("^User open login page$")
    fun openLoginPage() {
        robot.launchLogin()
    }

    @Given("^Has the following user credentials$")
    fun populateUserCredentials(dataTable: DataTable) {
        val credentials: List<Map<String, String>> = dataTable.asMaps(String::class.java, String::class.java)
        for (credential in credentials) {
            val username = credential["username"] ?: ""
            val password = credential["password"] ?: ""
            robot.saveUserCredential(username, password)
        }

    }

    @When("^I clicked on username field$")
    fun clickUserName() = robot.clickUserName()

    @When("^I enter username \"([^\"]*)\"\$")
    fun inputUserName(username: String) = robot.inputUserName(username)

    @When("^I clicked on password field")
    fun clickPassword() = robot.clickPassword()

    @When("I enter password \"([^\"]*)\"\$")
    fun inputPassword(password: String) = robot.inputPassword(password)

    @When("^I clicked login button")
    fun clickLogin() = robot.clickLogin()

    //Asserts
    @Then("^I see successful login message saying \"([^\"]*)\"\$")
    fun assertLoginMessage(successMessage: String) = robot.assertLoginMessage(successMessage)

    //Asserts
    @Then("^I see warning message saying \"([^\"]*)\"\$")
    fun assertLoginErrorMessage(warningMessage: String) = robot.assertLoginErrorMessage(warningMessage)
}