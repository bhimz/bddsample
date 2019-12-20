package com.bhimz.bddsample

import com.bhimz.bddsample.model.User
import com.bhimz.bddsample.repository.UserRepository
import com.bhimz.bddsample.repository.UserRepositoryImpl
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UserRepositoryTest {
    private val userRepository: UserRepository = UserRepositoryImpl()
    @Test
    fun saveAndRetrieveUser() {
        val username = "test"
        val password = "password"
        val user = User(username, password)

        userRepository.saveUser(user)
        val savedUser = userRepository.getUserByUsername(username)
        assertEquals("saved user should match", user, savedUser)
    }
}
