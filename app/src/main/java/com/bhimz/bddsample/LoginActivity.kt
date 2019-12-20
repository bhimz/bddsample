package com.bhimz.bddsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bhimz.bddsample.repository.UserRepository
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class LoginActivity : AppCompatActivity() {

    private val userRepository: UserRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogin.setOnClickListener {
            if (txtPassword.text.isNullOrEmpty() || txtUsername.text.isNullOrEmpty()) {
                return@setOnClickListener
            }
            val username = txtUsername.text.toString()
            val password = txtPassword.text.toString()
            val user = userRepository.getUserByUsername(username)
            val welcomeText = "Welcome, $username"
            txtWelcome.text = welcomeText
            txtWelcome.visibility = View.VISIBLE
        }
    }
}
