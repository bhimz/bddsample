package com.bhimz.bddsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogin.setOnClickListener {
            if (txtPassword.text.isNullOrEmpty() || txtUsername.text.isNullOrEmpty()) {
                return@setOnClickListener
            }
            txtWelcome.visibility = View.VISIBLE
        }
    }
}
