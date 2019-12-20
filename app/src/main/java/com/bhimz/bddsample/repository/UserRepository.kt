package com.bhimz.bddsample.repository

import com.bhimz.bddsample.model.User

interface UserRepository {
    fun saveUser(user: User)
    fun getUserByUsername(username: String): User?
}

class UserRepositoryImpl : UserRepository {
    private val userCache = mutableMapOf<String, User>()
    override fun saveUser(user: User) {
        userCache[user.username] = user
    }
    override fun getUserByUsername(username: String): User? =
        userCache[username]

}