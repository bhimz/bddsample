package com.bhimz.bddsample.steps

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.rule.ActivityTestRule
import com.bhimz.bddsample.LoginActivity
import com.bhimz.bddsample.R
import cucumber.api.Scenario
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import io.cucumber.datatable.DataTable
import org.koin.test.KoinTest


class LoginSteps:KoinTest {

    private val testRule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java)

    @Before
    fun setup(scenario: Scenario) {
        println("=============================================")
        println(" Scenario: ${scenario.name}")
        println("=============================================")
    }

    @After
    fun tearDown(scenario: Scenario) {
        println("=============================================")
        println(" Scenario: ${scenario.name} - status: ${scenario.status}")
        println("=============================================")
    }

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
        onView(withId(R.id.txtUsername)).perform(click())
    }

    @When("^I enter username \"([^\"]*)\"\$")
    fun inputUserName(username: String) {
        onView(withId(R.id.txtUsername)).perform(typeText(username), closeSoftKeyboard())
    }

    @When("^I clicked on password field")
    fun clickPassword() {
        onView(withId(R.id.txtPassword)).perform(click())
    }

    @When("I enter password \"([^\"]*)\"\$")
    fun inputPassword(password: String) {
        onView(withId(R.id.txtPassword)).perform(typeText(password), closeSoftKeyboard())

    }

    @When("^I clicked login button")
    fun clickLogin() {
        onView(withId(R.id.btnLogin)).perform(click())
    }

    //Asserts
    @Then("^I see successful login message$")
    fun assertLoginMessage() {
        onView(withId(R.id.txtWelcome)).check(matches(isDisplayed()))
    }
}