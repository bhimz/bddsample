package com.bhimz.bddsample.steps

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.bhimz.bddsample.LoginActivity
import com.bhimz.bddsample.R
import com.bhimz.bddsample.model.User
import com.bhimz.bddsample.repository.UserRepository
import com.bhimz.bddsample.repository.UserRepositoryImpl
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.mock
import cucumber.api.Scenario
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import io.cucumber.datatable.DataTable
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest


class LoginSteps:KoinTest {

    private val testRule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java)
    private lateinit var userRepository:UserRepository

    @Before
    fun setup(scenario: Scenario) {
        println("=============================================")
        println(" Scenario: ${scenario.name}")
        println("=============================================")
        stopKoin()
        userRepository = UserRepositoryImpl()
        startKoin {
            androidContext(InstrumentationRegistry.getInstrumentation().context)
            modules(listOf(
                module {
                    single { userRepository }
                }
            ))
        }
    }

    @After
    fun tearDown(scenario: Scenario) {
        println("=============================================")
        println(" Scenario: ${scenario.name} - status: ${scenario.status}")
        println("=============================================")
        stopKoin()
    }

    @Given("^User open login page$")
    fun openLoginPage() {
        testRule.launchActivity(null)
    }

    @Given("^Has the following user credentials$")
    fun populateUserCredentials(dataTable: DataTable) {
        val credentials: List<Map<String, String>> = dataTable.asMaps(String::class.java, String::class.java)
        for (credential in credentials) {
            val username = credential["username"] ?: ""
            val password = credential["password"] ?: ""
            userRepository.saveUser(User(username, password))
        }

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
    @Then("^I see successful login message saying \"([^\"]*)\"\$")
    fun assertLoginMessage(successMessage: String) {
        onView(withId(R.id.txtWelcome)).check(matches(withText(successMessage)))
    }
}