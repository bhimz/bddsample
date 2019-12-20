package com.bhimz.bddsample.robot

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.bhimz.bddsample.LoginActivity
import com.bhimz.bddsample.R
import com.bhimz.bddsample.model.User
import com.bhimz.bddsample.repository.UserRepository
import com.bhimz.bddsample.repository.UserRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest

class LoginRobot: KoinTest {
    private val testRule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java)
    private lateinit var userRepository: UserRepository

    fun setup() {
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

    fun tearDown() {
        stopKoin()
    }

    fun launchLogin() {
        testRule.launchActivity(null)
    }

    fun saveUserCredential(username: String, password: String) {
        userRepository.saveUser(User(username, password))
    }

    fun clickUserName() {
        onView(withId(R.id.txtUsername)).perform(click())
    }

    fun inputUserName(username: String) {
        onView(withId(R.id.txtUsername)).perform(typeText(username), closeSoftKeyboard())
    }

    fun clickPassword() {
        onView(withId(R.id.txtPassword)).perform(click())
    }

    fun inputPassword(password: String) {
        onView(withId(R.id.txtPassword)).perform(typeText(password), closeSoftKeyboard())

    }

    fun clickLogin() {
        onView(withId(R.id.btnLogin)).perform(click())
    }

    //Asserts

    fun assertLoginMessage(successMessage: String) {
        onView(withId(R.id.txtWelcome)).check(matches(withText(successMessage)))
    }

    fun assertLoginErrorMessage(warningMessage: String) {
        onView(withId(R.id.txtWelcome)).check(matches(withText(warningMessage)))
    }
}