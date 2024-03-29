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
                txtWelcome.text = "Your username/password is not valid"
                txtWelcome.visibility = View.VISIBLE
                return@setOnClickListener
            }
            val username = txtUsername.text.toString()
            val password = txtPassword.text.toString()
            val user = userRepository.getUserByUsername(username)
            val descriptionText = if(user != null && user.password == password) {
                "Welcome, $username"
            } else {
                "Your username/password is not valid"
            }
            txtWelcome.text = descriptionText
            txtWelcome.visibility = View.VISIBLE
        }
    }
}
