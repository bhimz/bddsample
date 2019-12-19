package com.bhimz.bddsample.steps

import androidx.test.rule.ActivityTestRule
import com.bhimz.bddsample.LoginActivity
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import io.cucumber.datatable.DataTable


class LoginSteps {

    private val testRule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java)

    @Given("^User open login page$")
    fun openLoginPage() {
        testRule.launchActivity(null)
    }

    @Given("^Has the following user credentials$")
    fun populateUserCredentials(dataTable: DataTable) {
        val list: List<Map<String, String>> = dataTable.asMaps(String::class.java, String::class.java)

    }

    @When("^I clicked on username field$")
    fun clickUserName() {

    }

    @When("^I enter username \"([^\"]*)\"\$")
    fun inputUserName(username: String) {

    }

    @When("^I clicked on password field")
    fun clickPassword() {

    }

    @When("I enter password \"([^\"]*)\"\$")
    fun inputPassword() {

    }

    @When("^I clicked login button")
    fun clickLogin() {

    }

    //Asserts
    @Then("^I see successful login message$")
    fun assertLoginMessage() {

    }
}